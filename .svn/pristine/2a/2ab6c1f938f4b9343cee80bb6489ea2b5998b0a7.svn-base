package com.project.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.bean.TimeBean;
import com.project.dao.impl.timedaoImpl;

@Controller
public class TimerController {
	@Autowired
	private timedaoImpl dao;
	
	@RequestMapping("111.do")
	public String showTime(HttpSession session){
		List<TimeBean> list=dao.selectAll();
		session.setAttribute("List", list);
		
		System.out.println("111");
		
		return "redirect:/jsp/Showtime.jsp";
//		return "redirect:/jsp/aaaJsp.jsp";
	}
}
