package com.project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class CompanyRentContractCopyController implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception ex) {
		 ModelAndView mv=new ModelAndView();
	        //判断异常类型，来跳转不同页面
	        if (ex instanceof MaxUploadSizeExceededException){ 
	            //指定错误信息
	            mv.addObject("errormessage", "上传文件过大");
	            //设置跳转视图
	            mv.setViewName("/jsp/uploadContract.jsp");
	            return mv;
	        }  
	        //其他异常
	        return null;
		
	}
	

}
