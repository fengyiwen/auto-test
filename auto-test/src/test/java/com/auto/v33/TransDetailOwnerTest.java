package com.auto.v33;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.auto.AbstractAutoAPITest;

public class TransDetailOwnerTest extends AbstractAutoAPITest{
	
	protected static String api="/v33/trans/detail/owner";
	
	protected static String owner_mobile_read_yes="15601797971";
	protected static String owner_mobile_read_no="18017768242";
	
	protected static String owner_token_yes="c1c1235dde934afc9d78bdcf1453ab5b";
	protected static String owner_mem_no_yes="163028449";
	protected static String orderNo_yes="702628111151";
	
	protected static String owner_token_no="6ad169b2e34e46afbc309843ad66f9a1";
	protected static String owner_mem_no_no="104619422";
	protected static String orderNo_no="784146628061";
	
	protected static String url="";
	
	protected TransCommonUtil transCommon = new TransCommonUtil();
	
	@BeforeClass
	public void setup(){
		url = (String)super.getDataFromDB(TransCommonUtil.illegalDepositRule_URL_Sql).get("url");
		transCommon.setApi(api);	
	}
	
	
	@Test(description="车主看过违章押金信息，违章押金标示显示新增(illegalDepositRuleIsNew=0) ")
	public void testOwnerAlreadySeeIllegalDepositRule_Success(){
		 transCommon.verifyillegalDepositRuleIsNew(url, owner_token_yes, orderNo_yes, owner_mem_no_yes, owner_mobile_read_yes);
	}
	
	@Test(description="车主还没看过违章押金信息,违章押金标示显示新增(illegalDepositRuleIsNew=1)")
	public void testOwnerNotSeeIllegalDepositRule_Success(){		 
		 transCommon.verifyillegalDepositRuleIsNew(url, owner_token_no, orderNo_no, owner_mem_no_no, owner_mobile_read_no);
		 
	}
	

}
