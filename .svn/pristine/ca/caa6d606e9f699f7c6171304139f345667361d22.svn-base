package com.project.controller;

import javax.servlet.http.HttpSession;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.bean.ComplainBean;
import com.project.service.IComplainService;

@Controller
public class HandleComplainController {
	@Autowired
	private IComplainService service;
	@RequiresPermissions("complainMP")
	@RequestMapping("/showCom.do")
	public @ResponseBody String handleComplain(int id,HttpSession session){
	    System.out.println(id);
	    ComplainBean com=service.findComplainById(id);
	    session.setAttribute("handle", com);
	    System.out.println(com);
		return "success";
	}

}
