package com.auto.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.auto.dao.ITestRecodeDao;
@Repository
public class TestRecodeImpl extends NamedParameterJdbcDaoSupport implements ITestRecodeDao{

	@Autowired
	public void setSuperNamedParameterJdbcTemplate(JdbcTemplate jdbcTemplate){
		super.setJdbcTemplate(jdbcTemplate);
	}
	
	@Override
	public int insert() {
		String sql="insert into test_order_recode(order_no) values(:order) ";
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("order", 1);
		Integer count= getNamedParameterJdbcTemplate().update(sql, paramMap);
		return count;
	}
}
