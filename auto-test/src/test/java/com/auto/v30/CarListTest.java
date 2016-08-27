package com.auto.v30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.auto.AbstractAutoAPITest;

public class CarListTest extends AbstractAutoAPITest {
	
	protected static String api="/v30/car/list";
	
	@Test
	public void testCarList_Success(){
		getCarList();
		
	}
	
	
	public String getApiDestion(){
		return super.bathUrl+api;
	}
	
	public void getCarList(){
		 Map<String,Object> requestMap = super.createCommonRequestMap();
		 requestMap.put("ModuleName", "v30/car/list");
		 requestMap.put("cityCode", "310100");
		 requestMap.put("pageNum", "1");
		 requestMap.put("pageSize", "10");
		 
		 Map<String,Object> filterConditionMap = new HashMap<String,Object>();
		 filterConditionMap.put("seq", "4");
		 filterConditionMap.put("lat", "31.213507");
		 filterConditionMap.put("lon", "121.454506");
		 
		 requestMap.put("filterCondition", filterConditionMap);
		 
		 Map<String,Object> responseMap = new HashMap<>();
		 List<Object> carList =  new ArrayList<Object>();
		 responseMap.put("carList", carList);
		 
		 super.sendRequestWithoutResponse(api, requestMap);
		
//		 tool.url(super.bathUrl+api)
//		   .request(requestMap)
//	       .execute();
		 
	}

}
