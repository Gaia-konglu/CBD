package com.project.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.bean.BackStageBean;
import com.project.bean.ComplainBean;
import com.project.bean.PagesBean;
import com.project.service.IComplainService;

@Controller
public class WaitHandleController {
	@Autowired
	 private IComplainService service;
	@RequestMapping("/waitHandle.do")
	public @ResponseBody String waitHandle(HttpSession session,PagesBean page,Integer pageNow,ComplainBean bean){
		 String status="暂缓处理";
		 if(pageNow==null){
		    	System.out.println(123131231);
		    	pageNow=1;
		    }
//			List<ComplainBean> list=service.findUntreatComplain(page);
//			session.setAttribute("showComplain", list);
		 page.setStatus(status);
		 System.out.println("当前页数"+pageNow);
		    page.setPageNow(pageNow);
		    System.out.println("dsjfnsf"+"   "+page.getStartPos());
		    page.setPageSize(10);
		    bean.setStatus(status);
//		    int ad_id=(int) session.getAttribute("id");
		    BackStageBean back=(BackStageBean) session.getAttribute("backStageBean");
		    
		    bean.getBsb().setId(back.getId());
		   int uc =service.findComplainCountByStatusAndad_id(bean);
		   page.setTotalCount(uc);
		   int untreateCount=page.getTotalPageCount();
//		   int ad_id=(int) session.getAttribute("id");
		   
		   
		   page.setAd_id(back.getId());
			List<ComplainBean> list=service.findComplianByad_idAndStatus(page);
			session.setAttribute("showComplain", list);
			session.setAttribute("pageNow", pageNow);
			session.setAttribute("showStatus", status);
			session.setAttribute("untreateCount", untreateCount);
			session.setAttribute("isWait", "true");
			session.setAttribute("uc", uc);
			return "success";
	}

}
