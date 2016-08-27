package com.auto.v33;

import java.util.HashMap;
import java.util.Map;

import com.auto.AbstractAutoAPITest;

/**
 * @author fengyiwen
 *
 */

public class TransCommonUtil extends AbstractAutoAPITest{
	
	//记录有返回，标示0；记录无返回，标示1
	protected static String illegalDepositRule_Version_Sql="SELECT b.version as version FROM member a, member_illegal_deposit_version_config b,"
			+ "sys_config c WHERE a.reg_no=b.mem_no AND b.version=c.item_value "
			+ "AND c.app_type='illegalDeposit' AND a.mobile='@mobile'";

	protected static String illegalDepositRule_URL_Sql="SELECT item_value AS url FROM sys_config"
			+ " WHERE app_type='illegalDeposit' AND item_key='ruleUrl'";
	
	public String api;
	
	
	public void verifyillegalDepositRuleIsNew(String url,String token,String orderNo,String memNo,String mobileNo){
		Map<String,Object> requestMap = super.createCommonRequestMap();
		 requestMap.put("token", token);
		 requestMap.put("orderNo", orderNo);
		 requestMap.put("mem_no", memNo);
		 Map<String,Object>  illegalDepositInfo = new HashMap<String,Object>();
		 illegalDepositInfo.put("illegalDepositRuleIsNew", illegalDepositRuleFlag(mobileNo));
		 illegalDepositInfo.put("illegalDepositRuleUrl", url);
		 Map<String,Object> expectedResponse = super.createCommonExpectedResponseMap();
		 expectedResponse.put("illegalDepositInfo", illegalDepositInfo);
		 super.sendRequestWithExpectedResponse(api, requestMap, expectedResponse);
	}
	
	
	public String getApi() {
		return api;
	}


	public void setApi(String api) {
		this.api = api;
	}


	public  String illegalDepositRuleFlag(String mobile){
		//String count= "";
		Map<String,Object> map = super.getDataFromDB(illegalDepositRule_Version_Sql.replace("@mobile", mobile));
		if (map==null){
			return "1";
		}else{
			return "0";
		}
		
//		if (count.equals(""))
//			return "1";
//		return "0";
	}

}
