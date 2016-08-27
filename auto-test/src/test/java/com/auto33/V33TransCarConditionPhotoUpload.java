package com.auto33;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.annotations.Where;
import org.testng.annotations.Test;

import com.auto.http.CommonUtils;
import com.auto.http.HttpApi;

public class V33TransCarConditionPhotoUpload {
	private final static String baseUrl="http://10.0.3.213:7064";
	private HttpApi tool = new HttpApi();
	private String picUrl=System.getProperty("user.dir")+"/src/test/resources/pic/TransCarConditionPic/car0.jpg";
	private String renterToken="d017c88db6e846eb87493adf447eb572";
	private String ownerToken="eeb27325c4d54151b81e535bef9ade87";
	
	@Test(description="订单号校验（其他数据正确，用户登录状态）,订单号为null",groups="入参检查")	
	public void testTransCarConditionPhotoUpload1(){
		Map<String,Object> requestMap = new HashMap<String,Object>();
		//--接口参数--start
	    requestMap.put("orderNo",null);
	    requestMap.put("token",renterToken);
	    requestMap.put("userType","1");
	    requestMap.put("photoType","1");
	    requestMap.put("photoContent","1");
	    requestMap.put("serialNumber","1");
	    //--接口参数--end

		Map<String, String> errorResposne = new HashMap<>();
		errorResposne.put("resCode", "400001");
		errorResposne.put("resMsg", "orderNo不能为空");
		tool.url(baseUrl + "/v33/trans/car/condition/photo/upload")
				.request(requestMap)
				.expectErrorResponse(errorResposne)
				.execute();
	}
	
	@Test(description="订单号校验（其他数据正确，用户登录状态）,订单号为空字符串",groups="入参检查")	
	public void testTransCarConditionPhotoUpload2(){
		Map<String,Object> requestMap = new HashMap<String,Object>();
		//--接口参数--start
	    requestMap.put("orderNo"," ");
	    requestMap.put("token",renterToken);
	    requestMap.put("userType","1");
	    requestMap.put("photoType","1");
	    requestMap.put("photoContent","1");
	    requestMap.put("serialNumber","1");
	    //--接口参数--end

		Map<String, String> errorResposne = new HashMap<>();
		errorResposne.put("resCode", "400001");
		errorResposne.put("resMsg", "orderNo不能为空");
		tool.url(baseUrl + "/v33/trans/car/condition/photo/upload")
				.request(requestMap)
				.expectErrorResponse(errorResposne)
				.execute();
	}
	
	@Test(description="订单号校验（其他数据正确，用户登录状态）,订单号为空，不传",groups="入参检查")	
	public void testTransCarConditionPhotoUpload3(){
		Map<String,Object> requestMap = new HashMap<String,Object>();
		//--接口参数--start
	    requestMap.put("token",renterToken);
	    requestMap.put("userType","1");
	    requestMap.put("photoType","1");
	    requestMap.put("photoContent","1");
	    requestMap.put("serialNumber","1");
	    //--接口参数--end

		Map<String, String> errorResposne = new HashMap<>();
		errorResposne.put("resCode", "400001");
		errorResposne.put("resMsg", "orderNo不能为空");
		tool.url(baseUrl + "/v33/trans/car/condition/photo/upload")
				.request(requestMap)
				.expectErrorResponse(errorResposne)
				.execute();
	}
	
	@Test(description="token校验（其他数据正确）,token为null",groups="入参检查")	
	public void testTransCarConditionPhotoUpload4(){
		Map<String,Object> requestMap = new HashMap<String,Object>();
		//--接口参数--start
		requestMap.put("orderNo","685395315061");
	    requestMap.put("token",null);
	    requestMap.put("userType","1");
	    requestMap.put("photoType","1");
	    requestMap.put("photoContent","1");
	    requestMap.put("serialNumber","1");
	    //--接口参数--end

		Map<String, String> errorResposne = new HashMap<>();
		errorResposne.put("resCode", "400001");
		errorResposne.put("resMsg", "token不能为空");
		tool.url(baseUrl + "/v33/trans/car/condition/photo/upload")
				.request(requestMap)
				.expectErrorResponse(errorResposne)
				.execute();
	}
	
	@Test(description="token校验（其他数据正确）,token为空字符",groups="入参检查")	
	public void testTransCarConditionPhotoUpload6(){
		Map<String,Object> requestMap = new HashMap<String,Object>();
		//--接口参数--start
		requestMap.put("orderNo","685395315061");
	    requestMap.put("token","");
	    requestMap.put("userType","1");
	    requestMap.put("photoType","1");
	    requestMap.put("photoContent","1");
	    requestMap.put("serialNumber","1");
	    //--接口参数--end

		Map<String, String> errorResposne = new HashMap<>();
		errorResposne.put("resCode", "200008");
		errorResposne.put("resMsg", "没有登录或登录失效，请重新登录");
		tool.url(baseUrl + "/v33/trans/car/condition/photo/upload")
				.request(requestMap)
				.expectErrorResponse(errorResposne)
				.execute();
	}
	
	@Test(description="token校验（其他数据正确）,token为空，不传",groups="入参检查")	
	public void testTransCarConditionPhotoUpload5(){
		Map<String,Object> requestMap = new HashMap<String,Object>();
		//--接口参数--start
		requestMap.put("orderNo","685395315061");
	    requestMap.put("userType","1");
	    requestMap.put("photoType","1");
	    requestMap.put("photoContent","1");
	    requestMap.put("serialNumber","1");
	    //--接口参数--end

		Map<String, String> errorResposne = new HashMap<>();
		errorResposne.put("resCode", "400001");
		errorResposne.put("resMsg", "token不能为空");
		tool.url(baseUrl + "/v33/trans/car/condition/photo/upload")
				.request(requestMap)
				.expectErrorResponse(errorResposne)
				.execute();
	}
	
	@Test(description="token校验（其他数据正确）,token为0",groups="入参检查")	
	public void testTransCarConditionPhotoUpload7(){
		Map<String,Object> requestMap = new HashMap<String,Object>();
		//--接口参数--start
		requestMap.put("orderNo","685395315061");
	    requestMap.put("token","0");
	    requestMap.put("userType","1");
	    requestMap.put("photoType","1");
	    requestMap.put("photoContent","1");
	    requestMap.put("serialNumber","1");
	    //--接口参数--end

		Map<String, String> errorResposne = new HashMap<>();
		errorResposne.put("resCode", "200008");
		errorResposne.put("resMsg", "没有登录或登录失效，请重新登录");
		tool.url(baseUrl + "/v33/trans/car/condition/photo/upload")
				.request(requestMap)
				.expectErrorResponse(errorResposne)
				.execute();
	}
	
	@Test(description="token校验（其他数据正确）,token为过期token",groups="入参检查")	
	public void testTransCarConditionPhotoUpload8(){
		Map<String,Object> requestMap = new HashMap<String,Object>();
		//--接口参数--start
		requestMap.put("orderNo","685395315061");
	    requestMap.put("token","fb2432cf12634327b7a71af6e723133d");
	    requestMap.put("userType","1");
	    requestMap.put("photoType","1");
	    requestMap.put("photoContent","1");
	    requestMap.put("serialNumber","1");
	    //--接口参数--end

		Map<String, String> errorResposne = new HashMap<>();
		errorResposne.put("resCode", "200008");
		errorResposne.put("resMsg", "没有登录或登录失效，请重新登录");
		tool.url(baseUrl + "/v33/trans/car/condition/photo/upload")
				.request(requestMap)
				.expectErrorResponse(errorResposne)
				.execute();
	}
	
	@Test(description="用户类型校验（其他数据正确，用户登录状态）,用户类型为空",groups="入参检查")	
	public void testTransCarConditionPhotoUpload9(){
		Map<String,Object> requestMap = new HashMap<String,Object>();
		//--接口参数--start
		requestMap.put("orderNo","685395315061");
	    requestMap.put("token",renterToken);
	    requestMap.put("userType",null);
	    requestMap.put("photoType","1");
	    requestMap.put("photoContent","1");
	    requestMap.put("serialNumber","1");
	    //--接口参数--end

		Map<String, String> errorResposne = new HashMap<>();
		errorResposne.put("resCode", "400001");
		errorResposne.put("resMsg", "userType不能为空");
		tool.url(baseUrl + "/v33/trans/car/condition/photo/upload")
				.request(requestMap)
				.expectErrorResponse(errorResposne)
				.execute();
	}
	
	@Test(description="用户类型校验（其他数据正确，用户登录状态）,用户类型为空字符",groups="入参检查")	
	public void testTransCarConditionPhotoUpload10(){
		Map<String,Object> requestMap = new HashMap<String,Object>();
		//--接口参数--start
		requestMap.put("orderNo","685395315061");
	    requestMap.put("token",renterToken);
	    requestMap.put("userType","");
	    requestMap.put("photoType","1");
	    requestMap.put("photoContent","1");
	    requestMap.put("serialNumber","1");
	    //--接口参数--end

		Map<String, String> errorResposne = new HashMap<>();
		errorResposne.put("resCode", "400001");
		errorResposne.put("resMsg", "userType不能为空");
		tool.url(baseUrl + "/v33/trans/car/condition/photo/upload")
				.request(requestMap)
				.expectErrorResponse(errorResposne)
				.execute();
	}
	
	@Test(description="用户类型校验（其他数据正确，用户登录状态）,用户类型为空，不传",groups="入参检查")	
	public void testTransCarConditionPhotoUpload11(){
		Map<String,Object> requestMap = new HashMap<String,Object>();
		//--接口参数--start
		requestMap.put("orderNo","685395315061");
	    requestMap.put("token",renterToken);
	    requestMap.put("photoType","1");
	    requestMap.put("photoContent","1");
	    requestMap.put("serialNumber","1");
	    //--接口参数--end

		Map<String, String> errorResposne = new HashMap<>();
		errorResposne.put("resCode", "400001");
		errorResposne.put("resMsg", "userType不能为空");
		tool.url(baseUrl + "/v33/trans/car/condition/photo/upload")
				.request(requestMap)
				.expectErrorResponse(errorResposne)
				.execute();
	}
	
	@Test(description="用户类型校验（其他数据正确，用户登录状态）,用户类型为非数字",groups="入参检查")	
	public void testTransCarConditionPhotoUpload12(){
		Map<String,Object> requestMap = new HashMap<String,Object>();
		//--接口参数--start
		requestMap.put("orderNo","685395315061");
	    requestMap.put("token",renterToken);
	    requestMap.put("userType","s");
	    requestMap.put("photoType","1");
	    requestMap.put("photoContent","1");
	    requestMap.put("serialNumber","1");
	    //--接口参数--end

		Map<String, String> errorResposne = new HashMap<>();
		errorResposne.put("resCode", "400001");
		errorResposne.put("resMsg", "userType只能为1,2,3");
		tool.url(baseUrl + "/v33/trans/car/condition/photo/upload")
				.request(requestMap)
				.expectErrorResponse(errorResposne)
				.execute();
	}
	
	@Test(description="用户类型校验（其他数据正确，用户登录状态）,用户类型为1、2、3以外的数字",groups="入参检查")	
	public void testTransCarConditionPhotoUpload13(){
		Map<String,Object> requestMap = new HashMap<String,Object>();
		//--接口参数--start
		requestMap.put("orderNo","685395315061");
	    requestMap.put("token",renterToken);
	    requestMap.put("userType","4");
	    requestMap.put("photoType","1");
	    requestMap.put("photoContent","1");
	    requestMap.put("serialNumber","1");
	    //--接口参数--end

		Map<String, String> errorResposne = new HashMap<>();
		errorResposne.put("resCode", "400001");
		errorResposne.put("resMsg", "userType只能为1,2,3");
		tool.url(baseUrl + "/v33/trans/car/condition/photo/upload")
				.request(requestMap)
				.expectErrorResponse(errorResposne)
				.execute();
	}
	
	@Test(description="照片类型校验（其他数据正确，用户登录状态）,照片类型为null",groups="入参检查")	
	public void testTransCarConditionPhotoUpload14() throws FileNotFoundException{
		Map<String,Object> requestMap = new HashMap<String,Object>();
		//--接口参数--start
	    requestMap.put("orderNo","685395315061");
	    requestMap.put("token",renterToken);
	    requestMap.put("userType","1");
	    requestMap.put("photoType",null);
	    requestMap.put("photoContent",CommonUtils.imgToBase64(picUrl));
	    requestMap.put("serialNumber","1");
	    //--接口参数--end

		Map<String, String> errorResposne = new HashMap<>();
		errorResposne.put("resCode", "400001");
		errorResposne.put("resMsg", "photoType不能为空");
		tool.url(baseUrl + "/v33/trans/car/condition/photo/upload")
				.request(requestMap)
				.expectErrorResponse(errorResposne)
				.execute();
	}

	@Test(description="照片类型校验（其他数据正确，用户登录状态）,照片类型为空字符",groups="入参检查")	
	public void testTransCarConditionPhotoUpload15() throws FileNotFoundException{
		Map<String,Object> requestMap = new HashMap<String,Object>();
		//--接口参数--start
	    requestMap.put("orderNo","685395315061");
	    requestMap.put("token",renterToken);
	    requestMap.put("userType","1");
	    requestMap.put("photoType"," ");
	    requestMap.put("photoContent",CommonUtils.imgToBase64(picUrl));
	    requestMap.put("serialNumber","1");
	    //--接口参数--end

		Map<String, String> errorResposne = new HashMap<>();
		errorResposne.put("resCode", "400001");
		errorResposne.put("resMsg", "photoType不能为空");//目前返回：photoType只能为1,2
		tool.url(baseUrl + "/v33/trans/car/condition/photo/upload")
				.request(requestMap)
				.expectErrorResponse(errorResposne)
				.execute();
	}
	
	@Test(description="照片类型校验（其他数据正确，用户登录状态）,照片类型为1、2以外",groups="入参检查")	
	public void testTransCarConditionPhotoUpload16() throws FileNotFoundException{
		Map<String,Object> requestMap = new HashMap<String,Object>();
		//--接口参数--start
	    requestMap.put("orderNo","685395315061");
	    requestMap.put("token",renterToken);
	    requestMap.put("userType","1");
	    requestMap.put("photoType","3");
	    requestMap.put("photoContent",CommonUtils.imgToBase64(picUrl));
	    requestMap.put("serialNumber","1");
	    //--接口参数--end

		Map<String, String> errorResposne = new HashMap<>();
		errorResposne.put("resCode", "400001");
		errorResposne.put("resMsg", "photoType只能为1,2");
		tool.url(baseUrl + "/v33/trans/car/condition/photo/upload")
				.request(requestMap)
				.expectErrorResponse(errorResposne)
				.execute();
	}
	
	@Test(description="照片类型校验（其他数据正确，用户登录状态）,照片类型为非数字字符",groups="入参检查")	
	public void testTransCarConditionPhotoUpload17() throws FileNotFoundException{
		Map<String,Object> requestMap = new HashMap<String,Object>();
		//--接口参数--start
	    requestMap.put("orderNo","685395315061");
	    requestMap.put("token",renterToken);
	    requestMap.put("userType","1");
	    requestMap.put("photoType","sss");
	    requestMap.put("photoContent",CommonUtils.imgToBase64(picUrl));
	    requestMap.put("serialNumber","1");
	    //--接口参数--end

		Map<String, String> errorResposne = new HashMap<>();
		errorResposne.put("resCode", "400001");
		errorResposne.put("resMsg", "photoType只能为1,2");
		tool.url(baseUrl + "/v33/trans/car/condition/photo/upload")
				.request(requestMap)
				.expectErrorResponse(errorResposne)
				.execute();
	}
	
	@Test(description="照片内容校验（其他数据正确，用户登录状态）,照片类型为null",groups="入参检查")	
	public void testTransCarConditionPhotoUpload18() throws FileNotFoundException{
		Map<String,Object> requestMap = new HashMap<String,Object>();
		//--接口参数--start
	    requestMap.put("orderNo","685395315061");
	    requestMap.put("token",renterToken);
	    requestMap.put("userType","1");
	    requestMap.put("photoType","1");
	    requestMap.put("photoContent",null);
	    requestMap.put("serialNumber","1");
	    //--接口参数--end

		Map<String, String> errorResposne = new HashMap<>();
		errorResposne.put("resCode", "400001");
		errorResposne.put("resMsg", "photoContent不能为空");
		tool.url(baseUrl + "/v33/trans/car/condition/photo/upload")
				.request(requestMap)
				.expectErrorResponse(errorResposne)
				.execute();
	}
	
	
	@Test(description="照片内容校验（其他数据正确，用户登录状态）,照片类型为空字符",groups="入参检查")	
	public void testTransCarConditionPhotoUpload19() throws FileNotFoundException{
		Map<String,Object> requestMap = new HashMap<String,Object>();
		//--接口参数--start
	    requestMap.put("orderNo","685395315061");
	    requestMap.put("token",renterToken);
	    requestMap.put("userType","1");
	    requestMap.put("photoType","1");
	    requestMap.put("photoContent","");
	    requestMap.put("serialNumber","1");
	    //--接口参数--end

		Map<String, String> errorResposne = new HashMap<>();
		errorResposne.put("resCode", "400001");
		errorResposne.put("resMsg", "photoContent不能为空");
		tool.url(baseUrl + "/v33/trans/car/condition/photo/upload")
				.request(requestMap)
				.expectErrorResponse(errorResposne)
				.execute();
	}
	
	@Test(description="照片内容校验（其他数据正确，用户登录状态）,照片类型为空，不传",groups="入参检查")	
	public void testTransCarConditionPhotoUpload20() throws FileNotFoundException{
		Map<String,Object> requestMap = new HashMap<String,Object>();
		//--接口参数--start
	    requestMap.put("orderNo","685395315061");
	    requestMap.put("token",renterToken);
	    requestMap.put("userType","1");
	    requestMap.put("photoType","1");
	    requestMap.put("serialNumber","1");
	    //--接口参数--end

		Map<String, String> errorResposne = new HashMap<>();
		errorResposne.put("resCode", "400001");
		errorResposne.put("resMsg", "photoContent不能为空");
		tool.url(baseUrl + "/v33/trans/car/condition/photo/upload")
				.request(requestMap)
				.expectErrorResponse(errorResposne)
				.execute();
	}
	
	@Test(description="照片序号校验（其他数据正确，用户登录状态）,照片序号为非数字",groups="入参检查")	
	public void testTransCarConditionPhotoUpload21() throws FileNotFoundException{
		Map<String,Object> requestMap = new HashMap<String,Object>();
		//--接口参数--start
	    requestMap.put("orderNo","625507036061");
	    requestMap.put("token",renterToken);
	    requestMap.put("userType","1");
	    requestMap.put("photoType","1");
	    requestMap.put("photoContent",CommonUtils.imgToBase64(picUrl));
	    requestMap.put("serialNumber","sss");
	    //--接口参数--end

		Map<String, String> errorResposne = new HashMap<>();
		errorResposne.put("resCode", "400001");//目前为：900000
		errorResposne.put("resMsg", "serialNumber只能为数字");
		tool.url(baseUrl + "/v33/trans/car/condition/photo/upload")
				.request(requestMap)
				.expectErrorResponse(errorResposne)
				.execute();
	}
	
	@Test(description="租客上传取车照片，总取车照片数在35张内（<=35），期望上传成功（一直上传序号为1，新增和更新逻辑）",groups="入参检查")	
	public void testTransCarConditionPhotoUpload22() throws FileNotFoundException{
		Map<String,Object> requestMap = new HashMap<String,Object>();
		//--接口参数--start
	    requestMap.put("orderNo","625507036061");
	    requestMap.put("token",renterToken);
	    requestMap.put("userType","1");
	    requestMap.put("photoType","1");
	    requestMap.put("photoContent",CommonUtils.imgToBase64(picUrl));
	    requestMap.put("serialNumber","1");
	    //--接口参数--end

		tool.url(baseUrl + "/v33/trans/car/condition/photo/upload")
				.request(requestMap)
				.execute();
	}
	
	@Test(description="租客上传取车照片，总取车照片数为35张，再度上传，期望不成功（上限35张限制）",groups="入参检查")	
	public void testTransCarConditionPhotoUpload23() throws FileNotFoundException{
		Map<String,Object> requestMap = new HashMap<String,Object>();
		//--接口参数--start
	    requestMap.put("orderNo","168901107061");
	    requestMap.put("token",renterToken);
	    requestMap.put("userType","1");
	    requestMap.put("photoType","1");
	    requestMap.put("photoContent",CommonUtils.imgToBase64(picUrl));
	    //--接口参数--end
	    
	    Map<String, String> errorResposne = new HashMap<>();
		errorResposne.put("resCode", "900000");
		errorResposne.put("resMsg", "图片只能上传35张");

    	tool.url(baseUrl + "/v33/trans/car/condition/photo/upload")
		.request(requestMap)
		.expectErrorResponse(errorResposne)
		.execute();
//	    for (int i = 0; i < 35; i++) {
//		tool.url(baseUrl + "/v33/trans/car/condition/photo/upload")
//		.request(requestMap)
//		.execute();
//	    }
	}
	
	@Test(description="租客上传还照片，总取车照片数在35张内（<=35），期望上传成功（一直上传序号为1，新增和更新逻辑）",groups="入参检查")	
	public void testTransCarConditionPhotoUpload24() throws FileNotFoundException{
		Map<String,Object> requestMap = new HashMap<String,Object>();
		//--接口参数--start
	    requestMap.put("orderNo","625507036061");
	    requestMap.put("token",renterToken);
	    requestMap.put("userType","1");
	    requestMap.put("photoType","2");
	    requestMap.put("photoContent",CommonUtils.imgToBase64(picUrl));
	    requestMap.put("serialNumber","1");
	    //--接口参数--end

		tool.url(baseUrl + "/v33/trans/car/condition/photo/upload")
				.request(requestMap)
				.execute();
	}
	
	@Test(description="租客上传还车照片，总还车照片数为35张再上传时，期望提示无法上传（不传序号）",groups="入参检查")	
	public void testTransCarConditionPhotoUpload25() throws FileNotFoundException{
		Map<String,Object> requestMap = new HashMap<String,Object>();
		//--接口参数--start
	    requestMap.put("orderNo","168901107061");
	    requestMap.put("token",renterToken);
	    requestMap.put("userType","1");
	    requestMap.put("photoType","2");
	    requestMap.put("photoContent",CommonUtils.imgToBase64(picUrl));
	    //--接口参数--end
	
	    Map<String, String> errorResposne = new HashMap<>();
		errorResposne.put("resCode", "900000");
		errorResposne.put("resMsg", "图片只能上传35张");

		tool.url(baseUrl + "/v33/trans/car/condition/photo/upload")
		.request(requestMap)
		.expectErrorResponse(errorResposne)
		.execute();
//	    for (int i = 0; i < 35; i++) {
//	    	tool.url(baseUrl + "/v33/trans/car/condition/photo/upload")
//			.request(requestMap)
//			.execute();
//		}
	}
	
	@Test(description="租客上传车主的还车照片，期望提示无法上传（不传序号）",groups="入参检查")	
	public void testTransCarConditionPhotoUpload26() throws FileNotFoundException{
		Map<String,Object> requestMap = new HashMap<String,Object>();
		//--接口参数--start
	    requestMap.put("orderNo","168901107061");
	    requestMap.put("token",renterToken);
	    requestMap.put("userType","2");
	    requestMap.put("photoType","2");
	    requestMap.put("photoContent",CommonUtils.imgToBase64(picUrl));
	    //--接口参数--end
	
	    Map<String, String> errorResposne = new HashMap<>();
		errorResposne.put("resCode", "900000");
		errorResposne.put("resMsg", "您只能上传自己的取还车照片");

		tool.url(baseUrl + "/v33/trans/car/condition/photo/upload")
		.request(requestMap)
		.expectErrorResponse(errorResposne)
		.execute();
	}
	
	@Test(description="租客上传还车照片，上传的不是自己的订单号",groups="入参检查")	
	public void testTransCarConditionPhotoUpload27() throws FileNotFoundException{
		Map<String,Object> requestMap = new HashMap<String,Object>();
		//--接口参数--start
	    requestMap.put("orderNo","637609036061");
	    requestMap.put("token",renterToken);
	    requestMap.put("userType","1");
	    requestMap.put("photoType","2");
	    requestMap.put("photoContent",CommonUtils.imgToBase64(picUrl));
	    //--接口参数--end
	
	    Map<String, String> errorResposne = new HashMap<>();
		errorResposne.put("resCode", "900000");
		errorResposne.put("resMsg", "非自己订单不能操作");

		tool.url(baseUrl + "/v33/trans/car/condition/photo/upload")
		.request(requestMap)
		.expectErrorResponse(errorResposne)
		.execute();
	}	

	@Test(description="车主上传交车照片，总交车照片数在35张内（<=35），期望上传成功（一直上传序号为1，新增和更新逻辑）",groups="入参检查")	
	public void testTransCarConditionPhotoUpload28() throws FileNotFoundException{
		Map<String,Object> requestMap = new HashMap<String,Object>();
		//--接口参数--start
	    requestMap.put("orderNo","625507036061");
	    requestMap.put("token",ownerToken);
	    requestMap.put("userType","2");
	    requestMap.put("photoType","1");
	    requestMap.put("photoContent",CommonUtils.imgToBase64(picUrl));
	    requestMap.put("serialNumber","1");
	    //--接口参数--end

		tool.url(baseUrl + "/v33/trans/car/condition/photo/upload")
				.request(requestMap)
				.execute();
	}
	
	@Test(description="车主上传交车照片，总交车照片数为35张，再度上传，期望不成功（上限35张限制）",groups="入参检查")	
	public void testTransCarConditionPhotoUpload29() throws FileNotFoundException{
		Map<String,Object> requestMap = new HashMap<String,Object>();
		//--接口参数--start
	    requestMap.put("orderNo","168901107061");
	    requestMap.put("token",ownerToken);
	    requestMap.put("userType","2");
	    requestMap.put("photoType","1");
	    requestMap.put("photoContent",CommonUtils.imgToBase64(picUrl));
	    //--接口参数--end
	    
	    Map<String, String> errorResposne = new HashMap<>();
		errorResposne.put("resCode", "900000");
		errorResposne.put("resMsg", "图片只能上传35张");

    	tool.url(baseUrl + "/v33/trans/car/condition/photo/upload")
		.request(requestMap)
		.expectErrorResponse(errorResposne)
		.execute();
//	    for (int i = 0; i < 35; i++) {
//			tool.url(baseUrl + "/v33/trans/car/condition/photo/upload")
//			.request(requestMap)
//			.execute();
//	    }
	}
	
	@Test(description="车主上传接车照片，总接车照片数在35张内（<=35），期望上传成功（一直上传序号为1，新增和更新逻辑）",groups="入参检查")	
	public void testTransCarConditionPhotoUpload30() throws FileNotFoundException{
		Map<String,Object> requestMap = new HashMap<String,Object>();
		//--接口参数--start
	    requestMap.put("orderNo","625507036061");
	    requestMap.put("token",ownerToken);
	    requestMap.put("userType","2");
	    requestMap.put("photoType","2");
	    requestMap.put("photoContent",CommonUtils.imgToBase64(picUrl));
	    requestMap.put("serialNumber","1");
	    //--接口参数--end

		tool.url(baseUrl + "/v33/trans/car/condition/photo/upload")
				.request(requestMap)
				.execute();
	}
	
	@Test(description="车主上传接车照片，总接车照片数为35张再上传时，期望提示无法上传（不传序号）",groups="入参检查")	
	public void testTransCarConditionPhotoUpload31() throws FileNotFoundException{
		Map<String,Object> requestMap = new HashMap<String,Object>();
		//--接口参数--start
	    requestMap.put("orderNo","168901107061");
	    requestMap.put("token",ownerToken);
	    requestMap.put("userType","2");
	    requestMap.put("photoType","2");
	    requestMap.put("photoContent",CommonUtils.imgToBase64(picUrl));
	    //--接口参数--end
	
	    Map<String, String> errorResposne = new HashMap<>();
		errorResposne.put("resCode", "900000");
		errorResposne.put("resMsg", "图片只能上传35张");

		tool.url(baseUrl + "/v33/trans/car/condition/photo/upload")
		.request(requestMap)
		.expectErrorResponse(errorResposne)
		.execute();
//	    for (int i = 0; i < 35; i++) {
//			tool.url(baseUrl + "/v33/trans/car/condition/photo/upload")
//			.request(requestMap)
//			.execute();
//	    }
	}
	
	@Test(description="车主上传接车照片，上传的不是自己的订单号",groups="入参检查")	
	public void testTransCarConditionPhotoUpload32() throws FileNotFoundException{
		Map<String,Object> requestMap = new HashMap<String,Object>();
		//--接口参数--start
	    requestMap.put("orderNo","637609036061");
	    requestMap.put("token",ownerToken);
	    requestMap.put("userType","2");
	    requestMap.put("photoType","2");
	    requestMap.put("photoContent",CommonUtils.imgToBase64(picUrl));
	    //--接口参数--end
	
	    Map<String, String> errorResposne = new HashMap<>();
		errorResposne.put("resCode", "900000");
		errorResposne.put("resMsg", "非自己订单不能操作");

		tool.url(baseUrl + "/v33/trans/car/condition/photo/upload")
		.request(requestMap)
		.expectErrorResponse(errorResposne)
		.execute();
	}	
	
	@Test(description="车主上传租客的取车照片，期望无法操作",groups="入参检查")	
	public void testTransCarConditionPhotoUpload33() throws FileNotFoundException{
		Map<String,Object> requestMap = new HashMap<String,Object>();
		//--接口参数--start
	    requestMap.put("orderNo","168901107061");
	    requestMap.put("token",ownerToken);
	    requestMap.put("userType","1");
	    requestMap.put("photoType","1");
	    requestMap.put("photoContent",CommonUtils.imgToBase64(picUrl));
	    //--接口参数--end
	
	    Map<String, String> errorResposne = new HashMap<>();
		errorResposne.put("resCode", "900000");
		errorResposne.put("resMsg", "您只能上传自己的取还车照片");

		tool.url(baseUrl + "/v33/trans/car/condition/photo/upload")
		.request(requestMap)
		.expectErrorResponse(errorResposne)
		.execute();
	}
}
