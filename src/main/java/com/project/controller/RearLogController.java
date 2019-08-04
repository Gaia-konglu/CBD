package com.project.controller;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.AlternativeJdkIdGenerator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.bean.RearLoginLogBean;
import com.project.bean.RearOperationLogBean;
import com.project.service.impl.RearLogServiceImpl;

//后台日志
@Controller
public class RearLogController {

	@Autowired
	private RearLogServiceImpl service;
	
	//查看后台登录日志
	@RequestMapping("/queryRegisterLog.do")
	public @ResponseBody Map<String, Object> RegisterLog(HttpServletRequest request, int page){
		System.out.println("在RearLogController里 RegisterLog这个方法");
		
		System.out.println("在RearLogController里 RegisterLog这个方法里 page="+page);
			
		List<RearLoginLogBean> list = service.queryRegisterLog(page);
		int pages = service.findLoginLogTotalPage();
		
		Map< String, Object> map=new HashMap<String, Object>();
		map.put("RegisterLogpages", pages);
		map.put("RegisterLogList", list);
		return map;
					
	}
	
	
	//查看后台操作日志
	@RequestMapping("/queryOperationLog.do")
	public @ResponseBody Map<String, Object> OperationLog(HttpServletRequest request, int page){
		System.out.println("在RearLogController里 RegisterLog这个方法");
		
		System.out.println("在RearLogController里 RegisterLog这个方法里 page="+page);
			
		List<RearOperationLogBean> list = service.queryOperationLog(page);
		
		//查看RealOperationLog的总页数
		int pages = service.findRealOperationTotalPage();
		
		Map< String, Object> map=new HashMap<String, Object>();
		map.put("RegisterLogpages", pages);
		map.put("RegisterLogList", list);
		return map;
					
	}
	
}
