package com.auto.bo;

import java.sql.Timestamp;

public class TestCase {
	
	  private long id;
	  private String model; 
	  private String testCaes; 
	  private String expData; 
	  private String actData; 
	  private Timestamp createTime; 
	  private Timestamp updateTime; 
	  private String errorLog; 
	  private String testResultData; 
	  private String testData;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getTestCaes() {
		return testCaes;
	}
	public void setTestCaes(String testCaes) {
		this.testCaes = testCaes;
	}
	public String getExpData() {
		return expData;
	}
	public void setExpData(String expData) {
		this.expData = expData;
	}
	public String getActData() {
		return actData;
	}
	public void setActData(String actData) {
		this.actData = actData;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	public String getErrorLog() {
		return errorLog;
	}
	public void setErrorLog(String errorLog) {
		this.errorLog = errorLog;
	}
	public String getTestResultData() {
		return testResultData;
	}
	public void setTestResultData(String testResultData) {
		this.testResultData = testResultData;
	}
	public String getTestData() {
		return testData;
	}
	public void setTestData(String testData) {
		this.testData = testData;
	}	  

}
