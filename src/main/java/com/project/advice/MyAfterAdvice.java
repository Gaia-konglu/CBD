package com.project.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.bean.RearLoginLogBean;
import com.project.bean.RearOperationLogBean;
import com.project.service.impl.RearLogServiceImpl;

@Component
@Aspect
public class MyAfterAdvice {
	
	@Autowired
	private RearLogServiceImpl service;
	
	
	// com.project.service.impl.RearLogServiceImpl.insertOperationLog
	//修改后台个人信息 的后置顾问   
	@AfterReturning(value="execution(* com.project.controller.BackgroundAction.updateBack(..))",returning="result")
	public void afterReturning(JoinPoint jp, Object result) {
		// TODO Auto-generated method stub
		
		RearOperationLogBean rol = new RearOperationLogBean();
		rol.setModule("修改后台管理员的密码、电话号码的模块");
		rol.setOperation("修改后台管理员的密码、电话号码");
		rol.setFlag(1);
		
		service.insertOperationLog(rol);
		
        String methodName = jp.getSignature().getName();
        System.out.println("【返回通知】the method 【" + methodName + "】 ends with 【" + result + "】");
	
		System.out.println("==============");
		System.out.println("后置通知");
	}

	
	//审批包租婆申请添加的私人招租车位信息的后置顾问
   @AfterReturning(value="execution(* com.project.controller.WaitApproveController.approve(..))",returning="result")
	public void approve(JoinPoint jp, Object result) {
		// TODO Auto-generated method stub
		
		RearOperationLogBean rol = new RearOperationLogBean();
		rol.setModule("审核批准包租婆车位的模块");
		rol.setOperation("通过审核");
		rol.setFlag(1);
		
		service.insertOperationLog(rol);
		
        String methodName = jp.getSignature().getName();
        System.out.println("【返回通知】the method 【" + methodName + "】 ends with 【" + result + "】");
	
		System.out.println("==============");
		System.out.println("后置通知");
	}
   
   
    /*
   //后台登录的后置顾问
   @AfterReturning(value="execution(* com.project.controller.BackStageController.login(..))",returning="result")
	public void backgroundLogin(JoinPoint jp, Object result) {
		// TODO Auto-generated method stub
		
	   
	   
	    RearLoginLogBean rll = new RearLoginLogBean();
		
	    rll.setFlag(1);
	    rll.setAddr("成都.武侯区");
	    
		rll.setName("");
		
		
		service.insertRegisterLog(rll);
		
       String methodName = jp.getSignature().getName();
       System.out.println("【返回通知】the method 【" + methodName + "】 ends with 【" + result + "】");
	
		System.out.println("==============");
		System.out.println("后置通知");
	}
   */
}
