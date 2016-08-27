package com.auto.service;

import java.util.List;
import java.util.Map;

import com.auto.bo.JqGridTree;
import com.auto.domain.Action;


/**
 * 
 *<p>Title:IHttpCaseService</p>
 *<p>Description:http测试用例服务</p>
 *<p>Company:atzuche</p>
 * @author zhiping.li
 * @date 2015年12月18日下午2:16:09
 */
public interface IHttpCaseService {

	/**
	 * 
	 *@Title: getHttpCase 
	 *@Description: 获取项目
	 *@param @return
	 *@param @throws Exception 
	 *@return Map<String,Action> 
	 *@throws 
	 *@auther zhiping.li
	 *@date 2015年12月7日上午11:32:06
	 */
	public Map<String, Action> getHttpCase() throws Exception;
	
	
	public Action getActions(String url)throws Exception;
	
	/**
	 * 获取响应参数列表
	 *@Title: getResponseGridTrees 
	 *@Description: TODO
	 *@param @param url
	 *@param @return
	 *@param @throws Exception 
	 *@return List<JqGridTree> 
	 *@throws 
	 *@auther zhiping.li
	 *@date 2015年12月4日上午9:43:04
	 */
	public List<JqGridTree> getResponseGridTrees(String url)throws Exception;
	
	/**
	 * 获取请求参数列表
	 *@Title: getRequestGridTrees 
	 *@Description: TODO
	 *@param @param url
	 *@param @return
	 *@param @throws Exception 
	 *@return List<JqGridTree> 
	 *@throws 
	 *@auther zhiping.li
	 *@date 2015年12月4日上午9:42:55
	 */
	public List<JqGridTree> getRequestGridTrees(String url)throws Exception;

	/**
	 * 
	 *@Title: httpRun 
	 *@Description: 运行API
	 *@param @param url
	 *@param @param method
	 *@param @param requestData
	 *@param @param responseData
	 *@param @return 
	 *@return List<String>
	 * @throws Exception 
	 *@throws 
	 *@auther zhiping.li
	 *@date 2015年12月4日上午9:40:22
	 */
	public List<String> httpRun(String url, String method,
			List<JqGridTree> requestData, List<JqGridTree> responseData) throws Exception;
}
