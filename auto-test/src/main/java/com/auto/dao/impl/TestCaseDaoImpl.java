package com.auto.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.auto.bo.TestCase;
import com.auto.dao.TestCaseDao;
@Repository
public class TestCaseDaoImpl extends NamedParameterJdbcDaoSupport implements TestCaseDao{
	@Autowired
	public void setSuperNamedParameterJdbcTemplate(JdbcTemplate jdbcTemplate){
		super.setJdbcTemplate(jdbcTemplate);
	}
	
	@Override
	public int insert(TestCase testCase) {
		String sql="insert into test_case(model,test_caes,exp_data,act_data,error_log,test_result_data,test_data) values(:model,:testCaes,:expData,:actData,:errorLog,:testResultData,:testData) ";
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("model", testCase.getModel());
		paramMap.put("testCaes", testCase.getTestCaes());
		paramMap.put("expData", testCase.getExpData());
		paramMap.put("actData", testCase.getActData());
		paramMap.put("errorLog", testCase.getErrorLog());
		paramMap.put("testResultData", testCase.getTestResultData());
		paramMap.put("testData", testCase.getTestData());
		
		Integer count= getNamedParameterJdbcTemplate().update(sql, paramMap);
		return count;
	}

}
