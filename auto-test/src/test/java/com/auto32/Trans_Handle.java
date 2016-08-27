package com.auto32;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.management.PublishEventNotifier;
import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;
import org.springframework.stereotype.Repository;

import com.auto.http.EventNotifier;
import com.auto.http.HttpApi;
import com.auto.http.RequestMethod;
import com.auto.http.ResponseBack;

public class Trans_Handle {
	private final static String baseUrl="http://10.0.3.213:7064";
	private HttpApi tool = new HttpApi();
	/**
	 * 下单请求接口
	 * @param reqData
	 * @return
	 */
	public Object trans_V72Req(Map<String,Object> reqData) {
		//--公共参数--start
		reqData.put("AppChannelId","testmarket");
		reqData.put("AppVersion",39);
		reqData.put("IMEI","34311197A65");
		reqData.put("OS","ANDROID");
		reqData.put("OsVersion","18");
		reqData.put("PublicLatitude","31.195604");
		reqData.put("PublicLongitude","121.433582");
		reqData.put("appName","atzucheApp");
		reqData.put("deviceName","GT-I9300I");
		reqData.put("publicCityCode","021");
		reqData.put("publicToken","0");
		//--公共参数---end
		
		EventNotifier event=new EventNotifier();
		event.setCallFunc(new ResponseBack());
		
		tool.url(baseUrl+"/trans/v72/req")
        .request(reqData)
        .setIsCheck(false)
        .execute(event);
		return event.getData();
	}
	
	//http://test2-appserver.atzc.com:7064/trans/v7/reqConfirm
	/**
	 * 车主确认交易请求（车主同意/拒绝订单操作）
	 * confirm:1同意 2拒绝
	 * consoleInvoke:1管理后台 0非管理后台（可不传）
	 * @return
	 */
	public Object transV7ReqConfirm(Map<String,Object> reqData){
		EventNotifier event=new EventNotifier();
		event.setCallFunc(new ResponseBack());
		
		tool.url(baseUrl+"/trans/v7/reqConfirm")
		.method(RequestMethod.PUT)
        .request(reqData)
        .setIsCheck(false)
        .execute(event);
		return event.getData();
	}
		
		
	/**
	 * 订单取消接口
	 * @param reqData
	 * @return
	 */
	public Object transCancel(Map<String,Object> reqData){
		EventNotifier event=new EventNotifier();
		event.setCallFunc(new ResponseBack());
		
		tool.url(baseUrl+"/trans/cancel")
        .request(reqData)
        .setIsCheck(false)
        .execute(event);
		return event.getData();		
	}	
	
	/**
	 * 查询延时信息接口（用于进行延时申请时计算费用的展示）
	 * @param reqData
	 * @return
	 */
	public Object queryExtInfo(Map<String,Object> reqData){
		return reqData;

	}
}
