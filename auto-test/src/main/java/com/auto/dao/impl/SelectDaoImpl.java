package com.auto.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.auto.bo.CarBrand;
import com.auto.bo.CarType;
import com.auto.dao.ISelectDao;

@Repository
public class SelectDaoImpl extends NamedParameterJdbcDaoSupport implements ISelectDao{

	@Autowired
	public void setSuperNamedParameterJdbcTemplate(JdbcTemplate jdbcTemplate){
		super.setJdbcTemplate(jdbcTemplate);
	}

	@Override
	public List<CarBrand> query() {
		List<CarBrand> carBrands = getNamedParameterJdbcTemplate().query("select id,txt from car_param where flag=1",new RowMapper<CarBrand>(){
			@Override
			public CarBrand mapRow(ResultSet rs, int paramInt)
					throws SQLException {
				CarBrand carBrand = new CarBrand();
				carBrand.setBrandId(rs.getInt("id"));
				carBrand.setBrandName(rs.getString("txt"));
				return carBrand;
			}});
		 
		return carBrands;
	}


	@Override
	public List<CarType> queryTypes(Integer brandId) {
		Map<String,Object> parameters = new HashMap<String,Object>();
		parameters.put("brandId", brandId);
		List<CarType> typeList = getNamedParameterJdbcTemplate().query("select id,txt from car_param where flag = 2 and brand_id = :brandId",parameters,new RowMapper<CarType>() {
			@Override
			public CarType mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				CarType carType = new CarType();
				carType.setTypeId(rs.getInt("id"));
				carType.setTypeName(rs.getString("txt"));
				return carType;
			}
		});
		return typeList;
	}


	@Override
	public CarBrand queryBrands(Integer brandId, List<Integer> typeIds) {
		Map<String,Object> brandParameters = new HashMap<String,Object>();
		Map<String,Object> typeParameters = new HashMap<String,Object>();
		brandParameters.put("brandId", brandId);
		typeParameters.put("brandId", brandId);
		typeParameters.put("typeIds", typeIds);
		List<CarBrand> carBrands = getNamedParameterJdbcTemplate().query("select id,txt from car_param where flag=1 and id = :brandId",brandParameters,new RowMapper<CarBrand>(){
			@Override
			public CarBrand mapRow(ResultSet rs, int paramInt)
					throws SQLException {
				CarBrand carBrand = new CarBrand();
				carBrand.setBrandId(rs.getInt("id"));
				carBrand.setBrandName(rs.getString("txt"));
				return carBrand;
			}});

		if (!CollectionUtils.isEmpty(carBrands)) {
			for (CarBrand carBrand : carBrands) {
				List<CarType> typeList = getNamedParameterJdbcTemplate().query("select id,txt from car_param where flag = 2 and brand_id = :brandId and id in (:typeIds)",typeParameters, new RowMapper<CarType>() {
					@Override
					public CarType mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						CarType carType = new CarType();
						carType.setTypeId(rs.getInt("id"));
						carType.setTypeName(rs.getString("txt"));
						return carType;
					}
				});
				carBrand.setTypeList(typeList);
			}
		}
		return !CollectionUtils.isEmpty(carBrands)?carBrands.get(0):null;
	}

	 
}
