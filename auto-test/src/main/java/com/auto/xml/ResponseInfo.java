package com.auto.xml;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 * 
 *<p>Title:ResponseInfo</p>
 *<p>Description:定义响应信息</p>
 *<p>Company:atzuche</p>
 * @author zhiping.li
 * @date 2015年11月27日上午10:13:42
 */
public class ResponseInfo {
	private String resCode;
	private String resMsg;

	private Data data;

	public String getResCode() {
		return resCode;
	}
	public void setResCode(String resCode) {
		this.resCode = resCode;
	}
	public String getResMsg() {
		return resMsg;
	}
	public void setResMsg(String resMsg) {
		this.resMsg = resMsg;
	}
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
	/**
	 * 
	 *<p>Title:Data</p>
	 *<p>Description:返回数据</p>
	 *<p>Company:atzuche</p>
	 * @author zhiping.li
	 * @date 2015年11月27日上午10:50:31
	 */
	public static class Data{
		private String assertType;
		private AssertData assertDatas;
		public String getAssertType() {
			return assertType;
		}
		public void setAssertType(String assertType) {
			this.assertType = assertType;
		}
		public AssertData getAssertDatas() {
			return assertDatas;
		}
		public void setAssertDatas(AssertData assertDatas) {
			this.assertDatas = assertDatas;
		}

	}
	/**
	 * 
	 *<p>Title:AssertData</p>
	 *<p>Description:期待数据</p>
	 *<p>Company:atzuche</p>
	 * @author zhiping.li
	 * @date 2015年11月27日上午10:50:13
	 */
	class AssertData{
		@XStreamImplicit(itemFieldName = "param")  
		private List<Param> param;
		public void setParam(List<Param> param) {
			this.param = param;
		}
		public List<Param> getParam() {
			return param;
		}
	}
}
