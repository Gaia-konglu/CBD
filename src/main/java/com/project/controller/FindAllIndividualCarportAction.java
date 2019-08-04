package com.project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.bean.PartingSpaceBean;
import com.project.service.impl.ApprovalOpinionServiceImpl;

//查看全部私人招租车位信息
@Controller
public class FindAllIndividualCarportAction{

	@Autowired
	private ApprovalOpinionServiceImpl service;
	
	@RequestMapping("/findAll.do")
	public @ResponseBody Map<String, Object> findAll( int page, PartingSpaceBean bean, HttpSession httpsession){
		
		System.out.println("findAll.do 中 page="+ page);
		 List<PartingSpaceBean> list = service.findAll(page);
		
		 //查询总页数
		 int pages = service.findAllTotalPage();
		 
		System.out.println("FindAllIndividualCarportAction里 list="+ list);
		
	//	httpsession.setAttribute("RentInforList", list);
		
       Map< String, Object> map=new HashMap<String, Object>();
		
		map.put("list", list);
		map.put("pages", pages);
				
	//	return "redirect:/jsp/findAll.jsp";
		return map;
	}
	
}
