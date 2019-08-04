package com.project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.project.bean.BackStageBean;
import com.project.bean.PagesBean;
import com.project.service.ISuperBackService;

@Controller
public class showBackstageController {

	@Autowired
	private ISuperBackService ser;

	@RequiresPermissions("adminMP")
	@RequestMapping("/findAllback.do")
	public @ResponseBody Map<String, Object> showAllBack(Integer pageNow) {
             Map<String, Object> map=new HashMap<String, Object>();
           
		
		
            int totalCount=ser.coutPages();
		
		PagesBean pb=new PagesBean(pageNow,totalCount);
		pb.setPageSize(5);
		List<BackStageBean> bsblist = ser.findAllBackStage(pb);

	
		  map.put("pb", pb);
		  map.put("bsblist", bsblist);

		return map;
	}
	@RequestMapping("/findBackByid.do")
	public ModelAndView findById(Integer id){
		
		ModelAndView model=new ModelAndView();
        BackStageBean bab= ser.findBackbyId(id);
		model.addObject("ubab", bab);
		model.setViewName("/jsp/altrBackStage.jsp");
        
        
		
		return model;
		
	}
	
	@RequestMapping("findBycondition.do")
	public @ResponseBody Map<String, Object> showAllByCondition(BackStageBean bsb,Integer pageNow) {
        Map<String, Object> map=new HashMap<String, Object>();
      
	
	
       int totalCount=ser.coutPages();
	
	PagesBean pb=new PagesBean(pageNow,totalCount);
	
	List<BackStageBean> bsblist = ser.findAllByCondition(bsb,pb);

	  map.put("pb", pb);
	  map.put("bsblist", bsblist);

	return map;
}
	
	@RequestMapping("deleteBack.do")
	public @ResponseBody String deleteById(Integer id){
		
	String result=ser.deleteById(id);
		
		
		return result;
		
	}

}
