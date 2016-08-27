package com.auto33;


import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;


import com.auto.http.HttpApi;


public class V33TransCarConditionInfo {
	private final static String baseUrl="http://10.0.3.213:7064";
	private HttpApi tool = new HttpApi();
	private String renterToken="d017c88db6e846eb87493adf447eb572";
	private String ownerToken="eeb27325c4d54151b81e535bef9ade87";
	
//	@Test(description="订单号校验（其他数据正确，用户登录状态）,订单号为null",groups="入参检查")	
//	public void testTransCarConditionInfo1(){
//		Map<String,Object> requestMap = new HashMap<String,Object>();
//		//--接口参数--start
//	    requestMap.put("orderNo",null);
//	    requestMap.put("token",renterToken);
//	    requestMap.put("userType","1");
//	    //--接口参数--end
//
//		Map<String, String> errorResposne = new HashMap<>();
//		errorResposne.put("resCode", "400001");
//		errorResposne.put("resMsg", "orderNo不能为空");
//		tool.url(baseUrl + "/v33/trans/car/condition/info")
//				.request(requestMap)
//				.expectErrorResponse(errorResposne)
//				.execute();
//	}
//	
//	@Test(description="订单号校验（其他数据正确，用户登录状态）,订单号为空字符串",groups="入参检查")	
//	public void testTransCarConditionInfo2(){
//		Map<String,Object> requestMap = new HashMap<String,Object>();
//		//--接口参数--start
//	    requestMap.put("orderNo","");
//	    requestMap.put("token",renterToken);
//	    requestMap.put("userType","1");
//	    //--接口参数--end
//
//		Map<String, String> errorResposne = new HashMap<>();
//		errorResposne.put("resCode", "400001");
//		errorResposne.put("resMsg", "orderNo不能为空");
//		tool.url(baseUrl + "/v33/trans/car/condition/info")
//				.request(requestMap)
//				.expectErrorResponse(errorResposne)
//				.execute();
//	}
//	
//	@Test(description="订单号校验（其他数据正确，用户登录状态）,订单号为空，不传",groups="入参检查")	
//	public void testTransCarConditionInfo3(){
//		Map<String,Object> requestMap = new HashMap<String,Object>();
//		//--接口参数--start
//	    requestMap.put("token",renterToken);
//	    requestMap.put("userType","1");
//	    //--接口参数--end
//
//		Map<String, String> errorResposne = new HashMap<>();
//		errorResposne.put("resCode", "400001");
//		errorResposne.put("resMsg", "orderNo不能为空");
//		tool.url(baseUrl + "/v33/trans/car/condition/info")
//				.request(requestMap)
//				.expectErrorResponse(errorResposne)
//				.execute();
//	}
//	
//	@Test(description="token校验（其他数据正确）,token为null",groups="入参检查")	
//	public void testTransCarConditionInfo4(){
//		Map<String,Object> requestMap = new HashMap<String,Object>();
//		//--接口参数--start
//		requestMap.put("orderNo","685395315061");
//	    requestMap.put("token",null);
//	    requestMap.put("userType","1");
//	    //--接口参数--end
//
//		Map<String, String> errorResposne = new HashMap<>();
//		errorResposne.put("resCode", "400001");
//		errorResposne.put("resMsg", "token不能为空");
//		tool.url(baseUrl + "/v33/trans/car/condition/info")
//				.request(requestMap)
//				.expectErrorResponse(errorResposne)
//				.execute();
//	}
//	
//	@Test(description="token校验（其他数据正确）,token为空字符",groups="入参检查")	
//	public void testTransCarConditionInfo6(){
//		Map<String,Object> requestMap = new HashMap<String,Object>();
//		//--接口参数--start
//		requestMap.put("orderNo","685395315061");
//	    requestMap.put("token","");
//	    requestMap.put("userType","1");
//	    //--接口参数--end
//
//		Map<String, String> errorResposne = new HashMap<>();
//		errorResposne.put("resCode", "200008");
//		errorResposne.put("resMsg", "没有登录或登录失效，请重新登录");
//		tool.url(baseUrl + "/v33/trans/car/condition/info")
//				.request(requestMap)
//				.expectErrorResponse(errorResposne)
//				.execute();
//	}
//	
//	@Test(description="token校验（其他数据正确）,token为空，不传",groups="入参检查")	
//	public void testTransCarConditionInfo5(){
//		Map<String,Object> requestMap = new HashMap<String,Object>();
//		//--接口参数--start
//		requestMap.put("orderNo","685395315061");
//	    requestMap.put("userType","1");
//	    //--接口参数--end
//
//		Map<String, String> errorResposne = new HashMap<>();
//		errorResposne.put("resCode", "400001");
//		errorResposne.put("resMsg", "token不能为空");
//		tool.url(baseUrl + "/v33/trans/car/condition/info")
//				.request(requestMap)
//				.expectErrorResponse(errorResposne)
//				.execute();
//	}
//	
//	@Test(description="token校验（其他数据正确）,token为0",groups="入参检查")	
//	public void testTransCarConditionInfo7(){
//		Map<String,Object> requestMap = new HashMap<String,Object>();
//		//--接口参数--start
//		requestMap.put("orderNo","685395315061");
//	    requestMap.put("token","0");
//	    requestMap.put("userType","1");
//	    //--接口参数--end
//
//		Map<String, String> errorResposne = new HashMap<>();
//		errorResposne.put("resCode", "200008");
//		errorResposne.put("resMsg", "没有登录或登录失效，请重新登录");
//		tool.url(baseUrl + "/v33/trans/car/condition/info")
//				.request(requestMap)
//				.expectErrorResponse(errorResposne)
//				.execute();
//	}
//	
//	@Test(description="token校验（其他数据正确）,token为过期token",groups="入参检查")	
//	public void testTransCarConditionInfo8(){
//		Map<String,Object> requestMap = new HashMap<String,Object>();
//		//--接口参数--start
//		requestMap.put("orderNo","685395315061");
//	    requestMap.put("token","fb2432cf12634327b7a71af6e723133d");
//	    requestMap.put("userType","1");
//	    //--接口参数--end
//
//		Map<String, String> errorResposne = new HashMap<>();
//		errorResposne.put("resCode", "200008");
//		errorResposne.put("resMsg", "没有登录或登录失效，请重新登录");
//		tool.url(baseUrl + "/v33/trans/car/condition/info")
//				.request(requestMap)
//				.expectErrorResponse(errorResposne)
//				.execute();
//	}
//	
//	@Test(description="用户类型校验（其他数据正确，用户登录状态）,用户类型为空",groups="入参检查")	
//	public void testTransCarConditionInfo9(){
//		Map<String,Object> requestMap = new HashMap<String,Object>();
//		//--接口参数--start
//		requestMap.put("orderNo","685395315061");
//	    requestMap.put("token",renterToken);
//	    requestMap.put("userType",null);
//	    //--接口参数--end
//
//		Map<String, String> errorResposne = new HashMap<>();
//		errorResposne.put("resCode", "400001");
//		errorResposne.put("resMsg", "userType不能为空");
//		tool.url(baseUrl + "/v33/trans/car/condition/info")
//				.request(requestMap)
//				.expectErrorResponse(errorResposne)
//				.execute();
//	}
	
	@Test(description="用户类型校验（其他数据正确，用户登录状态）,用户类型为空字符",groups="入参检查")	
	public void testTransCarConditionInfo10(){
		Map<String,Object> requestMap = new HashMap<String,Object>();
		//--接口参数--start
		requestMap.put("orderNo","685395315061");
	    requestMap.put("token",renterToken);
	    requestMap.put("userType","");
	    //--接口参数--end

		Map<String, String> errorResposne = new HashMap<>();
		errorResposne.put("resCode", "400001");
		errorResposne.put("resMsg", "userType不能为空");
		tool.url(baseUrl + "/v33/trans/car/condition/info")
				.request(requestMap)
				.expectErrorResponse(errorResposne)
				.execute();
	}
	
//	@Test(description="用户类型校验（其他数据正确，用户登录状态）,用户类型为空，不传",groups="入参检查")	
//	public void testTransCarConditionInfo11(){
//		Map<String,Object> requestMap = new HashMap<String,Object>();
//		//--接口参数--start
//		requestMap.put("orderNo","685395315061");
//	    requestMap.put("token",renterToken);
//	    //--接口参数--end
//
//		Map<String, String> errorResposne = new HashMap<>();
//		errorResposne.put("resCode", "400001");
//		errorResposne.put("resMsg", "userType不能为空");
//		tool.url(baseUrl + "/v33/trans/car/condition/info")
//				.request(requestMap)
//				.expectErrorResponse(errorResposne)
//				.execute();
//	}
//	
//	@Test(description="用户类型校验（其他数据正确，用户登录状态）,用户类型为非数字",groups="入参检查")	
//	public void testTransCarConditionInfo12(){
//		Map<String,Object> requestMap = new HashMap<String,Object>();
//		//--接口参数--start
//		requestMap.put("orderNo","685395315061");
//	    requestMap.put("token",renterToken);
//	    requestMap.put("userType","s");
//	    //--接口参数--end
//
//		Map<String, String> errorResposne = new HashMap<>();
//		errorResposne.put("resCode", "400001");
//		errorResposne.put("resMsg", "userType只能为1,2,3");
//		tool.url(baseUrl + "/v33/trans/car/condition/info")
//				.request(requestMap)
//				.expectErrorResponse(errorResposne)
//				.execute();
//	}
//	
//	@Test(description="用户类型校验（其他数据正确，用户登录状态）,用户类型为1、2、3以外的数字",groups="入参检查")	
//	public void testTransCarConditionInfo13(){
//		Map<String,Object> requestMap = new HashMap<String,Object>();
//		//--接口参数--start
//		requestMap.put("orderNo","685395315061");
//	    requestMap.put("token",renterToken);
//	    requestMap.put("userType","4");
//	    //--接口参数--end
//
//		Map<String, String> errorResposne = new HashMap<>();
//		errorResposne.put("resCode", "400001");
//		errorResposne.put("resMsg", "userType只能为1,2,3");
//		tool.url(baseUrl + "/v33/trans/car/condition/info")
//				.request(requestMap)
//				.expectErrorResponse(errorResposne)
//				.execute();
//	}
//	
//	@Test(description="租客取车照片已上传的总数为5张，还车为4张，期望返回的取车照片状态为1，还车照片状态为0（上传照片达到5张，状态变为待完善）",groups="入参检查")	
//	public void testTransCarConditionInfo14(){
//		Map<String,Object> requestMap = new HashMap<String,Object>();
//		//--接口参数--start
//		requestMap.put("orderNo","998325907061");
//	    requestMap.put("token",renterToken);
//	    requestMap.put("userType","1");
//	    //--接口参数--end
//
//		Map<String, Object> resultMap = new HashMap<>();
//		resultMap.put("getCarPhotoStatus", 1);
//		resultMap.put("revertCarPhotoStatus", 0);
//		tool.url(baseUrl + "/v33/trans/car/condition/info")
//				.request(requestMap)
//				.expectData(resultMap)
//				.execute();
//	}
//	
//	@Test(description="租客取车照片已上传的总数为4张，还车为5张，期望返回的取车照片状态为0，还车照片状态为1（上传照片达到5张，状态变为待完善）",groups="入参检查")	
//	public void testTransCarConditionInfo15(){
//		Map<String,Object> requestMap = new HashMap<String,Object>();
//		//--接口参数--start
//		requestMap.put("orderNo","685395315061");
//	    requestMap.put("token",renterToken);
//	    requestMap.put("userType","1");
//	    //--接口参数--end
//
//		Map<String, Object> resultMap = new HashMap<>();
//		resultMap.put("getCarPhotoStatus", 0);
//		resultMap.put("revertCarPhotoStatus", 1);
//		tool.url(baseUrl + "/v33/trans/car/condition/info")
//				.request(requestMap)
//				.expectData(resultMap)
//				.execute();
//	}
//	
//	@Test(description="查看车主取还车照片状态，都没有上传，期望返回状态都为待完善",groups="入参检查")	
//	public void testTransCarConditionInfo16(){
//		Map<String,Object> requestMap = new HashMap<String,Object>();
//		//--接口参数--start
//		requestMap.put("orderNo","685395315061");
//	    requestMap.put("token",ownerToken);
//	    requestMap.put("userType","2");
//	    //--接口参数--end
//
//		Map<String, Object> resultMap = new HashMap<>();
//		resultMap.put("getCarPhotoStatus", 0);
//		resultMap.put("revertCarPhotoStatus", 0);
//		tool.url(baseUrl + "/v33/trans/car/condition/info")
//				.request(requestMap)
//				.expectData(resultMap)
//				.execute();
//	}
//	
//	@Test(description="获取车主取还车照片状态，都已上传，且大于5张，期望返回状态都为已完成",groups="入参检查")	
//	public void testTransCarConditionInfo17(){
//		Map<String,Object> requestMap = new HashMap<String,Object>();
//		/*公共参数*/
//		//--公共参数--start
//		requestMap.put("AndroidId","7bbca705baca29c2");
//	    requestMap.put("AppChannelId","testmarket");
//	    requestMap.put("appName","atzucheApp");
//	    requestMap.put("AppVersion",40);
//	    requestMap.put("deviceName","NX403A");
//	    requestMap.put("IMEI","986CF51F6CD5");	    
//	    requestMap.put("OS","ANDROID");
//	    requestMap.put("OsVersion","17");
//	    requestMap.put("publicCityCode","021");
//	    requestMap.put("PublicLatitude","31.195604");
//	    requestMap.put("PublicLongitude","121.433582");
//	    requestMap.put("TD_Ad_CHANNEL","testmarket");
//	    requestMap.put("TD_App_CHANNEL","testmarket");
//	    //--公共参数---end
//
//		//--接口参数--start
//		requestMap.put("orderNo","998325907061");
//	    requestMap.put("token",ownerToken);
//	    requestMap.put("userType","2");
//	    //--接口参数--end
//
//		Map<String, Object> resultMap = new HashMap<>();
//		resultMap.put("getCarPhotoStatus", 1);
//		resultMap.put("revertCarPhotoStatus", 1);
//		tool.url(baseUrl + "/v33/trans/car/condition/info")
//				.headerMap(RequestHeaderMap.headerMap().get("AutoyolEs_AndroidApp"))
//				.request(requestMap)
//				.expectData(resultMap)
//				.execute();
//	}
}
