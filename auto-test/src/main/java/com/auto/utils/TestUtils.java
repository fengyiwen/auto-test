package com.auto.utils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.util.CollectionUtils;
/**
 * 测试赋值类
 * @author john
 *
 */
public class TestUtils {

	private static  final Logger logger = LogManager.getLogger(TestUtils.class);
	/**
	 * 根据sql获取参数以及参数值
	 * @param sql
	 * @return
	 */
	
	
	public static Map<String, Object> getExpectDataFromDB(String sql) {
		logger.info("sql:{}",sql);
		String url = ProUtils.getConfig("url");
		String username = ProUtils.getConfig("username");
		String password = ProUtils.getConfig("password");
		String driverClass = ProUtils.getConfig("driverClass");
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driverClass);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
		if (!CollectionUtils.isEmpty(list)) {
			return list.get(0);
		}
		return null;
	}
	
	public static List getExpectListFromDB(String sql){
		logger.info("sql:{}",sql);
		String url = ProUtils.getConfig("url");
		String username = ProUtils.getConfig("username");
		String password = ProUtils.getConfig("password");
		String driverClass = ProUtils.getConfig("driverClass");
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driverClass);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
		if (!CollectionUtils.isEmpty(list)) {
			return list;
		}else{
			return new ArrayList();
		}
		
	}
	
	
}
