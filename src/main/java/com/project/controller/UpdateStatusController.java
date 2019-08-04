package com.project.controller;

import java.text.DecimalFormat;

import javax.servlet.http.HttpSession;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.bean.BackStageBean;
import com.project.bean.ComplainBean;
import com.project.bean.PersonBean;
import com.project.service.IComplainService;
import com.project.service.IPersonService;
import com.project.service.ITenantService;

@Controller
public class UpdateStatusController {
	@Autowired
	private IComplainService service;
	@Autowired
	private ITenantService service2;
	@Autowired
	private IPersonService service3;
	@RequiresPermissions("complainMP")
	@RequestMapping("/returnContent.do")
	public @ResponseBody String updataStatus(String status1,String returnContent,int id,HttpSession session){
		System.out.println(status1+"   "+returnContent);
		System.out.println("是否是投诉生效  "+service.isSuccessComplain(status1));
		if(service.isSuccessComplain(status1)){
			System.out.println("投诉生效进入");
			ComplainBean complain=service.findComplainById(id);
			complain.setStatus(status1);
			complain.setReturnContent(returnContent);
			
			
			int bsb_dfer_id=complain.getPerson2().getId();
			System.out.println("被投诉者id  "+bsb_dfer_id);
			int count=service.findComplainCountBynferAndStatus(complain)+1;
			System.out.println("被投诉数量"+count);
			
			int complainTenantCount=service2.findCountByPersonId(bsb_dfer_id, bsb_dfer_id);
			System.out.println("被投诉人订单数"+complainTenantCount);
			
			DecimalFormat df = new DecimalFormat("#.00");
			double c=(double)count;
			double ctc=(double)complainTenantCount;
			double d=Double.parseDouble(df.format(c/ctc));
			System.out.println("保留一位小数"+d);
			int credit=(int) ((1-d)*100);
			if(credit>100){
				credit=100;
			}
			System.out.println("信誉度："+credit);
			
			PersonBean per=new PersonBean();
			per.setId(bsb_dfer_id);
			per.setCredit(credit);
			
			service3.updateCreditById(per);
			
			BackStageBean backStage=(BackStageBean) session.getAttribute("backStageBean");
			int bsb_id=backStage.getId();
			complain.getBsb().setId(bsb_id);
			service.updateComplainRecontentAndStatus(complain);
			
			session.setAttribute("updatesta", "修改成功确认跳转回投诉栏");
			
			System.out.println("updatetesta:"+session.getAttribute("updatesta"));
			
			return "success";
			
		}
		
		ComplainBean complain=service.findComplainById(id);
		
		System.out.println("被投诉人id"+complain.getPerson2().getId());
		complain.setStatus(status1);
		complain.setReturnContent(returnContent);
		//管理员id
		BackStageBean backStage=(BackStageBean) session.getAttribute("backStageBean");
		int bsb_id=backStage.getId();
		complain.getBsb().setId(bsb_id);
		service.updateComplainRecontentAndStatus(complain);
		
		session.setAttribute("updatesta", "修改成功确认跳转回投诉栏");
		
		return "success";
	}

}
