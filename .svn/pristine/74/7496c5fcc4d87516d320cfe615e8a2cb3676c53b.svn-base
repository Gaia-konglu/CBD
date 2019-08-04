package com.project.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.bean.BackStageBean;
import com.project.service.IBackStageService;
import com.project.service.ISuperBackService;
import com.project.service.impl.BackServiceImpl;

@Controller
public class SuperBackController {
	@Autowired
	private ISuperBackService service;
	@Autowired
	private IBackStageService backService;
	//添加管理员
	@RequiresPermissions("adminMP")
	@RequestMapping("/addBack.do")
	public ModelAndView addBack(@Valid BackStageBean bsb,BindingResult res){
		
	ModelAndView model=new ModelAndView();

	BackStageBean sbsb= backService.findByNum(bsb.getNum());
	if(sbsb!=null){
		model.setViewName("/jsp/addBackStage.jsp");
		model.addObject("accountExist","工号已存在");
		model.addObject("bsb", bsb);
		return model;
	}
	
	
		if(res.hasErrors()){
			List<FieldError> list=	res.getFieldErrors();
			
			for (FieldError error : list) {
				System.out.println(error.getField()+"****"+error.getDefaultMessage());
				String message=error.getDefaultMessage();
				if(error.getDefaultMessage().startsWith("Failed")){
					message="请输入数字";
				}
				model.addObject("err_"+error.getField(), message);
				model.addObject("bsb", bsb);
				model.setViewName("/jsp/addBackStage.jsp");
				return model;
			}
		
		}
		
	 String num=bsb.getNum();
	 SimpleHash hash=new SimpleHash("md5", bsb.getPass(), num, 3);
	 String hashPass=hash.toBase64();
	 bsb.setPass(hashPass);
		
		if(service.addBack(bsb)){	
		model.setViewName("redirect:/jsp/addBackStageSuccess2.jsp"); 
		return model;
		}
		
		model.setViewName("redirect:/html/fail.html");
		return model;
		
	}
	//修改管理员权限
	@RequiresPermissions("adminMP")
	@RequestMapping("/updateBackau.do")
	public String updateBack(@Validated BackStageBean bsb){
		
		//取管理员登录时存在session中的id
//		String name=bsb.getName();
		if(service.ChangeBackInfo(bsb)){	
		return "redirect:/jsp/altrBackStageSuccess.jsp";}
		return "redirect:/html/fail.html";
	}
	//获取所有后台管理员的名字和id
	
}
