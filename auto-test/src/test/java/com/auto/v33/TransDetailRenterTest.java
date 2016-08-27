package com.auto.v33;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.auto.AbstractAutoAPITest;

public class TransDetailRenterTest extends AbstractAutoAPITest{
	
	protected static String api="/v33/trans/detail/renter";
	
	protected static String renter_mobile_read_yes="19871789029";
	protected static String renter_mobile_read_no="13917311887";
	
	protected static String renter_token_yes="34b9de5df51144e988e84595ef1e16ba";
	protected static String renter_mem_no_yes="486828394";
	protected static String orderNo_yes="176216918061";
	
	protected static String renter_token_no="a47fa50122034fb19b8ea3e291037cec";
	protected static String renter_mem_no_no="736574995";
	protected static String orderNo_no="784146628061";
	
	protected static String url="";
	
	protected TransCommonUtil transCommon = new TransCommonUtil();
	
	
	
	@BeforeClass
	public void setup(){
		url = (String)super.getDataFromDB(TransCommonUtil.illegalDepositRule_URL_Sql).get("url");
		transCommon.setApi(api);
		
		
		
	}
	
	
	
	@Test(description="租客看过违章押金信息，违章押金标示显示新增(illegalDepositRuleIsNew=0) ")
	public void testRentAlreadySeeIllegalDepositRule_Success(){		 
		 transCommon.verifyillegalDepositRuleIsNew(url, renter_token_yes, orderNo_yes, renter_mem_no_yes, renter_mobile_read_yes);
		 
		 
	}
	
	@Test(description="租客还没看过违章押金信息,违章押金标示显示新增(illegalDepositRuleIsNew=1)")
	public void testRentNotSeeIllegalDepositRule_Success(){
		 
		 transCommon.verifyillegalDepositRuleIsNew(url, renter_token_no, orderNo_no, renter_mem_no_no, renter_mobile_read_no);
		 
	}
	
	
	

}
