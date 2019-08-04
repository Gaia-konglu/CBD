package com.project.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.binding.BindingException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.bean.ComplainBean;
import com.project.bean.PagesBean;
import com.project.service.IComplainService;

@Controller
public class FindCperComplainController {
	@Autowired
	private IComplainService service;
	@RequiresPermissions("complainMP")
	@RequestMapping("/findcperComplain.do")
	public @ResponseBody String findCperComplain(Integer pageNow,HttpSession session,String name2,PagesBean page){
//		System.out.println(name+"33333333"+name2);
//		
//		
//		try {
//			int id=service.fingSingleContaintByCper(name,name2);
//			 System.out.println("11111111111111111111"+"      "+id);
//				ComplainBean com=service.findComplainById(id);
//				System.out.println(com);
//				session.setAttribute("handle", com);
//				
//				return "success";
//			
//		} catch (BindingException e) {
//			System.out.println("12312314312313");
//			return "loser";
//		}
		 if(pageNow==null){
		    	System.out.println(123131231);
		    	pageNow=1;
		    }
		String status="投诉生效";
		page.setName(name2);
		page.setStatus(status);
		 page.setPageNow(pageNow);
		 page.setPageSize(5);
		 List<ComplainBean> list=service.findcomBystaAndPerName(page);
		 if(list==null){
			 return "loser";
		 }
		 int uc=service.findCountBystandname(page);
		 page.setTotalCount(uc);
		 int untreateCount=page.getTotalPageCount();
		 session.setAttribute("showComplain", list);
			session.setAttribute("pageNow", pageNow);
			session.setAttribute("showStatus", status);
			session.setAttribute("untreateCount", untreateCount);
			session.setAttribute("isWait", "false");
			session.setAttribute("dfna11", name2);
			session.setAttribute("uc",uc);
		return "success";
		
	}

}
