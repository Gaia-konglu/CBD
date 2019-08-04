package com.project.controller;



import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.bean.ComplainBean;
import com.project.bean.PagesBean;
import com.project.service.IComplainService;

@Controller
public class ShowAllComplainController {
	@Autowired
	private IComplainService service;
	@RequiresPermissions("complainMP")
	@RequestMapping("/showComplain.do")
	public @ResponseBody String showAllComplain(HttpSession session,PagesBean page,Integer pageNow){
	    String status="未受理";
	    
	    if(pageNow==null){
	    	System.out.println(123131231);
	    	pageNow=1;
	    }
	    
	    page.setStatus(status);
	    page.setPageNow(pageNow);
	    System.out.println("dsjfnsf"+"   "+page.getStartPos());
	    page.setPageSize(5);
	   int uc =service.findUntreateComplainCount(status);
	   page.setTotalCount(uc);
	   int untreateCount=page.getTotalPageCount();
	   
	   System.out.println("未处理投诉的栏目页数"+untreateCount);
	   System.out.println("未处理投诉总个数"+uc);
	   
		List<ComplainBean> list=service.findUntreatComplain(page);
		session.setAttribute("showComplain", list);
		session.setAttribute("pageNow", pageNow);
		session.setAttribute("showStatus", status);
		session.setAttribute("untreateCount", untreateCount);
		session.setAttribute("isWait", "false");
		session.setAttribute("uc",uc);
//		return "redirect:jsp/ShowAllComplain.jsp";
		return "success";
	}


}
