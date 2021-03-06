package org.myalice.domain.websocket;

import java.util.Date;

public class Evaluation {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column evaluation.id
     *
     * @mbg.generated
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column evaluation.customer_id
     *
     * @mbg.generated
     */
    private String customerId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column evaluation.customer_conn_id
     *
     * @mbg.generated
     */
    private String customerConnId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column evaluation.score
     *
     * @mbg.generated
     */
    private Integer score;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column evaluation.create_time
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column evaluation.id
     *
     * @return the value of evaluation.id
     *
     * @mbg.generated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column evaluation.id
     *
     * @param id the value for evaluation.id
     *
     * @mbg.generated
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column evaluation.customer_id
     *
     * @return the value of evaluation.customer_id
     *
     * @mbg.generated
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column evaluation.customer_id
     *
     * @param customerId the value for evaluation.customer_id
     *
     * @mbg.generated
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column evaluation.customer_conn_id
     *
     * @return the value of evaluation.customer_conn_id
     *
     * @mbg.generated
     */
    public String getCustomerConnId() {
        return customerConnId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column evaluation.customer_conn_id
     *
     * @param customerConnId the value for evaluation.customer_conn_id
     *
     * @mbg.generated
     */
    public void setCustomerConnId(String customerConnId) {
        this.customerConnId = customerConnId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column evaluation.score
     *
     * @return the value of evaluation.score
     *
     * @mbg.generated
     */
    public Integer getScore() {
        return score;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column evaluation.score
     *
     * @param score the value for evaluation.score
     *
     * @mbg.generated
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column evaluation.create_time
     *
     * @return the value of evaluation.create_time
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column evaluation.create_time
     *
     * @param createTime the value for evaluation.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}