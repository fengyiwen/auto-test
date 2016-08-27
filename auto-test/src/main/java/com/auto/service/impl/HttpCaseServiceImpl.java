package com.auto.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.springframework.stereotype.Service;

import com.auto.bo.JqGridTree;
import com.auto.bo.TreeNode;
import com.auto.common.SystemConstant;
import com.auto.domain.Action;
import com.auto.domain.Module;
import com.auto.domain.Page;
import com.auto.domain.Parameter;
import com.auto.http.HttpResponse;
import com.auto.http.HttpUtils;
import com.auto.service.IHttpCaseService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
@Service
public class HttpCaseServiceImpl implements IHttpCaseService{

	@Override
	public Map<String, Action> getHttpCase() throws Exception {
		JSONObject modelJSON = new JSONObject();
		ObjectMapper objectMapper = new ObjectMapper();
		File file = new File(SystemConstant.JSON_FILE_PATH+"project-5.json");
		if (file.exists()) {
			Map<?, ?> json = objectMapper.readValue(file, Map.class);
			modelJSON = JSONObject.fromObject(json.get("modelJSON"));
			//System.out.println(json);
		}else {
			file.createNewFile();
			OutputStream out = new FileOutputStream(file);
			HttpResponse response = HttpUtils.getRapJson("http://10.0.3.244:9080/api/queryRAPModel.do?projectId=5");
			JSONObject jsonObject = JSONObject.fromObject(response.getResponseBodyObject());
			out.write(jsonObject.toString().getBytes());
			out.flush();
			out.close();
			modelJSON = JSONObject.fromObject(jsonObject.get("modelJSON"));
		}
		JSONArray moduleList = JSONArray.fromObject(modelJSON.get("moduleList"));
		List<Module> modules =  objectMapper.readValue(moduleList.toString(), new TypeReference<List<Module>>() {});
		Map<String, Action> map = new HashMap<String, Action>();
		for (Module module : modules) {
			Iterator<Page> iterator = module.getPageList().iterator();
			while (iterator.hasNext()) {
				Page page = iterator.next();
				for (Action action :page.getActionList() ) {
					map.put(action.getRequestUrl(), action);
				}
			}
		}
		return map;
	}



	@Override
	public Action getActions(String url)throws Exception{

		return getHttpCase().get(url);
	}


	@Override
	public List<JqGridTree> getResponseGridTrees(String url) throws Exception {
		String fileName = "interface-"+url.substring(url.lastIndexOf("/")-4).replace("/", "-")+".json";
		File file = new File(SystemConstant.JSON_FILE_PATH+fileName);
		if (file.exists()) {
			ObjectMapper objectMapper = new ObjectMapper();
			HashMap<String, List<JqGridTree>> map = objectMapper.readValue(file, new TypeReference<HashMap<String, List<JqGridTree>>>() {});
			return CollectionUtils.isEmpty(map.get("responseData"))?getRequestJqGrid(url):map.get("responseData");
		}
		return  getRequestJqGrid(url);
	}



	private List<JqGridTree> getRequestJqGrid(String url) throws Exception {
		Map<String, Action> aMap = getHttpCase();
		Action action = aMap.get(url);
		List<JqGridTree> grids = new ArrayList<JqGridTree>();
		Set<Parameter> parameters = action.getResponseParameterList();
		int i = 0;
		getTree(parameters,grids,action.getId(),i);
		return grids;
	}

	/**
	 * 
	 *@Title: getTree 
	 *@Description: 递归遍历参数
	 *@param @param parameters
	 *@param @param grids
	 *@param @param pid
	 *@param @param i 
	 *@return void 
	 *@throws 
	 *@auther zhiping.li
	 *@date 2015年12月7日上午9:50:57
	 */
	private void getTree(Set<Parameter> parameters,
			List<JqGridTree> grids,long pid,int i) {
		if (!CollectionUtils.isEmpty(parameters)) {
			for (Parameter parameter: parameters) {
				JqGridTree grid = new JqGridTree();
				grid.setName(parameter.getIdentifier());
				grid.setParent_id(pid+"");
				grid.setLoaded(true);
				grid.setId(parameter.getId());
				grid.setLevel(i);
				grid.setExpanded(true);
				grid.setType(parameter.getDataType());
				if (!CollectionUtils.isEmpty(parameter.getParameterList())) {
					grid.setIsLeaf("false");
				}else {
					grid.setIsLeaf("true");
				}
				grid.setRemark(parameter.getRemark());
				grid.setDescription(parameter.getName());
				grids.add(grid);
				if (CollectionUtils.isNotEmpty(parameter.getParameterList())) {
					i = i+1;
					getTree(parameter.getParameterList(), grids,parameter.getId(),i);
				}
			}
		}

	}

	@Override
	public List<JqGridTree> getRequestGridTrees(String url) throws Exception {
		String fileName = "interface-"+url.substring(url.lastIndexOf("/")-4).replace("/", "-")+".json";
		File file = new File(SystemConstant.JSON_FILE_PATH+fileName);
		if (file.exists()) {
			ObjectMapper objectMapper = new ObjectMapper();
			HashMap<String, List<JqGridTree>> map = objectMapper.readValue(file, new TypeReference<HashMap<String, List<JqGridTree>>>() {});
			return CollectionUtils.isEmpty(map.get("rquestData"))?getResponseJqGrid(url):map.get("rquestData");
		}
		return getResponseJqGrid(url);
	}



	private List<JqGridTree> getResponseJqGrid(String url) throws Exception {
		Map<String, Action> aMap = getHttpCase();
		Action action = aMap.get(url);
		List<JqGridTree> grids = new ArrayList<JqGridTree>();
		Set<Parameter> parameters = action.getRequestParameterList();
		int i = 0;
		getTree(parameters,grids,action.getId(),i);
		return grids;
	}

	@Override
	public List<String> httpRun(String url, String method,
			List<JqGridTree> requestData, List<JqGridTree> responseData) throws Exception {
		
		Action action = getHttpCase().get(url);

		//获得请求参数
		Map<String, Object> requestParam = new HashMap<>();
		buildMapParam(buildtree(requestData, action.getId()+""), requestParam);

		//预期响应参数
		Map<String, Object> responseParam = new HashMap<>();
		buildMapParam(buildtree(responseData, action.getId()+""), responseParam);

		//执行api
		HttpResponse response = HttpUtils.postRequest(url, requestParam, false, false);

		//得到返回结果
		Map<?, ?> resMap = response.getResponseBodyObject();

		//比较返回结果跟预期响应结果
		List<String> resultMessages = compareToResult(resMap,responseParam);

		return resultMessages;
	}


	/**
	 * 
	 *@Title: compareToResult 
	 *@Description: 比较返回结果跟预期结果
	 *@param @param resMap
	 *@param @param responseParam 
	 *@return void 
	 *@throws 
	 *@auther zhiping.li
	 *@date 2015年12月7日上午10:06:49
	 */
	private List<String> compareToResult(Map<?, ?> resMap, Map<String, Object> responseParam) {
		List<String> list = new ArrayList<String>();
		for (Map.Entry<String, Object> entry : responseParam.entrySet()) {
			if (resMap.containsKey(entry.getKey())) {

			}
		}
		return list;
	}


	/**
	 * 
	 *@Title: buildMapParam 
	 *@Description: 根据树节点得到map结构的数据
	 *@param @param nodes
	 *@param @param map 
	 *@return void 
	 *@throws 
	 *@auther zhiping.li
	 *@date 2015年12月7日上午10:10:52
	 */
	public static void  buildMapParam(List<TreeNode> nodes,Map<String, Object> map){
		for (TreeNode parameter : nodes) {
			Map<String, Object> paramMap = new HashMap<>();
			if (!CollectionUtils.isEmpty(parameter.getChildren())) {
				buildMapParam(parameter.getChildren(),paramMap);
			}
			map.put(parameter.getName(), MapUtils.isEmpty(paramMap)?parameter.getValue():paramMap);
		}
	}



	/**
	 * 
	 *@Title: buildtree 
	 *@Description: 构建树节点结构
	 *@param @param list
	 *@param @param id
	 *@param @return 
	 *@return List<TreeNode> 
	 *@throws 
	 *@auther zhiping.li
	 *@date 2015年12月7日上午10:09:59
	 */
	private static List<TreeNode> buildtree(List<JqGridTree> list,String id) {
		List<TreeNode> treeNodes = new ArrayList<TreeNode>();
		for (JqGridTree jqGridTree: list) {
			TreeNode node = new TreeNode();
			node.setName(jqGridTree.getName());
			node.setValue(jqGridTree.getValue());
			if (id.equals(jqGridTree.getParent_id())) {
				node.setChildren(buildtree(list, jqGridTree.getId()+""));
				treeNodes.add(node);
			}
		}
		return treeNodes;
	}
}
