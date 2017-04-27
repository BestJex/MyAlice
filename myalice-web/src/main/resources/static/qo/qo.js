var loadDataUrl = "/qo/listData";

$(function(){
	var page = $.getWellParam("page");
	var pageNum=1;
	if(page!=""){
		pageNum=page; 
	}
	/*加载词典,加载完词典，再加载页面数据*/
	loadDict( function(){
		btnSearch(pageNum);
	})
})
/*加载页面数据函数，搜索调用方法*/
function btnSearch(pageNum){
	var questionContent=$("#questionContent").val();
	var id=$("#id").val();
	loadData(loadDataUrl,{pageNum:pageNum,id:id,questionContent:questionContent})
}
/*直接读取数据*/
function loadData(url,param){
	$.get(url, param , function(data){
		showData($("#qoData"),data.list) ; 
		$('#pageToolbar').html(""); 
		/*分页按钮,初始化*/ 
		$('#pageToolbar').Paging({current:data.pageNum,pagesize:data.pageSize,count:data.total,callback:function(page,size,count){
			console.log( '当前第 ' +page +'页,每页 '+size+'条,总页数：'+count+'页' ) ;
			loadData(loadDataUrl , {pageNum:page});   
		}});
	} , "json")
}

function loadDict(callback){
	$.ajax({url:"/pub/orderTypes" ,
				traditional:true,
				dataType:"json" ,
			data:{dtypes:["orderType","orderState"]}
	,success:function(json){
		//$("#questionTypeTd").attr("fun" , html);  
		for(v in json){
			$("#td_" + v).attr("fun" , json[v]); 
		}
		callback();
	} } )
}


function show(id){
	window.location="/qo/view.html?id=" + id ; 
}

function accept(id){
	$.mypost("/qo/changeState" , {"state":2,id:id} , function(json){
		if(json.suc){
			btnSearch( $.getWellParam("page") );
		}
		bootbox.alert( json.msg );
	} , "json")
}