package com.auto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.auto.http.EventNotifier;
import com.auto.http.HttpApi;
import com.auto.http.ResponseBack;
import com.auto.utils.TestUtils;

public class AbstractAutoAPITest {
	
	//protected final static String bathUrl="http://app30.atzuche.com:7064";
	protected final static String bathUrl="http://10.0.3.213:7064";
	//protected final static String bathUrl="http://10.0.3.78:8080";
	
	protected final static HttpApi tool = new HttpApi();
	
	protected final static String _null=null;
	protected final static String _empty="";
	
	protected final static String dtFormat="yyyyMMddHHmmss";
	
	protected void sendRequestWithoutResponse(String api ,Map<String,Object> requestMap){
		tool.url(bathUrl+api)
		   .request(requestMap)
	       .execute();
	}
	
	protected List<Map> getListDataFromDB(String sql){
		return TestUtils.getExpectListFromDB(sql);
	}
	
	protected Map<String, Object> getDataFromDB(String sql){
		return TestUtils.getExpectDataFromDB(sql);
	}
	
	protected List<Object> getListFromDB(String sql){
		return null;
	}
	
	
	protected HashMap sendRequestAndGetResponse(String api ,Map<String,Object> requestMap){
		EventNotifier event=new EventNotifier();
		event.setCallFunc(new ResponseBack());
		tool.url(bathUrl+api)
		   .request(requestMap)
	       .execute(event);
		return (HashMap)event.getData();
	}
	
	protected void sendRequestWithExpectedResponse(String api ,
													Map<String,Object> requestMap,
													Map<String,Object> expectedResponse){
		tool.url(bathUrl+api)
		   .request(requestMap)
		   .expectData(expectedResponse)
	       .execute();
	
		
	}
	
	protected void sendRequestWithExpectedError(String api ,Map<String,Object> requestMap,
												Map<String, String> errorResponse){
		
		tool.url(bathUrl+api)
		   .request(requestMap)
		   .expectErrorResponse(errorResponse)
	       .execute();
		
	}
	
	public String getCurrentDateTime(String format){
		SimpleDateFormat sdf = new SimpleDateFormat(format); 
		Calendar c = Calendar.getInstance(); 
		return sdf.format(c.getTime());
	}
	
	public String getNextDateTime(String date, int days,String format){
		SimpleDateFormat sdf = new SimpleDateFormat(format); 
		Calendar c=Calendar.getInstance();   
		Date d;
		try {
			d = sdf.parse(date);
			
			c.setTime(d);
			c.add(Calendar.DATE,days);  
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sdf.format(c.getTime());
		
	}
	
	protected Map<String,Object> createCommonRequestMap(){
		Map<String,Object> requestMap = new HashMap<String,Object>();
        /*公共参数*/
        requestMap.put("AppVersion", "41");
        requestMap.put("publicToken", "0");
		requestMap.put("OS", "IOS");
		requestMap.put("OsVersion", "7.0.4");
		requestMap.put("PublicLatitude", "0");
		requestMap.put("PublicLongitude", "0");
		requestMap.put("IMEI", "E96ACEC8-51D5-4C25-A81E-496DBFECBA53");
		requestMap.put("deviceName", "iPhone5");
		requestMap.put("requestId", "00ADE6C2-973C-42A5-9EAE-E2EFF5ED83BC1471591694");
		requestMap.put("publicCityCode", "021");	
		return requestMap;

	}
	
	public void testWithTokenNull_Failure(String api){
		 Map<String,Object> requestMap = createCommonRequestMap();
		 requestMap.put("token",_null);
		 Map<String, String> errorResposne = createCommonErrorResponseMap();
		 errorResposne.put("resCode", "400001");
		 sendRequestWithExpectedError(api, requestMap, errorResposne);
		
	}
	
	public void testWithEmptyToken_Failure(String api){
		 Map<String,Object> requestMap = createCommonRequestMap();
		 requestMap.put("token",_empty);
		 Map<String, String> errorResposne = createCommonErrorResponseMap();
		 errorResposne.put("resCode", "200008");
		 sendRequestWithExpectedError(api, requestMap, errorResposne);
		
	}
	
	
	public void testWithFakeToken_Failure(String api){
		 Map<String,Object> requestMap = createCommonRequestMap();
		 requestMap.put("token","0000000000000000000000000000000");
		 Map<String, String> errorResposne = createCommonErrorResponseMap();
		 errorResposne.put("resCode", "200008");
		 sendRequestWithExpectedError(api, requestMap, errorResposne);
		
	}
	
	protected Map<String,String> createCommonErrorResponseMap(){
		 Map<String, String> errorResposne = new HashMap<String,String>();
		 return errorResposne;
	}
	
	protected  Map<String,Object> createCommonExpectedResponseMap(){
		Map<String,Object> expectedMap = new HashMap<String,Object>();
		return expectedMap;
	}

}
