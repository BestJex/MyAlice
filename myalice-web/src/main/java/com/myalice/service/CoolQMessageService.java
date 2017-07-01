package com.myalice.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myalice.beans.CoolQMessage;
import com.myalice.beans.CoolQResponse;
import com.myalice.domain.TalkRecord;
import com.myalice.services.ESQuestionService;
import com.myalice.services.TalkRecordService;
import com.myalice.utils.MyAliceUtils;
import com.myalice.utils.Tools;

@Service
public class CoolQMessageService {

	@Autowired
	protected ESQuestionService esQuestionService;

	@Autowired
	protected TalkRecordService talkRecordService;

	public CoolQResponse getMessageType(CoolQMessage cqMessage) {
		String message = MyAliceUtils.trimQQ(cqMessage.getMessage());
		String[] qqs = MyAliceUtils.parseQqs(cqMessage.getMessage());
		CoolQResponse response = new CoolQResponse();
		response.setAt_sender(true);
		response.setBan(false);
		response.setKick(false);
		// CoolQMessageType messageType =
		// CoolQMessageType.getCoolQMessageType(cqMessage.getMessage_type()) ;
		/* 如果没有AT其他QQ号，则是认为是提问 */
		if (ArrayUtils.isEmpty(qqs)) {
			searchAnswer(message, response);
		} else {
			if (qqs.length > 1) {
				searchAnswer(message, response);
			} else {
				TalkRecord talkRecord = talkRecordService.selectLastAsk(MyAliceUtils.toString(cqMessage.getGroup_id()),
						MyAliceUtils.toString(cqMessage.getUser_id()));
				if (null == talkRecord) {
					response.setReply("很抱歉，您AT的 [CQ:at,qq=" + qqs[0] + "] 没有提过未匹配的问题");
				} else {
					Map<String, Object> questionMap = new HashMap<>();
					questionMap.put("title", talkRecord.getContent());
					questionMap.put("state", 2);
					questionMap.put("questionType", 1);
					questionMap.put("create_user", "QQ：" + qqs[0]);
					questionMap.put("create_date", Tools.currentDate());

					response.setReply("非常感谢您的回答");
				}
			}
		}
		return null;
	}
	
	private void searchAnswer(String message, CoolQResponse response) {
		Map<String, Object> answer = esQuestionService.searchAnswer(message);
		if (null != answer) {
			response.setSearchContent(true);
			String anwser = MyAliceUtils.toString(answer.get("anwser")) ;
			response.setReply(String.format("%s \n来源%s", anwser, StringUtils.equals("1", MyAliceUtils.toString(answer.get("state")))
					? "官方" : MyAliceUtils.toString( answer.get("create_user") ))) ;
		} else {
			response.setSearchContent(false);
			response.setReply("很抱歉，我还不知道答案，群里知道此问题答案的请 @机器猫 @提问者 建议答案：xxxxx");
		}
	}
}