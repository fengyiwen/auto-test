package com;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.CollectionUtils;

import com.auto.bo.CarBrand;
import com.auto.bo.CarType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations={"classpath:applicationContext-test.xml"})
public class JdbcTest {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Test
	public void queryTest(){
		List<CarBrand> carBrands = jdbcTemplate.query("select id,txt from car_param where flag=1",new RowMapper<CarBrand>(){
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
				List<CarType> typeList = jdbcTemplate.query("select type_id,txt from car_param where flag = 2 and brand_id = "+carBrand.getBrandId(), new RowMapper<CarType>() {
					@Override
					public CarType mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						CarType carType = new CarType();
						carType.setTypeId(rs.getInt("type_id"));
						carType.setTypeName(rs.getString("txt"));
						return carType;
					}
				});
				carBrand.setTypeList(typeList);
			}
		}
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			System.out.println(objectMapper.writeValueAsString(carBrands));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
