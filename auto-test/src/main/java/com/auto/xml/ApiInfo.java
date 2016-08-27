package com.auto.xml;

import com.thoughtworks.xstream.annotations.XStreamAlias;
/**
 * 
 *<p>Title:ApiInfo</p>
 *<p>Description:API信息</p>
 *<p>Company:atzuche</p>
 * @author zhiping.li
 * @date 2015年11月27日上午10:55:14
 */
@XStreamAlias("api")
public class ApiInfo {
    @XStreamAlias("request")
	private RequestInfo request;
    @XStreamAlias("response")
	private ResponseInfo response;
	public RequestInfo getRequest() {
		return request;
	}
	public void setRequest(RequestInfo request) {
		this.request = request;
	}
	public ResponseInfo getResponse() {
		return response;
	}
	public void setResponse(ResponseInfo response) {
		this.response = response;
	}
}
