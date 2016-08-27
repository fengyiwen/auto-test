package com.auto.service.impl;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.auto.service.IAccountService;
@Component
public class MyRealm extends AuthorizingRealm{

	@Autowired
	private IAccountService accountService;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		//获取当前登录的用户名,等价于(String)principals.fromRealm(this.getName()).iterator().next()  
		String currentUsername = (String)super.getAvailablePrincipal(principals);  
		SimpleAuthorizationInfo simpleAuthorInfo = new SimpleAuthorizationInfo();  
		//实际中可能会像上面注释的那样从数据库取得  
		if(null!=currentUsername && "mike".equals(currentUsername)){  
			//添加一个角色,不是配置意义上的添加,而是证明该用户拥有admin角色    
			simpleAuthorInfo.addRole("admin");  
			//添加权限  
			simpleAuthorInfo.addStringPermission("admin:manage");  
			System.out.println("已为用户[mike]赋予了[admin]角色和[admin:manage]权限");  
			return simpleAuthorInfo;  
		}
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken)authcToken;  
		System.out.println("验证当前Subject时获取到token为" + ReflectionToStringBuilder.toString(token, ToStringStyle.MULTI_LINE_STYLE));  
		//	      User user = userService.getByUsername(token.getUsername());  
		//	      if(null != user){  
		//	          AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), user.getNickname());  
		//	          this.setSession("currentUser", user);  
		//	          return authcInfo;  
		//	      }else{  
		//	          return null;  
		//	      }  
		//此处无需比对,比对的逻辑Shiro会做,我们只需返回一个和令牌相关的正确的验证信息  
		//说白了就是第一个参数填登录用户名,第二个参数填合法的登录密码(可以是从数据库中取到的,本例中为了演示就硬编码了)  
		//这样一来,在随后的登录页面上就只有这里指定的用户和密码才能通过验证  
		if("mike".equals(token.getUsername())){  
			AuthenticationInfo authcInfo = new SimpleAuthenticationInfo("mike", "mike", this.getName());  
			this.setSession("currentUser", "mike");  
			return authcInfo;  
		}
		//没有返回登录用户名对应的SimpleAuthenticationInfo对象时,就会在LoginController中抛出UnknownAccountException异常  
		return null; 
	}

	private void setSession(String key, String value) {
		Subject currentUser = SecurityUtils.getSubject();  
		if(null != currentUser){  
			Session session = currentUser.getSession();  
			System.out.println("Session默认超时时间为[" + session.getTimeout() + "]毫秒");  
			if(null != session){  
				session.setAttribute(key, value);  
			}  
		}  
	}

}
