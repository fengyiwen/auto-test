package com.auto.dao;

import java.util.List;

import com.auto.bo.CarBrand;
import com.auto.bo.CarType;

public interface ISelectDao {

	public List<CarBrand> query();
	
	public List<CarType> queryTypes(Integer brandId);
	
	public CarBrand queryBrands(Integer brandId,List<Integer> typeIds);
}
