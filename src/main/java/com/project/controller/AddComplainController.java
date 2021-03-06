package com.project.controller;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.bean.ComplainBean;
import com.project.bean.PersonBean;
import com.project.service.IComplainService;

@Controller
public class AddComplainController {
	@Autowired
	private IComplainService service;
	
	@RequestMapping("/addCompl.do")
	public String addComplain(ComplainBean com,String ComplainContent,HttpSession session,ServletRequest request){
		System.out.println(ComplainContent);
		String trade_id= (String) session.getAttribute("trade1_id");
		int rent_id=(int) session.getAttribute("rent_id1");
//		PersonBean per=(PersonBean) session.getAttribute("personbean");
//		System.out.println("----------"+per.getId());
//		com.getPerson().setId(per.getId());
		if(session.getAttribute("person")==null){
			PersonBean per=(PersonBean) session.getAttribute("tenant");
			com.getPerson().setId(per.getId());
			com.getOrder().setId(trade_id);
			com.getPerson2().setId(rent_id);
			
			session.setAttribute("disab", trade_id);
			service.AddComplain(com);
			ComplainBean com2=service.findComolainByidAndOrder_id(com);
			session.setAttribute("cont", com2.getComplainContent());
			System.out.println(session.getAttribute("cont"));
			return "redirect:jsp/landLadyTradeInfor.jsp";
		}
		PersonBean per=(PersonBean) session.getAttribute("person");
		com.getPerson().setId(per.getId());
		com.getOrder().setId(trade_id);
		
		com.getPerson2().setId(rent_id);
		session.setAttribute("disab", trade_id);
		service.AddComplain(com);
		ComplainBean com2=service.findComolainByidAndOrder_id(com);
		session.setAttribute("cont", com2.getComplainContent());
		System.out.println(session.getAttribute("cont"));
		return "redirect:jsp/landLadyTradeInfor.jsp";
	}

}
