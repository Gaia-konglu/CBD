package com.project.controller;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class logoutController {
	
	@RequestMapping("backclose.do")
	public String logout(){
		//在shiro里面关闭session
		SecurityUtils.getSubject().logout();
		return "redirect:/jsp/backendLogin.jsp";

	}
	
	@RequestMapping("frontclose.do")
	public String logout2(){
		
		SecurityUtils.getSubject().logout();
		return "redirect:/jsp/frontLogin.jsp";
	}
}
