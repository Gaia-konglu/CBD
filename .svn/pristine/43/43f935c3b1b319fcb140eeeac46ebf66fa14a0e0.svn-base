package com.project.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.project.bean.CarportBean;
import com.project.bean.CompanyRentContractBean;
import com.project.bean.ThirdParkContractBean;
import com.project.dao.ICompanyRentContractDao;
import com.project.dao.IThirdParkContractDao;

public class Test5 {
	@Test
	public void test1(){
		ApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");
//		ICompanyRentContractDao dao = (ICompanyRentContractDao) context.getBean("companyRentContractDaoImpl",ICompanyRentContractDao.class);
	    IThirdParkContractDao dao=(IThirdParkContractDao) context.getBean("thirdParkContractDaoImpl",IThirdParkContractDao.class);
	    ThirdParkContractBean bean=new ThirdParkContractBean();
	    bean.setCompany("asd");
	    dao.addThirdRentContract(bean);
		System.out.println(bean.getId());
	}

}
