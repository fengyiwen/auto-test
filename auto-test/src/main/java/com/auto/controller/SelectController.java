package com.auto.controller;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.auto.bo.CarBrand;
import com.auto.bo.CarType;
import com.auto.dao.ISelectDao;

@Controller
public class SelectController {

	@Autowired
	private ISelectDao selectDao;
	
	@RequestMapping("/queryType")
	@ResponseBody
	public List<CarType> queryType(@RequestParam Integer brandId){
		List<CarType> carTypes = selectDao.queryTypes(brandId);
		return carTypes;
	}
	
	@RequestMapping("/genCarBrandJSON")
	public String selectIndex(Model model){
		model.addAttribute("brandList", selectDao.query());
		return "genCarBrandJSON";
	}
	
	@RequestMapping("/genJson")
	@ResponseBody
	public String genJson(@RequestBody String jsonData){
		JSONObject jsonObject = JSONObject.fromObject(jsonData);
        @SuppressWarnings({ "deprecation", "unchecked" })
		CarBrand carBrand = selectDao.queryBrands(jsonObject.getInt("brandId"),  JSONArray.toList(JSONArray.fromObject(jsonObject.get("typeIds")), List.class));
		return JSONObject.fromObject(carBrand).toString();
	}
}
