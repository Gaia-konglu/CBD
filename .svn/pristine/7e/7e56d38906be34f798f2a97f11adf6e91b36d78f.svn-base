package com.project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.bean.ComplainBean;
import com.project.bean.OrderBean;
import com.project.bean.PersonBean;
import com.project.service.IComplainService;
import com.project.service.IPersonService;
import com.project.service.ITenantService;

@Controller
public class ShowOrderAndBferInferController {
	@Autowired
	private ITenantService service;
	@Autowired
	private IPersonService service2;
	@Autowired
	private IComplainService service3;
	@RequestMapping("/orderAndBfer.do")
	public @ResponseBody String showOrderAndDfer(String trade_id,HttpSession session,Integer rent_id,ComplainBean com){
		System.out.println("trade_id"+trade_id+"           rent_id"+rent_id);
		OrderBean order=service.findThingBycp_or_id(trade_id);
		PersonBean tena=service2.selectById(rent_id);
		order.setTenant(tena);
		
//		try {
			com.getOrder().setId(trade_id);
			com.getPerson2().setId(rent_id);
			com=service3.findComolainByidAndOrder_id(com);
			if(com==null){
				session.setAttribute("cont", null);
				session.setAttribute("trade1_id", trade_id);
				session.setAttribute("rent_id1", rent_id);
				session.setAttribute("order_dfer", order);
				return "success";
			}
			System.out.println("dsfdsfsdfsfs"+ 123);
			session.setAttribute("cont", com.getComplainContent());
			session.setAttribute("trade1_id", trade_id);
			session.setAttribute("rent_id1", rent_id);
			session.setAttribute("order_dfer", order);
			return "success";
//		} catch (NullPointerException e) {
//			session.setAttribute("cont", null);
//			session.setAttribute("trade1_id", trade_id);
//			session.setAttribute("rent_id1", rent_id);
//			session.setAttribute("order_dfer", order);
//			return "success";
//		}
		
	}

}
