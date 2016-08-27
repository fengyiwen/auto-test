package com.autointerfaceCPIC;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.testng.annotations.Test;

import com.auto.http.EventNotifier;
import com.auto.http.HttpApi;
import com.auto.http.RequestHeaderMap;
import com.auto.http.ResponseBack;
import com.auto.http.SecurityUtils;

public class CpicSaveCoupon {

	private final static String baseUrl="http://10.0.3.223:998";
	private final static HttpApi tool = new HttpApi();
	private final static String key = "NB9RrHluQf50nWVl+56CoMwWJ4oN3ZKuOz/xpXxQ9vTdugB0loRqgzpxa1rlgJh1xXFINbMr0dprsXGAJFo2hQ==";
	//测试对外接口（需要修改angent和地址）
	@Test
	public void testLogin() {
		Map<String,Object> requestMap = new HashMap<String,Object>();
		requestMap.put("plateNum", "冀A7111");
		requestMap.put("policyMobile", "15618538367");
		requestMap.put("couponType", "2");
		EventNotifier event=new EventNotifier();
		event.setCallFunc(new ResponseBack());
		
		TreeMap <String, Object> reqMap = new TreeMap<String, Object>();
		reqMap.putAll(requestMap);

		try {
			String macSign = SecurityUtils.getSign(key, reqMap, 2);
			requestMap.put("sign", macSign);
			System.out.println("***********************macSign is*****"+macSign);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		tool.url(baseUrl+"/cpic/save/coupon")
	    .request(requestMap)
	    .headerMap(RequestHeaderMap.headerMap().get("AutoyolEs_CPIC"))
	    .compressed(false)
	    .setIsCheck(false)
	    .execute(event);
		}
}
