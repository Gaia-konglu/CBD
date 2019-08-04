package com.project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.bean.PartingSpaceBean;
import com.project.service.impl.ApprovalOpinionServiceImpl;

//查询需要审批的包租婆添加的所有私人招租车位信息+包租婆的个人信息
@Controller
public class WaitApproveController {

	@Autowired
	private ApprovalOpinionServiceImpl service;
	
	//查找需要审批的包租婆的车位信息 （flag = 0）
	@RequestMapping("/WaitApprove.do")
	public @ResponseBody Map<String, Object> findAll( int page, PartingSpaceBean bean, HttpServletRequest request){
		
		List<PartingSpaceBean> list = service.queryParking(page);
		
		//查询总页数
		int pages = service.findWaitApproveTotalPage();
		
		Map< String, Object> map=new HashMap<String, Object>();
		
		map.put("list", list);
		map.put("pages", pages);
		
		System.out.println("WaitApproveController里 list="+ list);
		
		//request.setAttribute("WaitApproveList", list);
		
		System.out.println("在WaitApproveController里");
		
	//	return "redirect:/jsp/WaitApprove.jsp";   /*重定向*/
    //	return "jsp/WaitApprove.jsp";    	      /*请求派发*/
	//	return "forward:jsp/WaitApprove.jsp";     /*请求派发*/
		
		return map;
	}
	
	
	//审批包租婆的车位信息（点击通过）
	@RequestMapping("/Approve.do")
	public String approve(HttpServletRequest request,int id){
		System.out.println("在WaitApproveController里2");
		
		boolean row = service.approval(id);
		
		if(row == true){
			return "/jsp/WaitApprove.jsp";
		}
		return "redirect:/html/fail.html";
				
	}
	
	
	//一键审批包租婆的车位信息（一键点击通过）
		@RequestMapping("/oneKeyApprove.do")
		public String oneKeyApprove(HttpServletRequest request){
			System.out.println("在WaitApproveController里3 oneKey");
			
			boolean row = service.oneKeyApproval();
			
			if(row == true){
				return "/jsp/WaitApprove.jsp";
			}
			return "redirect:/html/fail.html";
					
		}
	
}
