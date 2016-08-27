package com.auto.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class BaseJdbcDao extends JdbcDaoSupport{

	@Autowired
	public void setSuperJdbcTemplate(JdbcTemplate jdbcTemplate){
		setJdbcTemplate(jdbcTemplate);
	}
	public <T> T queryForObject(String sql, Class<T> mappedClass, Object... args) throws DataAccessException {
		return getJdbcTemplate().queryForObject(sql, args, BeanPropertyRowMapper.newInstance(mappedClass));
	}
	
	public <T> List<T> queryForList(String sql, Class<T> mappedClass, Object... args)throws DataAccessException{
		
		return getJdbcTemplate().query(sql, args, BeanPropertyRowMapper.newInstance(mappedClass));
	}
	
}
