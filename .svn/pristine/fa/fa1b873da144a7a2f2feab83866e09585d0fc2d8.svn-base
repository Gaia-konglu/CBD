package com.project.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.project.bean.BackStageBean;
import com.project.bean.CompanyBean;
import com.project.bean.PersonBean;
import com.project.service.ICompanyService;
import com.project.service.IPersonService;
import com.project.service.ISuperBackService;

public class test2 {
	@Test
	public void test32(){
	ApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");
	ISuperBackService service= context.getBean(ISuperBackService.class);
//	PersonBean pb=service.selectById(1);
//	PersonBean pb=new PersonBean();
//	CompanyBean cb=new CompanyBean();
	BackStageBean bsb=new BackStageBean();

	
	System.out.println(service.addBack(bsb));
	
	}

}
