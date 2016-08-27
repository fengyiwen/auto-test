package com.auto33;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.testng.annotations.Test;

import com.auto.http.CommonUtils;
import com.auto.http.HttpApi;
import com.auto.http.RequestHeaderMap;

public class V33TransCarConditionPhotoList {
	private final static String baseUrl="http://10.0.3.213:7064";
	private HttpApi tool = new HttpApi();
	private String renterToken="d017c88db6e846eb87493adf447eb572";
	private String ownerToken="eeb27325c4d54151b81e535bef9ade87";
	
	@Test(description="订单号校验（其他数据正确，用户登录状态）,订单号为null",groups="入参检查")	
	public void testTransCarConditionPhotoList1(){
		Map<String,Object> requestMap = new HashMap<String,Object>();
		//--接口参数--start
	    requestMap.put("orderNo",null);
	    requestMap.put("token",renterToken);
	    requestMap.put("userType","1");
	    requestMap.put("photoType","1");
	    //--接口参数--end

		Map<String, String> errorResposne = new HashMap<>();
		errorResposne.put("resCode", "400001");
		errorResposne.put("resMsg", "orderNo不能为空");
		tool.url(baseUrl + "/v33/trans/car/condition/photo/list")
				.request(requestMap)
				.expectErrorResponse(errorResposne)
				.execute();
	}
	
	@Test(description="订单号校验（其他数据正确，用户登录状态）,订单号为空字符串",groups="入参检查")	
	public void testTransCarConditionPhotoList2(){
		Map<String,Object> requestMap = new HashMap<String,Object>();
		//--接口参数--start
	    requestMap.put("orderNo","");
	    requestMap.put("token",renterToken);
	    requestMap.put("userType","1");
	    requestMap.put("photoType","1");
	    //--接口参数--end

		Map<String, String> errorResposne = new HashMap<>();
		errorResposne.put("resCode", "400001");
		errorResposne.put("resMsg", "orderNo不能为空");
		tool.url(baseUrl + "/v33/trans/car/condition/photo/list")
				.request(requestMap)
				.expectErrorResponse(errorResposne)
				.execute();
	}
	
	@Test(description="订单号校验（其他数据正确，用户登录状态）,订单号为空，不传",groups="入参检查")	
	public void testTransCarConditionPhotoList3(){
		Map<String,Object> requestMap = new HashMap<String,Object>();
		//--接口参数--start
	    requestMap.put("token",renterToken);
	    requestMap.put("userType","1");
	    requestMap.put("photoType","1");
	    //--接口参数--end

		Map<String, String> errorResposne = new HashMap<>();
		errorResposne.put("resCode", "400001");
		errorResposne.put("resMsg", "orderNo不能为空");
		tool.url(baseUrl + "/v33/trans/car/condition/photo/list")
				.request(requestMap)
				.expectErrorResponse(errorResposne)
				.execute();
	}
	
	@Test(description="token校验（其他数据正确）,token为null",groups="入参检查")	
	public void testTransCarConditionPhotoList4(){
		Map<String,Object> requestMap = new HashMap<String,Object>();
		//--接口参数--start
		requestMap.put("orderNo","685395315061");
	    requestMap.put("token",null);
	    requestMap.put("userType","1");
	    requestMap.put("photoType","1");
	    //--接口参数--end

		Map<String, String> errorResposne = new HashMap<>();
		errorResposne.put("resCode", "400001");
		errorResposne.put("resMsg", "token不能为空");
		tool.url(baseUrl + "/v33/trans/car/condition/photo/list")
				.request(requestMap)
				.expectErrorResponse(errorResposne)
				.execute();
	}
	
	@Test(description="token校验（其他数据正确）,token为空字符",groups="入参检查")	
	public void testTransCarConditionPhotoList5(){
		Map<String,Object> requestMap = new HashMap<String,Object>();
		//--接口参数--start
		requestMap.put("orderNo","685395315061");
	    requestMap.put("token","");
	    requestMap.put("userType","1");
	    requestMap.put("photoType","1");
	    //--接口参数--end

		Map<String, String> errorResposne = new HashMap<>();
		errorResposne.put("resCode", "200008");
		errorResposne.put("resMsg", "没有登录或登录失效，请重新登录");
		tool.url(baseUrl + "/v33/trans/car/condition/photo/list")
				.request(requestMap)
				.expectErrorResponse(errorResposne)
				.execute();
	}
	
	@Test(description="token校验（其他数据正确）,token为空，不传",groups="入参检查")	
	public void testTransCarConditionPhotoList6(){
		Map<String,Object> requestMap = new HashMap<String,Object>();
		//--接口参数--start
		requestMap.put("orderNo","685395315061");
	    requestMap.put("userType","1");
	    requestMap.put("photoType","1");
	    //--接口参数--end

		Map<String, String> errorResposne = new HashMap<>();
		errorResposne.put("resCode", "400001");
		errorResposne.put("resMsg", "token不能为空");
		tool.url(baseUrl + "/v33/trans/car/condition/photo/list")
				.request(requestMap)
				.expectErrorResponse(errorResposne)
				.execute();
	}
	
	@Test(description="token校验（其他数据正确）,token为0",groups="入参检查")	
	public void testTransCarConditionPhotoList7(){
		Map<String,Object> requestMap = new HashMap<String,Object>();
		//--接口参数--start
		requestMap.put("orderNo","685395315061");
	    requestMap.put("token","0");
	    requestMap.put("userType","1");
	    requestMap.put("photoType","1");
	    //--接口参数--end

		Map<String, String> errorResposne = new HashMap<>();
		errorResposne.put("resCode", "200008");
		errorResposne.put("resMsg", "没有登录或登录失效，请重新登录");
		tool.url(baseUrl + "/v33/trans/car/condition/photo/list")
				.request(requestMap)
				.expectErrorResponse(errorResposne)
				.execute();
	}
	
	@Test(description="token校验（其他数据正确）,token为过期token",groups="入参检查")	
	public void testTransCarConditionPhotoList8(){
		Map<String,Object> requestMap = new HashMap<String,Object>();
		//--接口参数--start
		requestMap.put("orderNo","685395315061");
	    requestMap.put("token","fb2432cf12634327b7a71af6e723133d");
	    requestMap.put("userType","1");
	    //--接口参数--end

		Map<String, String> errorResposne = new HashMap<>();
		errorResposne.put("resCode", "200008");
		errorResposne.put("resMsg", "没有登录或登录失效，请重新登录");
		tool.url(baseUrl + "/v33/trans/car/condition/photo/list")
				.request(requestMap)
				.expectErrorResponse(errorResposne)
				.execute();
	}
	
	@Test(description="用户类型校验（其他数据正确，用户登录状态）,用户类型为空",groups="入参检查")	
	public void testTransCarConditionPhotoList9(){
		Map<String,Object> requestMap = new HashMap<String,Object>();
		//--接口参数--start
		requestMap.put("orderNo","685395315061");
	    requestMap.put("token",renterToken);
	    requestMap.put("userType",null);
	    requestMap.put("photoType","1");
	    //--接口参数--end

		Map<String, String> errorResposne = new HashMap<>();
		errorResposne.put("resCode", "400001");
		errorResposne.put("resMsg", "userType不能为空");
		tool.url(baseUrl + "/v33/trans/car/condition/photo/list")
				.request(requestMap)
				.expectErrorResponse(errorResposne)
				.execute();
	}
	
	@Test(description="用户类型校验（其他数据正确，用户登录状态）,用户类型为空字符",groups="入参检查")	
	public void testTransCarConditionPhotoList10(){
		Map<String,Object> requestMap = new HashMap<String,Object>();
		//--接口参数--start
		requestMap.put("orderNo","685395315061");
	    requestMap.put("token",renterToken);
	    requestMap.put("userType","");
	    requestMap.put("photoType","1");
	    //--接口参数--end

		Map<String, String> errorResposne = new HashMap<>();
		errorResposne.put("resCode", "400001");
		errorResposne.put("resMsg", "userType不能为空");
		tool.url(baseUrl + "/v33/trans/car/condition/photo/list")
				.request(requestMap)
				.expectErrorResponse(errorResposne)
				.execute();
	}
	
	@Test(description="用户类型校验（其他数据正确，用户登录状态）,用户类型为空，不传",groups="入参检查")	
	public void testTransCarConditionPhotoList11(){
		Map<String,Object> requestMap = new HashMap<String,Object>();
		//--接口参数--start
		requestMap.put("orderNo","685395315061");
	    requestMap.put("token",renterToken);
	    requestMap.put("photoType","1");
	    //--接口参数--end

		Map<String, String> errorResposne = new HashMap<>();
		errorResposne.put("resCode", "400001");
		errorResposne.put("resMsg", "userType不能为空");
		tool.url(baseUrl + "/v33/trans/car/condition/photo/list")
				.request(requestMap)
				.expectErrorResponse(errorResposne)
				.execute();
	}
	
	@Test(description="用户类型校验（其他数据正确，用户登录状态）,用户类型为非数字",groups="入参检查")	
	public void testTransCarConditionPhotoList12(){
		Map<String,Object> requestMap = new HashMap<String,Object>();
		//--接口参数--start
		requestMap.put("orderNo","685395315061");
	    requestMap.put("token",renterToken);
	    requestMap.put("userType","s");
	    requestMap.put("photoType","1");
	    //--接口参数--end

		Map<String, String> errorResposne = new HashMap<>();
		errorResposne.put("resCode", "400001");
		errorResposne.put("resMsg", "userType只能为1,2,3");
		tool.url(baseUrl + "/v33/trans/car/condition/photo/list")
				.request(requestMap)
				.expectErrorResponse(errorResposne)
				.execute();
	}
	
	@Test(description="用户类型校验（其他数据正确，用户登录状态）,用户类型为1、2、3以外的数字",groups="入参检查")	
	public void testTransCarConditionPhotoList13(){
		Map<String,Object> requestMap = new HashMap<String,Object>();
		//--接口参数--start
		requestMap.put("orderNo","685395315061");
	    requestMap.put("token",renterToken);
	    requestMap.put("userType","4");
	    requestMap.put("photoType","1");
	    //--接口参数--end

		Map<String, String> errorResposne = new HashMap<>();
		errorResposne.put("resCode", "400001");
		errorResposne.put("resMsg", "userType只能为1,2,3");
		tool.url(baseUrl + "/v33/trans/car/condition/photo/list")
				.request(requestMap)
				.expectErrorResponse(errorResposne)
				.execute();
	}
	
	@Test(description="照片类型为空校验1）",groups="入参检查")	
	public void testTransCarConditionPhotoList14(){
		Map<String,Object> requestMap = new HashMap<String,Object>();
		//--接口参数--start
		requestMap.put("orderNo","998325907061");
	    requestMap.put("token",renterToken);
	    requestMap.put("userType","1");
	    requestMap.put("photoType","");
	    //--接口参数--end

	    Map<String, String> errorResposne = new HashMap<>();
		errorResposne.put("resCode", "400001");
		errorResposne.put("resMsg", "photoType不能为空");
		tool.url(baseUrl + "/v33/trans/car/condition/photo/list")
				.request(requestMap)
				.expectErrorResponse(errorResposne)
				.execute();
	}
	
	@Test(description="照片类型为空校验2）",groups="入参检查")	
	public void testTransCarConditionPhotoList15(){
		Map<String,Object> requestMap = new HashMap<String,Object>();
		//--接口参数--start
		requestMap.put("orderNo","998325907061");
	    requestMap.put("token",renterToken);
	    requestMap.put("userType","1");
	    requestMap.put("photoType","  ");
	    //--接口参数--end

	    Map<String, String> errorResposne = new HashMap<>();
		errorResposne.put("resCode", "400001");
		errorResposne.put("resMsg", "photoType不能为空");
		tool.url(baseUrl + "/v33/trans/car/condition/photo/list")
				.request(requestMap)
				.expectErrorResponse(errorResposne)
				.execute();
	}
	
	@Test(description="照片类型为空校验3）",groups="入参检查")	
	public void testTransCarConditionPhotoList16(){
		Map<String,Object> requestMap = new HashMap<String,Object>();
		//--接口参数--start
		requestMap.put("orderNo","998325907061");
	    requestMap.put("token",renterToken);
	    requestMap.put("userType","1");
	    requestMap.put("photoType",null);
	    //--接口参数--end

	    Map<String, String> errorResposne = new HashMap<>();
		errorResposne.put("resCode", "400001");
		errorResposne.put("resMsg", "photoType不能为空");
		tool.url(baseUrl + "/v33/trans/car/condition/photo/list")
				.request(requestMap)
				.expectErrorResponse(errorResposne)
				.execute();
	}
	
	@Test(description="照片类型为空校验4）",groups="入参检查")	
	public void testTransCarConditionPhotoList17(){
		Map<String,Object> requestMap = new HashMap<String,Object>();
		//--接口参数--start
		requestMap.put("orderNo","998325907061");
	    requestMap.put("token",renterToken);
	    requestMap.put("userType","1");
	    //--接口参数--end

	    Map<String, String> errorResposne = new HashMap<>();
		errorResposne.put("resCode", "400001");
		errorResposne.put("resMsg", "photoType不能为空");
		tool.url(baseUrl + "/v33/trans/car/condition/photo/list")
				.request(requestMap)
				.expectErrorResponse(errorResposne)
				.execute();
	}
	
	@Test(description="照片类型输入参数校验1）",groups="入参检查")	
	public void testTransCarConditionPhotoList19(){
		Map<String,Object> requestMap = new HashMap<String,Object>();
		//--接口参数--start
		requestMap.put("orderNo","998325907061");
	    requestMap.put("token",renterToken);
	    requestMap.put("userType","1");
	    requestMap.put("photoType","4");
	    //--接口参数--end

	    Map<String, String> errorResposne = new HashMap<>();
		errorResposne.put("resCode", "400001");
		errorResposne.put("resMsg", "photoType只能为1,2");
		tool.url(baseUrl + "/v33/trans/car/condition/photo/list")
				.request(requestMap)
				.expectErrorResponse(errorResposne)
				.execute();
	}
	
	@Test(description="照片类型输入参数校验2）",groups="入参检查")	
	public void testTransCarConditionPhotoList20(){
		Map<String,Object> requestMap = new HashMap<String,Object>();
		//--接口参数--start
		requestMap.put("orderNo","998325907061");
	    requestMap.put("token",renterToken);
	    requestMap.put("userType","1");
	    requestMap.put("photoType","ss");
	    //--接口参数--end

	    Map<String, String> errorResposne = new HashMap<>();
		errorResposne.put("resCode", "400001");
		errorResposne.put("resMsg", "photoType只能为1,2");
		tool.url(baseUrl + "/v33/trans/car/condition/photo/list")
				.request(requestMap)
				.expectErrorResponse(errorResposne)
				.execute();
	}
	
	@Test(description="租客查看的自己的取车照片",groups="入参检查")	
	public void testTransCarConditionPhotoList21(){
		Map<String,Object> requestMap = new HashMap<String,Object>();
		//--接口参数--start
		requestMap.put("orderNo","685395315061");
	    requestMap.put("token",renterToken);
	    requestMap.put("userType","1");
	    requestMap.put("photoType","1");
	    //--接口参数--end

	    String expectJson="{data=[{serialNumber=1, url=16/07/685395315061/claim/ce4f2d98-abae-4b1c-91f1-638356e87db0.jpg}, {serialNumber=2, url=16/07/685395315061/claim/06424e40-0905-48ff-bfd9-9c34d7fa05a3.jpg}, {serialNumber=3, url=16/07/685395315061/claim/94e68bc9-6b4a-477d-acfa-9c776b185e4f.jpg}, {serialNumber=4, url=16/07/685395315061/claim/08ccf32f-938a-44c8-bdb4-64af616aab78.jpg}], resCode=000000, resMsg=success}";

		tool.url(baseUrl + "/v33/trans/car/condition/photo/list")
				.request(requestMap)
				.expectJson(expectJson)
				.execute();
	}
	
	@Test(description="租客查看的自己的还车照片",groups="入参检查")	
	public void testTransCarConditionPhotoList22(){
		Map<String,Object> requestMap = new HashMap<String,Object>();
		//--接口参数--start
		requestMap.put("orderNo","685395315061");
	    requestMap.put("token",renterToken);
	    requestMap.put("userType","1");
	    requestMap.put("photoType","2");
	    //--接口参数--end

	    String expectJson="{data=[{serialNumber=1, url=16/07/685395315061/claim/2c251f0b-07f9-42f7-b889-b50b60856d78.jpg}, {serialNumber=2, url=16/07/685395315061/claim/46bc05b4-0e5e-43a9-bbaf-706b6ac4014a.jpg}, {serialNumber=3, url=16/07/685395315061/claim/a0af21b4-f7a7-436b-b083-47689d71243a.jpg}, {serialNumber=4, url=16/07/685395315061/claim/f1a44dc7-8467-457b-afe1-3aac10c70518.jpg}, {serialNumber=5, url=16/07/685395315061/claim/6d40444e-454f-4742-aab5-30d8442daf65.jpg}], resCode=000000, resMsg=success}";
		tool.url(baseUrl + "/v33/trans/car/condition/photo/list")
				.request(requestMap)
				.expectJson(expectJson)
				.execute();
	}
	
	@Test(description="租客查看的平台的取车照片",groups="入参检查")	
	public void testTransCarConditionPhotoList23(){
		Map<String,Object> requestMap = new HashMap<String,Object>();
		//--接口参数--start
		requestMap.put("orderNo","685395315061");
	    requestMap.put("token",renterToken);
	    requestMap.put("userType","3");
	    requestMap.put("photoType","1");
	    //--接口参数--end

	    String expectJson="{data=[{serialNumber=0, url=685395315061/1468240300865.jpg}, {serialNumber=0, url=685395315061/1468240302238.jpg}], resCode=000000, resMsg=success}";
		tool.url(baseUrl + "/v33/trans/car/condition/photo/list")
				.request(requestMap)
				.expectJson(expectJson)
				.execute();
	}
	
	@Test(description="租客查看的平台的还车照片",groups="入参检查")	
	public void testTransCarConditionPhotoList24(){
		Map<String,Object> requestMap = new HashMap<String,Object>();
		//--接口参数--start
		requestMap.put("orderNo","685395315061");
	    requestMap.put("token",renterToken);
	    requestMap.put("userType","3");
	    requestMap.put("photoType","2");
	    //--接口参数--end

	    String expectJson="{data=[{serialNumber=0, url=685395315061/1468240280312.jpg}], resCode=000000, resMsg=success}";
		tool.url(baseUrl + "/v33/trans/car/condition/photo/list")
				.request(requestMap)
				.expectJson(expectJson)
				.execute();
	}
	
	@Test(description="车主查看的自己的取车照片",groups="入参检查")	
	public void testTransCarConditionPhotoList25(){
		Map<String,Object> requestMap = new HashMap<String,Object>();
		//--接口参数--start
		requestMap.put("orderNo","685395315061");
	    requestMap.put("token",renterToken);
	    requestMap.put("userType","2");
	    requestMap.put("photoType","1");
	    //--接口参数--end

	    String expectJson="{data=null, resCode=000000, resMsg=success}";

		tool.url(baseUrl + "/v33/trans/car/condition/photo/list")
				.request(requestMap)
				.expectJson(expectJson)
				.execute();
	}
	
	@Test(description="车主查看的自己的还车照片",groups="入参检查")	
	public void testTransCarConditionPhotoList26(){
		Map<String,Object> requestMap = new HashMap<String,Object>();
		//--接口参数--start
		requestMap.put("orderNo","685395315061");
	    requestMap.put("token",renterToken);
	    requestMap.put("userType","2");
	    requestMap.put("photoType","2");
	    //--接口参数--end

	    String expectJson="{data=[{serialNumber=1, url=16/07/685395315061/claim/2c251f0b-07f9-42f7-b889-b50b60856d78.jpg}, {serialNumber=2, url=16/07/685395315061/claim/46bc05b4-0e5e-43a9-bbaf-706b6ac4014a.jpg}, {serialNumber=3, url=16/07/685395315061/claim/a0af21b4-f7a7-436b-b083-47689d71243a.jpg}, {serialNumber=4, url=16/07/685395315061/claim/f1a44dc7-8467-457b-afe1-3aac10c70518.jpg}, {serialNumber=5, url=16/07/685395315061/claim/6d40444e-454f-4742-aab5-30d8442daf65.jpg}], resCode=000000, resMsg=success}";
		tool.url(baseUrl + "/v33/trans/car/condition/photo/list")
				.request(requestMap)
				.expectJson(expectJson)
				.execute();
	}
}
