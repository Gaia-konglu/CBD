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
public class SeeComplainController {
	@Autowired
	private IComplainService service;
	
	@RequestMapping("/seeComplain.do")
	public @ResponseBody String seeComplain(String or_id,int ren_id,HttpSession session,ComplainBean com){
		System.out.println("订单id"+or_id+"    被投诉id"+ren_id);
		com.getOrder().setId(or_id);
		com.getPerson2().setId(ren_id);
		ComplainBean com1=service.findComolainByidAndOrder_id(com);
		session.setAttribute("seeCom",com1);
		return "success";
	}

}
