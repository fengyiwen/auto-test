package com.auto.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.auto.bo.BaseOut;
import com.auto.bo.JqGridTree;
import com.auto.common.SystemConstant;
import com.auto.domain.Action;
import com.auto.service.IHttpCaseService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class IndexController {

	@Autowired
    private IHttpCaseService httpCaseService;
 
	@RequestMapping("index")
	public String index(){
		return "index";
	}
	@RequestMapping("welcome")
	public String welcome(){
		return "welcome";
	}
	@RequestMapping("http")
	public String http(){
		
		return "http";
	}
	@RequestMapping("test")
	public String test(){
		
		return "test";
	}
	@RequestMapping("/getCaseJson")
	@ResponseBody
	public Action getCaseJson(String url){
		try {
			Map<String, Action> map = httpCaseService.getHttpCase();
			return map.get(url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

	@RequestMapping("/saveCase")
	@ResponseBody
	public BaseOut saveCase(@RequestBody String jsonData){
		BaseOut baseOut = new BaseOut();
		baseOut.setResCode("000000");
		baseOut.setResMsg("success");
		return baseOut;
	}
	
 
	
	/**
	 * 
	 *@Title: getResponseJqGridTree 
	 *@Description: 查找响应参数列表
	 *@param @param url
	 *@param @return 
	 *@return Map<String,Object> 
	 *@throws 
	 *@auther zhiping.li
	 *@date 2015年12月3日下午3:51:01
	 */
	@RequestMapping("/getResponseJqGridTree")
	@ResponseBody
	public Map<String, Object> getResponseJqGridTree(@RequestParam String url){
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("userdata", new ArrayList<Object>());
		try {
			List<JqGridTree> row = httpCaseService.getResponseGridTrees(url);
			map.put("rows", row);
			map.put("total", row.size());
			map.put("page", 1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
	
	
	/**
	 * 
	 *@Title: getRequestJqGridTree 
	 *@Description: 查找请求参数列表
	 *@param @param url
	 *@param @return 
	 *@return Map<String,Object> 
	 *@throws 
	 *@auther zhiping.li
	 *@date 2015年12月3日下午3:50:34
	 */
	@RequestMapping("/getRequestJqGridTree")
	@ResponseBody
	public Map<String, Object> getRequestJqGridTree(@RequestParam String url){
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("userdata", new ArrayList<Object>());
		try {
			List<JqGridTree> row = httpCaseService.getRequestGridTrees(url);
			map.put("rows", row);
			map.put("total", row.size());
			map.put("page", 1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
	
	/**
	 * 
	 *@Title: saveInterface 
	 *@Description: 保存数据请求，响应的数据到json文件
	 *@param @param jsonData
	 *@param @param url
	 *@param @param request
	 *@param @return 
	 *@return BaseOut 
	 *@throws 
	 *@auther zhiping.li
	 *@date 2015年12月3日下午4:50:56
	 */
	@RequestMapping("/saveInterface")
	@ResponseBody
	public BaseOut saveInterface(@RequestBody String jsonData,@RequestParam String url,HttpServletRequest request){
		BaseOut baseOut = new BaseOut();
		try {
			
			String fileName = "interface-"+url.substring(url.lastIndexOf("/")-4).replace("/", "-")+".json";
			System.out.println("测试："+fileName+","+jsonData);
			File file = new File(SystemConstant.JSON_FILE_PATH+fileName);
			if (!file.exists()) {
				file.createNewFile();
			}
			FileUtils.writeStringToFile(file, jsonData);
			baseOut.setResCode("000000");
			baseOut.setResMsg("success");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return baseOut;
	}
	
	@RequestMapping("/httpRun")
	@ResponseBody
	public BaseOut httpRun(@RequestBody String jsonData,@RequestParam String url){
		BaseOut baseOut = new BaseOut();
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			HashMap<String, List<JqGridTree>> map = objectMapper.readValue(jsonData, new TypeReference<HashMap<String, List<JqGridTree>>>() {});
			List<JqGridTree> requestData = map.get("rquestData");
			List<JqGridTree> responseData = map.get("responseData");
			String method = "";
			List<String> messages = httpCaseService.httpRun(url,method,requestData,responseData);
			baseOut.setResCode("000000");
			baseOut.setResMsg("success");
			baseOut.setData(messages);
		} catch (Exception e) {
			baseOut.setResCode("999999");
			baseOut.setResMsg("failure");
		}
		return baseOut;
	}
}
