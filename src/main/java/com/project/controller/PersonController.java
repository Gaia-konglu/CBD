package com.project.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.bean.PersonBean;
import com.project.service.IPersonService;

@Controller
public class PersonController {
	@Autowired
	private IPersonService service;
	@RequestMapping("/updatePerson.do")
	public ModelAndView updateBack(PersonBean pb, HttpSession httpsession){
		ModelAndView model=new ModelAndView();
		model.setViewName("/jsp/MyInfor.jsp");
		if(!pb.getPhone().matches("^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$|{0}")){
			model.addObject("result", "电话格式不对");
			return model;
		}
		if(!pb.getPassword().matches("^[a-zA-Z0-9]{6,15}$|{0}")){
			model.addObject("result","密码只能为6-15位数字或字母组成");
			return model;
		}
		if(!pb.getJob().matches("^[\u2E80-\u9FFF]+$|{0}")){
			model.addObject("result", "工作请输入汉字");
			return model;
		}
		if(!pb.geteMail().matches("/^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$/|{0}")){
			model.addObject("result", "邮箱格式不对");
			return model;
		}
		//取个人用户登录时存在session中的id
		PersonBean pbb = (PersonBean) httpsession.getAttribute("person");
		if(pbb==null){pbb=(PersonBean) httpsession.getAttribute("tenant");}
		int id=pbb.getId();
		if(pb.getPassword().matches("^[a-zA-Z0-9]{6,15}$")){
		 String name=pbb.getName();
		 SimpleHash hash=new SimpleHash("md5", pb.getPassword(), name, 3);
		 String hashPass=hash.toBase64();
		 pb.setPassword(hashPass);}
		if(service.ChangeInfo(pb, id)){
			model.addObject("result","修改成功");
			return model;}
		model.addObject("result","修改失败");
		return model;
	}
}
