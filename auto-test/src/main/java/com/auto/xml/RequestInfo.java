package com.auto.xml;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
/**
 * 
 *<p>Title:RequestInfo</p>
 *<p>Description:请求信息</p>
 *<p>Company:atzuche</p>
 * @author zhiping.li
 * @date 2015年11月27日上午10:02:33
 */
public class RequestInfo {
	private String url;
	private String method;
	private String dataType;
	private boolean isGzip;
	private boolean isSecret;
	private RequestParam requestParams;
	@XStreamAlias("requestHeads")
	private RequestHead requestHeads;
	/**
	 * 
	 *<p>Title:RequestParam</p>
	 *<p>Description:请求参数信息</p>
	 *<p>Company:atzuche</p>
	 * @author zhiping.li
	 * @date 2015年11月27日上午10:03:04
	 */
	public static class RequestParam {
		@XStreamImplicit(itemFieldName = "param")  
		private List<Param> param;
		public List<Param> getParam() {
			return param;
		}
		public void setParam(List<Param> param) {
			this.param = param;
		}
		
		/**
		 * 
		 *@Title: getParams 
		 *@Description: TODO
		 *@param @return 
		 *@return Map<String,String> 
		 *@throws 
		 *@auther zhiping.li
		 *@date 2015年11月27日上午11:27:35
		 */
		public Map<String, String> getParams() {
			Map<String, String> params = new HashMap<String, String>();
			if (param!=null&& param.size() > 0) {
				for (Param p : param) {
					params.put(p.getName(), p.getContent());
				}
			}
			return params;
		}
	}
	/**
	 * 
	 *<p>Title:RequestHead</p>
	 *<p>Description:请求头信息</p>
	 *<p>Company:atzuche</p>
	 * @author zhiping.li
	 * @date 2015年11月27日上午10:03:20
	 */
	public static class RequestHead {
		@XStreamImplicit(itemFieldName = "param")  
		private List<Param> param;
		public List<Param> getParam() {
			return param;
		}
		public void setParam(List<Param> param) {
			this.param = param;
		}
		/**
		 * 
		 *@Title: getParams 
		 *@Description: TODO
		 *@param @return 
		 *@return Map<String,String> 
		 *@throws 
		 *@auther zhiping.li
		 *@date 2015年11月27日上午11:27:35
		 */
		public Map<String, String> getParams() {
			Map<String, String> params = new HashMap<String, String>();
			if (param!=null&& param.size() > 0) {
				for (Param p : param) {
					params.put(p.getName(), p.getContent());
				}
			}
			return params;
		}
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public boolean isGzip() {
		return isGzip;
	}
	public void setGzip(boolean isGzip) {
		this.isGzip = isGzip;
	}
	public boolean getIsSecret() {
		return isSecret;
	}
	public void setIsSecret(boolean isSecret) {
		this.isSecret = isSecret;
	}
	public RequestParam getRequestParams() {
		return requestParams;
	}
	public void setRequestParams(RequestParam requestParams) {
		this.requestParams = requestParams;
	}
    public RequestHead getRequestHeads() {
		return requestHeads;
	}
    public void setRequestHeads(RequestHead requestHeads) {
		this.requestHeads = requestHeads;
	}
	
	
}
