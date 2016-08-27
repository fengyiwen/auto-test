package com.auto.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.auto.dao.IAccountDao;
import com.auto.domain.Notification;
import com.auto.domain.User;
@Repository
public class AccountDaoImpl extends BaseJdbcDao implements IAccountDao {

	@Override
	public boolean validate(String account, String password) {
		User user = super.queryForObject("select * from tb_user where account = ?", User.class, account);
		return user!=null && user.getPassword().equals(password);
	}

	@Override
	public boolean addUser(User user) {
        StringBuffer sql = new StringBuffer();
        sql.append("insert into tb_user(account");
        sql.append(",password,name,email");
        sql.append(",is_hint_enabled,last_login_date,");
        sql.append("incorrect_login_attempt,realname,");
        sql.append("emp_id) values(?,?,?,?,?,?,?,?,?)");
		return getJdbcTemplate().update(sql.toString(),user.getAccount()
				,user.getPassword(),user.getName(),
				user.getEmail(),user.getIsHintEnabled(),user.getLastLoginDate()
				,user.getIncorrectLoginAttempt()
				,user.getRealname(),user.getEmpId())>0?true:false;
	}

	@Override
	public User getUser(long userId) {
		 
		return super.queryForObject("select * from tb_user where id = ?", User.class, userId);
	}

	@Override
	public User getUser(String account) {
		return super.queryForObject("select * from tb_user where account = ?", User.class, account);
	}

	@Override
	public boolean changePassword(String account, String oldPassword,
			String newPassword) {
		User user = getUser(account);
		if (user!=null && user.getPassword().equals(oldPassword)) {
			return false;
		}
		return getJdbcTemplate().update("update tb_user set password = ? where id = ? ",new Object[]{newPassword,user.getId()})>0?true:false;
	}

	@Override
	public long getUserId(String account) {
		User user = getUser(account);
		return user!=null ? user.getId() : -1;
	}

	@Override
	public void changeProfile(long userId, String profileProperty,
			String profileValue) {
		 User user = getUser(userId);
		 if (profileProperty.equals("isHintEnabled")) {
			 user.setIsHintEnabled(profileValue.equals("true") ? true : false);
			 getJdbcTemplate().update("update tb_user set is_hint_enabled = ? where id = ?",user.getIsHintEnabled(),user.getId());
		 }
	}

	@Override
	public boolean updateProfile(long userId, String name, String email,
			String password, String newPassword) {
		User user = getUser(userId);
		StringBuffer sql = new StringBuffer();
		if (user!=null) {
			if (!StringUtils.isEmpty(name)) {
				user.setName(name);
			}
			if (!StringUtils.isEmpty(email)) {
				user.setEmail(email);
			}
			if (!StringUtils.isEmpty(password) && !StringUtils.isEmpty(newPassword)) {
				if (user.getPassword().equals(password)) {
					user.setPassword(newPassword);
				}
			}
		}
		sql.append("update tb_user set name = ? ,email = ? , password = ? where id = ? ");
		return getJdbcTemplate().update(sql.toString(),name,email,newPassword,userId)>0?true:false;
	}

	@Override
	public List<User> getUserList() {

		return super.queryForList("select * from tb_user",User.class);
	}

	@Override
	public void _changePassword(String account, String password) {
		this.getJdbcTemplate().update("update tb_user set password = ? where account = ?", password,account);

	}

	@Override
	public User getUserByName(String name) {
		 
		return queryForObject("select * from tb_user where name = ?", User.class, name);
	}

	@Override
	public Map<String, String> getUserSettings(long userId) {
	   return  super.getJdbcTemplate().execute("select key,value from tb_user_setting where user_id = ?", new PreparedStatementCallback<Map<String, String>>() {

			@Override
			public Map<String, String> doInPreparedStatement(PreparedStatement ps)
					throws SQLException, DataAccessException {
			    Map<String, String> result = new HashMap<String, String>();
			    
				return result;
			}
		});
		 
	}

	@Override
	public String getUserSetting(long userId, String key) {
	 
		return null;
	}

	@Override
	public void updateUserSetting(long userId, String key, String value) {


	}

	@Override
	public List<Notification> getNotificationList(long userId) {

		return null;
	}

	@Override
	public void clearNotificationList(long userId) {
	

	}

	@Override
	public void addNotification(Notification notification) {


	}

	@Override
	public void readNotification(long id) {


	}

	@Override
	public void readNotificationList(long userId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Notification> getUnreadNotificationList(long curUserId) {
		
		return null;
	}

	@Override
	public boolean notificationExists(Notification notification) {

		return false;
	}

	@Override
	public long getUsertNum() {
	
		return 0;
	}

	@Override
	public void updateUser(User user) {
	 

	}

	@Override
	public List<Integer> getUserIdList(int teamId) {
		 
		return null;
	}


}
