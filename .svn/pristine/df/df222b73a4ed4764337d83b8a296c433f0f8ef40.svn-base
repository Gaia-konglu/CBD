package com.project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.bean.CarportBean;
import com.project.bean.PagesBean;
import com.project.service.ICarportService;

@Controller
public class ShowCarportController {
	
	@Autowired
	private ICarportService ser;
	
	@RequiresPermissions("carportMP")
	@RequestMapping("/showAllCarport.do")
	public @ResponseBody Map<String, Object> showAllCarport(Integer pageNow){
		
		int totalCount=ser.coutPages();
		
		PagesBean pb=new PagesBean(pageNow,totalCount);
		
		List<CarportBean> cblist=ser.findAllCarport(pb);
		System.out.println(cblist.get(0).getStatus());
		Map< String, Object> map=new HashMap<String, Object>();
	map.put("cblist", cblist);
	map.put("pb", pb);
		return map;
		
		
		
		
	}
	
	@RequestMapping("/selectCarportByCondition.do")
	public @ResponseBody Map<String, Object> selectCarportByCondition(Integer pageNow,CarportBean cb){
		
		int totalCount=ser.coutPages2(cb);
		
		PagesBean pb=new PagesBean(pageNow,totalCount);
		
		List<CarportBean> cblist=ser.findCarportByCondition(pb,cb);
	
		Map< String, Object> map=new HashMap<String, Object>();
	map.put("cblist", cblist);
	map.put("pb", pb);
		return map;
		
		
		
		
	}

}
