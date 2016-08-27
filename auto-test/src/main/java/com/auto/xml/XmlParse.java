package com.auto.xml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
import com.auto.bo.JqGridTree;
import com.auto.bo.TreeNode;
import com.auto.common.SystemConstant;
import com.auto.domain.Action;
import com.auto.domain.Module;
import com.auto.domain.Page;
import com.auto.domain.Parameter;
import com.auto.http.HttpResponse;
import com.auto.http.HttpUtils;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
/**
 * 
 *<p>Title:XmlParse</p>
 *<p>Description:xml转换工具</p>
 *<p>Company:atzuche</p>
 * @author zhiping.li
 * @date 2015年11月27日上午10:07:25
 */
public class XmlParse {

	/**
	 * 
	 *@Title: XmlToBean 
	 *@Description: 转换xml模板信息为apiBean
	 *@param  xml
	 *@return ApiInfo 
	 *@throws Exception
	 *@auther zhiping.li
	 *@date 2015年11月27日上午10:06:49
	 */
	public static ApiInfo xmlToBean(String xml){
		XStream xStream = new XStream(new DomDriver());
		xStream.autodetectAnnotations(true);
		xStream.processAnnotations(ApiInfo.class);
		return (ApiInfo) xStream.fromXML(XmlParse.class.getClassLoader().getResourceAsStream(xml));
	}

	public static void main(String[] args)  {
		try {

			//List<JqGridTree> trees = getRequestGridTrees("http://localhost:8080/v30/car/list");
			//	System.out.println(trees.size());
			Action action = getHttpCase().get("http://localhost:8080/v30/car/list");
			//JSONObject jsonObject = new JSONObject();
			//Map<String, String> map = new HashMap<String,String>();
		//	param(action.getRequestParameterList(), jsonObject, map);
			//System.out.println(jsonObject);
	 
			Map<String, Object> map = new HashMap<String,Object>();
			getTree(action.getRequestParameterList(),map);
			System.out.println(JSONObject.fromObject(map));
			
			List<JqGridTree> list = getRequestGridTrees("http://localhost:8080/v30/car/list");
			System.out.println(JSONArray.fromObject(buildtree(list,"972")));
			Map<String, Object> map1 = new HashMap<String,Object>();
			getTree1(buildtree(list,"972"),map1);
			System.out.println(JSONObject.fromObject(map1));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	 
	public static void  getTree1(List<TreeNode> parameters,Map<String, Object> map){
		for (TreeNode parameter : parameters) {
			Map<String, Object> paramMap = new HashMap<>();
			if (!CollectionUtils.isEmpty(parameter.getChildren())) {
				getTree1(parameter.getChildren(),paramMap);
			}
			map.put(parameter.getName(), MapUtils.isEmpty(paramMap)?null:paramMap);
		}
	}
 
	

	private static List<TreeNode> buildtree(List<JqGridTree> list,String id) {
		List<TreeNode> treeNodes=new ArrayList<TreeNode>();
		for (JqGridTree jqGridTree: list) {
			TreeNode node=new TreeNode();
			node.setName(jqGridTree.getName());
			node.setValue(jqGridTree.getValue());
			if (id.equals(jqGridTree.getParent_id())) {
				node.setChildren(buildtree(list, jqGridTree.getId()+""));
				treeNodes.add(node);
			}
		}
		return treeNodes;
	}

	public static void  getTree(Set<Parameter> parameters,Map<String, Object> map){
		for (Parameter parameter : parameters) {
			Map<String, Object> paramMap = new HashMap<>();
			if (!CollectionUtils.isEmpty(parameter.getParameterList())) {
				getTree(parameter.getParameterList(),paramMap);
			}
			map.put(parameter.getIdentifier(), MapUtils.isEmpty(paramMap)?null:paramMap);
		}
	}
 

	 

	public static Map<String, Action> getHttpCase(){
		try {
			JSONObject modelJSON = new JSONObject();
			ObjectMapper objectMapper = new ObjectMapper();
			File file = new File("src/main/resources/project-5.json");
			if (file.exists()) {
				Map<?, ?> json = objectMapper.readValue(file, Map.class);
				modelJSON = JSONObject.fromObject(json.get("modelJSON"));
				System.out.println(json);
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
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static List<JqGridTree> getRequestGridTrees(String url) throws Exception {
		String fileName = "interface-"+url.substring(url.lastIndexOf("/")-4).replace("/", "-")+".json";
		File file = new File(SystemConstant.JSON_FILE_PATH+fileName);
		if (file.exists()) {
			ObjectMapper objectMapper = new ObjectMapper();
			HashMap<String, List<JqGridTree>> map = objectMapper.readValue(file, new TypeReference<HashMap<String, List<JqGridTree>>>() {});
			System.out.println(map.get("rquestData"));
			return map.get("rquestData");
		}
		Map<String, Action> aMap = getHttpCase();
		Action action = aMap.get(url);
		System.out.println("id："+action.getId());
		List<JqGridTree> grids = new ArrayList<JqGridTree>();
		Set<Parameter> parameters =action.getRequestParameterList();
		int i = 0;
		getTree(parameters,grids,action.getId(),i);

		return grids;
	}
	private static void getTree(Set<Parameter> parameters,
			List<JqGridTree> grids,long pid,int i) {
		if (!CollectionUtils.isEmpty(parameters)) {
			for (Parameter parameter: parameters) {
				JqGridTree grid = new JqGridTree();
				grid.setName(parameter.getIdentifier());
				grid.setParent_id(pid+"");
				grid.setLoaded(true);
				grid.setId(parameter.getId());
				grid.setLevel(i);
				grid.setExpanded(false);
				grid.setType(parameter.getDataType());
				if (!CollectionUtils.isEmpty(parameter.getParameterList())) {
					grid.setIsLeaf("false");
				}else {
					grid.setIsLeaf("true");
				}
				if (parameter.getIdentifier().equals("typeList")) {
					System.out.println(parameter.getIdentifier());
				}
				grid.setRemark(parameter.getRemark());
				grid.setDescription(parameter.getName());
				grids.add(grid);
				if (CollectionUtils.isNotEmpty(parameter.getParameterList())) {
					i=i+1;
					getTree(parameter.getParameterList(), grids,parameter.getId(),i);
				}
			}
		}

	}
}
