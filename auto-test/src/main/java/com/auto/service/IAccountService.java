package com.auto.service;

import java.util.List;

import com.auto.bo.Corporation;
import com.auto.domain.User;
/**
 * 
 *<p>Title:IAccountService</p>
 *<p>Description:账号服务</p>
 *<p>Company:atzuche</p>
 * @author zhiping.li
 * @date 2015年12月18日下午2:15:46
 */
public interface IAccountService {
	/**
	 * 
	 *@Title: validate 
	 *@Description: 校验账号和密码
	 *@param @param account
	 *@param @param password
	 *@param @return 
	 *@return boolean 
	 *@throws 
	 *@auther zhiping.li
	 *@date 2015年12月18日下午2:06:43
	 */
	boolean validate(String account, String password);
	
	/**
	 * 
	 *@Title: addUser 
	 *@Description: 添加用户
	 *@param @param user
	 *@param @return 
	 *@return boolean 
	 *@throws 
	 *@auther zhiping.li
	 *@date 2015年12月18日下午2:09:53
	 */
	boolean addUser(User user);
	
	/**
	 * 
	 *@Title: getUser 
	 *@Description: 根据用户id查找用户
	 *@param @param userId
	 *@param @return 
	 *@return User 
	 *@throws 
	 *@auther zhiping.li
	 *@date 2015年12月18日下午2:10:08
	 */
	User getUser(long userId);
	
	List<User> getUserList();
	
	List<User> getUserList(int teamId);
	
	User getUser(String account);
	
	boolean changePassword(String account, String oldPassword,
			String newPassword);
	
	long getUserId(String account);
	
	void changeProfile(long userId, String profileProperty, String profileValue);
	
	boolean updateProfile(long userId, String name, String email,
			String password, String newPassword);
	
	void _updatePassword(String account, String password);
	
	List<Corporation> getCorporationList();
	
	List<Corporation> getCorporationListWithPager(long userId, int pageNum, int pageSize);
}
