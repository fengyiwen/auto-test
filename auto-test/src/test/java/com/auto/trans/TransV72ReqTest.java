package com.auto.trans;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.auto.AbstractAutoAPITest;

public class TransV72ReqTest extends AbstractAutoAPITest{
	protected static String api="/trans/v72/req";
	
	protected static String token="0b2c6dae66594eb4bc86f577934df79b";
	protected static String publicToken="0b2c6dae66594eb4bc86f577934df79b";
	protected static String functionName="";//"v72/req";
	protected static String moduleName="trans";
	protected static String carNo="827364889";
	
	protected static String activityId="0"; // 什么作用
	protected static String mem_no="486828394";
	protected static String conPhone="18017768242";
	protected static String queryId="59778"; // 什么作用
	
	protected static String disCouponIds="";
	
	protected static String isLeaveCity="0";
	protected static String oilType="3";
	
	protected static String rentCity="上海";//"上海";
	protected static String rentReason="";
	protected static String rentTime="";
	protected static String revertTime="";
	
	protected static String sceneCode="EX001";
	protected static String source="1";
	
	
	//取车服务
	protected static String srvGetFlag="0";
	protected static String srvGetAddr="";
	protected static String srvGetLat="";
	protected static String srvGetLon="";
	//还车服务
	protected static String srvReturnFlag="0";
	protected static String srvReturnAddr="";
	protected static String srvReturnLat="";
	protected static String srvReturnLon="";
	
	
	protected static String useBal="0";
	protected static String abatement="1";
	
	
	public Map<String,Object> newRequest(){
//		String rentTime= "20160903130000";//super.getCurrentDateTime(dtFormat);
//		String revertTime ="20160904130000"; //super.getNextDateTime(rentTime, 1, dtFormat);
		Map<String,Object> request = super.createCommonRequestMap();
		request.put("carNo", carNo);
		request.put("FunctionName", functionName);
		request.put("ModuleName", moduleName);
		request.put("mem_no", mem_no);
		request.put("conPhone", conPhone);
		request.put("queryId", queryId);
		request.put("activityId", activityId);
		request.put("sceneCode", sceneCode);
		//租车时间
		request.put("rentTime","20160902130000" );
		request.put("revertTime", "20160903130000");
		request.put("oilType", oilType);
		request.put("rentCity", rentCity);
		request.put("isLeaveCity", isLeaveCity);
		
		//取还车服务
		request.put("srvGetFlag", srvGetFlag);
		request.put("srvReturnFlag", srvReturnFlag);
		
		request.put("useBal", useBal);
		request.put("source", source);
		request.put("abatement", abatement);
		request.put("token", token);
		request.put("publicToken", publicToken);
		
		
		return request;
	}
	
	@Test(description="不带优惠券+驾车不出城下单")
	public void testTransReqWithoutCoupon_Success(){
		Map<String,Object>  requestMap = newRequest();
		HashMap response = super.sendRequestAndGetResponse(api, requestMap);
		Assert.assertNotNull(response.get("orderNo"));
	}
	
	@Test(description="带钱包+驾车出城下单")
	public void testTransReqWithMoney_Success(){
		Map<String,Object>  orederReq = newRequest();
		orederReq.put("isLeaveCity", "1");
	}
	
	@Test(description="带优惠券下单")
	public void testTransReqWithCoupon_Success(){
		
	}
	
	@Test(description="对没设置不便交车的车下单")
	public void testTransReqWithoutBusyTimeLimit_Success(){
		
	}
	
	@Test(description="对设置不便交车的车下单")
	public void testTransReqWithBusyTimeLimit_Success(){
		
	}
	
	@Test(description="下单时间-半天")
	public void testTransReqWithHalfDay_Success(){
		
	}
	@Test(description="下单时间-7天，违章押金支付方式为预授权")
	public void testTransReqWith7Days_Success(){
		
	}
	
	@Test(description="下单时间-8天，违章押金支付方式为消费")
	public void testTransReqWith8Days_Success(){
		
	}
	
	@Test(description="下单时间-15天+用了不计免赔,超过15天按15天算")
	public void testTransReqWith15Days_Success(){
		
	}
	@Test(description="下单时间-25天+用了不计免赔,超过15天按15天算")
	public void testTransReqWith25Days_Success(){
		
	}
	
	@Test(description="下单时间-车主设置不便取环车时间在00:30~7:00,bugNo#7671")
	public void testTransReqWithBugNo7671_Success(){
		
	}
	
	
	@Test(description="15分钟内发起多次下单，系统返回出错信息")
	public void testTransReqWithMulitOrder_Failure(){
		
	}
	
	@Test(description="用户对自动接单的车下单")
	public void testTransReqWithAutoOrder_Success(){
		
	}
	
	@Test(description="用户对不是自动接单的车下单")
	public void testTransReqWithoutAutoOrder_Success(){
		
	}
	
	@Test(description="用户对最长可租时间下单")
	public void testTransReqWithMaxRentTimeOrder_Success(){
		
	}
	
//	@Test(description="用户对最短可租时间下单")
//	public void testTransReqWithMinRentTimeAutoOrder_Success(){
//		
//	}
//	
//	@Test(description="用户对不可租车下单，车已经被租")
//	public void testTransReqWithMinRentTimeAutoOrder_Success(){
//		
//	}
//	
//	@Test(description="用户对不可租车下单，车主设置不可租时间")
//	public void testTransReqWithMinRentTimeAutoOrder_Success(){
//		
//	}
	
	
	@Test(description="token为NULL，出错信息检验")
	public void testTransReqWithTokenNull_Failure(){
		testWithTokenNull_Failure(api);
	}
	
	@Test(description="token为空字符串，出错信息检验")
	public void testTransReqWithEmptyToken_Failure(){
		testWithEmptyToken_Failure(api);
	}
	
	@Test(description="token为无效，出错信息检验")
	public void testTransReqWithFakeToken_Failure(){
		super.testWithFakeToken_Failure(api);
	}
	
	
	
}
