package com.auto.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.auto.bo.TransBase;
import com.auto.dao.ITransDao;
@Repository
public class TransDaoImpl extends NamedParameterJdbcDaoSupport implements ITransDao{

	@Autowired
	public void setSuperNamedParameterJdbcTemplate(JdbcTemplate jdbcTemplate){
		super.setJdbcTemplate(jdbcTemplate);
	}
	
	@Override
	public TransBase query(Long orderNo) {
		Map<String, Object> paramsMap=new HashMap<String, Object>();
		paramsMap.put("orderNo", orderNo);
		List<TransBase> orderList=getNamedParameterJdbcTemplate().query("SELECT order_no ,owner_phone,renter_phone,car_no,owner_no,renter_no FROM trans where order_no =:orderNo", paramsMap,new RowMapper<TransBase>() {
			@Override
			public TransBase mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				TransBase trans=new TransBase();
				trans.setCarNo(rs.getInt("car_no"));
				trans.setOrderNo(rs.getLong("order_no"));
				trans.setOwnerPhone(rs.getLong("owner_phone"));
				trans.setRenterPhone(rs.getLong("renter_phone"));
				trans.setRenterPhone(rs.getLong("renter_no"));
				trans.setRenterPhone(rs.getLong("owner_no"));
				return trans;
			}
			
		});
		return !CollectionUtils.isEmpty(orderList)?orderList.get(0):null;
	}

}
