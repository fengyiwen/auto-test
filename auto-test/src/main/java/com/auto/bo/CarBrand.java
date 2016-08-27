package com.auto.bo;

import java.io.Serializable;
import java.util.List;

public class CarBrand implements Serializable{

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = -2666565626226151873L;
	private Integer brandId;
	private String brandName;
	private List<CarType> typeList;
	public Integer getBrandId() {
		return brandId;
	}
	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public List<CarType> getTypeList() {
		return typeList;
	}
	public void setTypeList(List<CarType> typeList) {
		this.typeList = typeList;
	}
	
	
}
