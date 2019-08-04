package com.project.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.project.bean.CarportBean;
import com.project.bean.CompanyBean;
import com.project.dao.ICompanyDao;

public class test_6 {
	//根据登录名查询企业名称
	@Test
	public void test1(){
		ApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");
		ICompanyDao dao = (ICompanyDao) context.getBean("companyDaoImpl",ICompanyDao.class);
		CompanyBean bean = dao.findCompanyNameByAdmin("admin1");
		System.out.println(bean);
	}
	//企业已租赁车位模糊查询
	@Test
	public void test2_2_1(){
		ApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");
		ICompanyDao dao = (ICompanyDao) context.getBean("companyDaoImpl",ICompanyDao.class);
		List<CarportBean> num = dao.findCompanyAlreadyRentedFuzzyQuery(0,"成都蜗牛学院","","","","2018-10-11","");
		System.out.println(num);
	}
	//企业已租赁车位模糊查询总数量（分页）
	@Test
	public void test2_2_2(){
		ApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");
		ICompanyDao dao = (ICompanyDao) context.getBean("companyDaoImpl",ICompanyDao.class);
		int num = dao.findCompanyAlreadyRentedFuzzyQueryTotalNum("成都蜗牛学院","","","","2018-10-09","");
		System.out.println(num);
	}
	//CBD平台未租赁车位模糊查询
	@Test
	public void test3_2_1(){
		ApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");
		ICompanyDao dao = (ICompanyDao) context.getBean("companyDaoImpl",ICompanyDao.class);
		List<CarportBean> list = dao.findCompanyNotRentedFuzzyQuery(0,"","","2018-10-11");
		System.out.println(list);
	}
	
	//CBD平台未租赁车位模糊查询总数量（分页）
	@Test
	public void test3_2_2(){
		ApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");
		ICompanyDao dao = (ICompanyDao) context.getBean("companyDaoImpl",ICompanyDao.class);
		int num = dao.findCompanyNotRentedFuzzyQueryTotalNum("","","");
		System.out.println(num);
	}
	
	//根据输入企业名称、楼层位置、联系人以及联系电话的模糊查找功能
	@Test
	public void test4(){
		ApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");
		ICompanyDao dao = (ICompanyDao) context.getBean("companyDaoImpl",ICompanyDao.class);
		CompanyBean bean = new CompanyBean();
		bean.setName("牛");
		bean.setAddr("化");
		bean.setContacts("三");
		bean.setPhone("68");
		List<CompanyBean> list = dao.findCompany(bean,0);
		System.out.println(list);
	}
	//查询模糊查询企业总数量（分页）
	@Test
	public void test4_2(){
		ApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");
		ICompanyDao dao = (ICompanyDao) context.getBean("companyDaoImpl",ICompanyDao.class);
		CompanyBean bean = new CompanyBean();
		bean.setName("牛");
		bean.setAddr("化");
		bean.setContacts("三");
		bean.setPhone("68");
		int num = dao.findCompanyTotalNum(bean);
		System.out.println(num);
	}
	//根据输入企业信息进行新增企业
	@Test
	public void addCompany() {
		ApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");
		ICompanyDao dao = (ICompanyDao) context.getBean("companyDaoImpl",ICompanyDao.class);
		CompanyBean companyBean = new CompanyBean();
		companyBean.setAdmin("admin6");
		companyBean.setPass("666");
		companyBean.setName("成都蜗牛学院6");
		companyBean.setAddr("成都孵化园6");
		companyBean.setContacts("赵八");
		companyBean.setPhone("18776576865");
		boolean bo = dao.addCompany(companyBean);
		System.out.println("test boolean:"+bo);
	}
	//删除企业（软删除）
	@Test
	public void deleteCompany() {
		ApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");
		ICompanyDao dao = (ICompanyDao) context.getBean("companyDaoImpl",ICompanyDao.class);
		boolean bo = dao.deleteCompany(4);
		System.out.println("test boolean:"+bo);
	}
	//后台进行企业信息的修改
	@Test
	public void companyBackstageModify(){
		ApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");
		ICompanyDao dao = (ICompanyDao) context.getBean("companyDaoImpl",ICompanyDao.class);
		CompanyBean companyBean = new CompanyBean();
		companyBean.setId(5);
		companyBean.setName("石油能源5");
		companyBean.setAddr("新能源产业基地5");
		companyBean.setContacts("田七5");
		companyBean.setPhone("15469695960");
		boolean bo = dao.companyBackstageModify(companyBean);
		System.out.println("test boolean:"+bo);
	}
	//查询企业是否已存在
	@Test
	public void selectIsExistByCompanyName(){
		ApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");
		ICompanyDao dao = (ICompanyDao) context.getBean("companyDaoImpl",ICompanyDao.class);
		CompanyBean companyBean = dao.selectIsExistByCompanyName("成都蜗牛学院");
		System.out.println("test companyBean:"+companyBean);
	}
}
