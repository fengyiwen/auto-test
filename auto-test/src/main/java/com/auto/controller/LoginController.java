package com.auto.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	@RequestMapping(value="login",method=RequestMethod.GET)
	public String login(){
		return "login";
	}
	@RequestMapping(value="login",method = RequestMethod.POST)
	public String doLogin(@RequestParam String username,@RequestParam String password,HttpServletRequest request){
		 //获取认证异常的类名
       // AuthenticationException ae = (AuthenticationException) request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
		AuthenticationToken token = new UsernamePasswordToken(username, password);
		SecurityUtils.getSubject().login(token);
		return "redirect:index";
	}
}
