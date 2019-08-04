package com.project.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.project.bean.CarportBean;
import com.project.bean.CompanyRentContractBean;
import com.project.dao.ICompanyRentContractDao;
import com.project.service.ICompanyRentContractService;

@Service
public class CompanyRentContractServiceImpl implements ICompanyRentContractService {

	@Autowired
	@Qualifier("companyRentContractDaoImpl")
	private ICompanyRentContractDao dao=null;
	
	/**
	 * 添加企业租赁合同
	 */
	@Override
	public boolean addCompanyRentContract(CompanyRentContractBean bean) {
		if(dao.addCompanyRentContract(bean)){
			return true;
		}
		return false;
	}
	/**
	 * 续约企业租赁合同
	 */

	@Override
	public boolean updateCompanyRentContract(CompanyRentContractBean bean) {
		if(dao.updateCompanyRentContract(bean)){
			return true;
		}
		return false;
	}
	/**
	 * 解约企业租赁合同
	 */

	@Override
	public boolean deleteCompanyRentContract(int id) {
		if(dao.deleteCompanyRentContract(id)){
			return true;
		}
		return false;
	}
    /**
     * 查询企业租赁合同信息
     */
	@Override
	public CompanyRentContractBean selectCompanyRentContract(int id) {
		CompanyRentContractBean bean=dao.selectCompanyRentContract(id);
		return bean;
	}
	/**
	 * 查询所有企业租赁合同
	 */
	
	@Override
	public List<CompanyRentContractBean> findallCompanyRentContract(int page) {
		List<CompanyRentContractBean> list=new ArrayList<CompanyRentContractBean>();
		int index=(page-1)*7;
		list=dao.findallCompanyRentContract(index);
		return list;
	}
	
	/**
	 * 查询所有企业合同总数
	 */
	@Override
	public int findCountCompanyContract() {
		
		int a=dao.findCountCompanyContract();
		
		return a;
	}
	/**
	 * 改变合同状态
	 */
	@Override
	public void changeCompanyContract(CompanyRentContractBean bean) {
		dao.changeCompanyContract(bean);
		
	}
	
	/**
	 * 根据企业合同号查询车位
	 */

	@Override
	public List<CarportBean> findCarPortByCompanyContract(
			CompanyRentContractBean bean) {
		List<CarportBean> list=new ArrayList<CarportBean>();
				list=dao.findCarPortByCompanyContract(bean);
		return list;
	}
	/**
	 *根据合同id查询车位数量
	 */
	@Override
	public int fingcountCarportCompanyRentContractById(int id) {
		int row=dao.fingcountCarportCompanyRentContractById(id);
	    int totalPage;
	    if(row%7==0){
			totalPage=row/7;
		}
		else{
			totalPage=(row/7+1);
		}
		return totalPage;
	}
	/**
	 * 根据合同id查询对应的复印件
	 */
	@Override
	public String findCompanyContractCopyById(int id) {
		String result=dao.findCompanyContractCopyById(id);
		return result;
	}
	/**
	 * 根据地址查询车位编号
	 */
	@Override
	public List<CarportBean> findcarnumByaddressCompany(String address) {
		List<CarportBean> list=dao.findcarnumByaddressCompany(address);
		return list;
	}
	/**
	 * 查询所有的车位地址
	 */
	@Override
	public List<CarportBean> findalladdresscompany() {
		List<CarportBean> list=dao.findalladdresscompany();
		return list;
	}
	/**
	 * 企业合同中添加车位
	 */
	@Override
	public boolean insertCarportByCompanyRentContract(
			CompanyRentContractBean bean) {
		if(dao.insertCarportByCompanyRentContract(bean)){
			return true;
		}
		return false;
	}
	/**
	 * 查询新插入的车位信息
	 */
	@Override
	public List<CarportBean> findnewinsertcarportCompanycontract(String num) {
		List<CarportBean> list=dao.findnewinsertcarportCompanycontract(num);
		return list;
	}
	@Override
	public String findCompanycontractNumByCompanyId(int id) {
		String num=dao.findCompanycontractNumBycompanyId(id);
		return num;
	}
	/*
	 * 根据合同编号查询合同id
	 */
	@Override
	public int findcompanyidbycompanynums(String num) {
		int id=dao.findcompanyidbycompanynum(num);
		return id;
	}
	/**
	 * 插入企业合同复印件
	 */
	
	@Override
	public boolean saveUploadfile(CompanyRentContractBean bean) {
		if(dao.saveUploadfile(bean)){
			return true;
		}
		return false;
	}
	/**
	 * 解约后更改车位状态
	 */
	@Override
	public boolean changeSstatusTer(int id) {
		if(dao.changeSstatusTer(id)){
			return true;
		}
		return false;
	}
	/**
	 * 状态筛选后的所有合同
	 */
	@Override
	public List<CompanyRentContractBean> findallresultcontract(
			CompanyRentContractBean bean) {
		List<CompanyRentContractBean> list=dao.findallresultcontract(bean);
		return list;
	}
	/**
	 * 筛选状态后的合同数量
	 */
	@Override
	public int findresultcountBystatus(String status) {
		int n=dao.findresultcountBystatus(status);
		return n;
	}
	/**
	 * 名称查询结果
	 */
	@Override
	public List<CompanyRentContractBean> findallresultcontractByName(
			CompanyRentContractBean bean) {
		List<CompanyRentContractBean> list=dao.findallresultcontractByName(bean);
		return list;
	}
	/**
	 * 名称查询数量
	 */
	@Override
	public int findcountallresultcontractByName(String name) {
		int n=dao.findcountallresultcontractByName(name);
		return n;
	}
	
	
	
	

	

}

