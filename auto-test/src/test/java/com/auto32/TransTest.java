package com.auto32;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.auto.dao.impl.TestCaseDaoImpl;

public class TransTest {
	@Autowired
	private TestCaseDaoImpl testCaseImpl;
	static Trans_Handle trans_V72Req_Fun=new Trans_Handle();
	@Test(description="测试登录失效下单")
	public void testTransReq1(){
		
		Map<String, Object> reqData = new HashMap<String, Object>();
		reqData.put("abatement", "1");
		reqData.put("token", "686553dd2cfa40e2918dadb310fb8371");
		reqData.put("conPhone", "16900000001");
		reqData.put("carNo", "425710387");//141560796
		reqData.put("isLeaveCity", "0");
		reqData.put("oilType", "1");
		reqData.put("rentTime", "20160510100000");
		reqData.put("revertTime", "20160510110000");
		reqData.put("sceneCode", "S002");
		reqData.put("source", "1");//交易来源
		reqData.put("srvGetFlag", "0");
		reqData.put("srvReturnFlag", "0");
		
		Map<String, Object> resultMap=(Map<String, Object>) trans_V72Req_Fun.trans_V72Req(reqData);
		if(resultMap != null){
			Assert.assertEquals(resultMap.get("resCode"),"200008");
			Assert.assertEquals(resultMap.get("resMsg"),"没有登录或登录失效，请重新登录");
			}
		else {
			Assert.fail("测试登录失效下单失败");
			}
	}
}
