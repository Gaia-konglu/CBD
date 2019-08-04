package com.project.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.project.bean.CarportBean;
import com.project.bean.validate.v_carport;
import com.project.service.ICarportService;

@Controller
public class AddCarportController {

	@Autowired
	private ICarportService ser;
	@RequiresPermissions(value={"carportMP","contractMP"},logical=Logical.OR)
	@RequestMapping("addSingleCarport.do")
	public ModelAndView addSingleCarPort(CarportBean cpb,BindingResult res){
		
		String result= ser.addCarport(cpb);
		ModelAndView model=new ModelAndView();
		if(result.equals("地址不能为空") || result.equals("车位编号不能为空")){
			model.addObject("adressException",result);
			model.setViewName("/jsp/addcarport2.jsp");
			model.addObject("carportbean",cpb);
			return model;
		}
		
		
		model.addObject("addcarportsuccess",result);
		model.setViewName("redirect:/jsp/addCarportSuccess2.jsp");
		return model;

	}
	@RequiresPermissions(value={"carportMP","contractMP"},logical=Logical.OR)
	@RequestMapping("addManyCarport.do")
	public ModelAndView addManyCarport(@Valid CarportBean cb,String areaId,v_carport vc,BindingResult res){
		
		
		String result=ser.addManyCarport(cb, areaId, vc.getCaportId(), vc.getCarportNum());
		ModelAndView model=new ModelAndView();
		if(result.equals("地址不能为空") || result.equals("车位区域编号不能为空")
				|| result.equals("车位起始编号错误") || result.equals("车位数量错误")){
			model.addObject("adressException",result);
			model.setViewName("/jsp/addManyCarport2.jsp");
			model.addObject("carportbean",cb);
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
				model.setViewName("/jsp/addManyCarport2.jsp");
				model.addObject("carportbean",cb);
				return model;
			}
		}
		
		model.addObject("addcarportsuccess",result);
		model.setViewName("redirect:/jsp/addCarportSuccess2.jsp");
		return model;
		
	}
	
	
	@RequiresPermissions("carportMP")
	@RequestMapping("updateCarport.do")
	public ModelAndView updateCarport(@Valid CarportBean cpb,BindingResult res){
		ModelAndView model=new ModelAndView();
		
		if(res.hasErrors()){
			List<FieldError> list=	res.getFieldErrors();
			
			for (FieldError error : list) {
				String message=error.getDefaultMessage();
				model.addObject("adressException", message);
				model.setViewName("/jsp/updatecarport.jsp");
				return model;
			}
		
		}
		//System.out.println("进入了更新车位信息controller");
		ser.updateCarport(cpb);
		//System.out.println("进入了更新车位信息controller");
		model.setViewName("/jsp/addCarportSuccess2.jsp");
		
		return model;

	}
	@RequiresPermissions("carportMP")
	@RequestMapping("deletecarport.do")
	public @ResponseBody String deletecarport(int[] carportId){
		
		ser.deletecarport(carportId);
		
		return "删除成功";
		
		
	}
	
}