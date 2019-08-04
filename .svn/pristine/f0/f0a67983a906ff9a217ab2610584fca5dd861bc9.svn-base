package com.project.dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.bean.CarportBean;
import com.project.bean.CompanyRentContractBean;
import com.project.dao.ICompanyRentContractDao;

@Repository
public class CompanyRentContractDaoImpl implements ICompanyRentContractDao {
	
	@Autowired
	private SqlSessionFactory fa=null;
	
	
	public void setFa(SqlSessionFactory fa) {
		this.fa = fa;
	}
    /**
     * 添加企业租赁合同
     */
	@Override
	public boolean addCompanyRentContract(CompanyRentContractBean bean) {
		SqlSession session=fa.openSession();
		int row=session.update("companyContractmapper.addCompanyRentContract",bean);
		session.close();
		if(row>0){
			return true;
		}
		return false;
	}
    /**
     * 续约企业租赁合同
     */
	@Override
	public boolean updateCompanyRentContract(CompanyRentContractBean bean) {
		SqlSession session=fa.openSession();
		int row=session.update("companyContractmapper.updateCompanyRentContractById",bean);
		session.close();
		if(row>0){
			return true;
		}
		return false;
	}
	/**
	 * 解约企业租赁合同
	 */

	@Override
	public boolean deleteCompanyRentContract(int id) {
		SqlSession session=fa.openSession();
		int row=session.update("companyContractmapper.deleteCompanyRentContractById",id);
		session.close();
		if(row>0){
			return true;
		}
		return false;
	}

	/**
	 * 查询企业用户合同信息
	 */
	@Override
	public CompanyRentContractBean selectCompanyRentContract(int id) {
		SqlSession session=fa.openSession();
		CompanyRentContractBean bean=session.selectOne("companyContractmapper.findCompanyRentContractById",id);
		session.close();
		return bean;
	}
	/**
	 * 查询所有企业租赁合同
	 */
	@Override
	public List<CompanyRentContractBean> findallCompanyRentContract(int page) {
		SqlSession session=fa.openSession();
		List<CompanyRentContractBean> list=new ArrayList<CompanyRentContractBean>();
	    list=session.selectList("companyContractmapper.findallCompanyRentContract",page);
	    session.close();
	    return list;
		
	}
	
	/**
	 * 查询所有企业合同数量
	 */
	@Override
	public int findCountCompanyContract() {
		SqlSession session=fa.openSession();
		int row=session.selectOne("companyContractmapper.findCountCompanyRentContract");
		session.close();
		return row;
	}
	
	/**
	 * 改变合同状态
	 */
	@Override
	public void changeCompanyContract(CompanyRentContractBean bean) {
		SqlSession session=fa.openSession();
		session.selectOne("companyContractmapper.updateCompanyRentContractStatus",bean);
		session.close();
		
	}
	
	/**
	 * 根据合同id查询车位号
	 */
	@Override
	public List<CarportBean> findCarPortByCompanyContract(
			CompanyRentContractBean bean) {
		SqlSession session=fa.openSession();
		List<CarportBean> list=new ArrayList<CarportBean>();
		list=session.selectList("companyContractmapper.findCarPortByCompanyRentContractId",bean);
		session.close();
		return list;
	}
	/**
	 * 根据合同id查询车位数量
	 */
	@Override
	public int fingcountCarportCompanyRentContractById(int id) {
		SqlSession session=fa.openSession();
		int row=session.selectOne("companyContractmapper.findCountCarportByContractId",id);
		session.close();
		return row;
	}
	/**
     * 通过合同id查询对应的复印件
     */
	@Override
	public String findCompanyContractCopyById(int id) {
		SqlSession session=fa.openSession();
		String result=session.selectOne("companyContractmapper.findContractCopyById",id);
		session.close();
		return result;
	}
	/**
	 * 根据地址查询车位编号
	 */
	@Override
	public List<CarportBean> findcarnumByaddressCompany(String address) {
		SqlSession session=fa.openSession();
		List<CarportBean> list=session.selectList("companyContractmapper.findcarnumbyaddresscontract",address);
		session.close();
		return list;
	}
	/**
	 * 查询所有的车位地址
	 */
	@Override
	public List<CarportBean> findalladdresscompany() {
		SqlSession session=fa.openSession();
		List<CarportBean> list=session.selectList("companyContractmapper.findalladdresscompany");
		session.close();
		return list;
	}
	/**
	 * 企业合同中添加车位
	 */
	@Override
	public boolean insertCarportByCompanyRentContract(
			CompanyRentContractBean bean) {
		SqlSession session=fa.openSession();
		int row=session.update("companyContractmapper.insertcompanycontractid",bean);
		session.close();
		if(row>0){
			return true;
		}
		return false;
	}
	/**
	 * 查询新加入的车位信息
	 */
	@Override
	public List<CarportBean> findnewinsertcarportCompanycontract(String num) {
		SqlSession session=fa.openSession();
		List<CarportBean> list=session.selectList("companyContractmapper.findnewinsertcarport",num);
		session.close();
		return list;
	}
	
	@Override
	public String findCompanycontractNumBycompanyId(int id) {
		SqlSession session=fa.openSession();
		String num=session.selectOne("companyContractmapper.findnumberByCompanyContractID",id);
		session.close();
		return num;
	}
	/**
	 * 根据合同编号查询id
	 */
	@Override
	public int findcompanyidbycompanynum(String num) {
		SqlSession session=fa.openSession();
		int row=session.selectOne("companyContractmapper.findcompanyidbycomnum",num);
		session.close();
		return row;
	}
	/**
	 * 存入合同复印件
	 */
	@Override
	public boolean saveUploadfile(CompanyRentContractBean bean) {
		SqlSession session=fa.openSession();
		int row=session.update("companyContractmapper.saveuploadfile",bean);
		session.close();
		if(row>0){
			return true;
		}
		return false;
	}
	/**
	 * 解约后更改车位状态
	 */
	@Override
	public boolean changeSstatusTer(int id) {
		SqlSession session=fa.openSession();
		int row=session.update("companyContractmapper.changecarportStatus",id);
		session.close();
		if(row>0){
			return true;
		}
		return false;
	}
	/**
	 * 筛选状态后的所有合同信息
	 */
	@Override
	public List<CompanyRentContractBean> findallresultcontract(
			CompanyRentContractBean bean) {
		SqlSession session=fa.openSession();
		List<CompanyRentContractBean> list=session.selectList("companyContractmapper.findallresultCompanyRentContract",bean);
		session.close();
		return list;
	}
	/**
	 * 更具状态筛选后的合同数量
	 */
	@Override
	public int findresultcountBystatus(String status) {
		SqlSession session=fa.openSession();
		int n=session.selectOne("companyContractmapper.findallresultcountCompanyRentContract",status);
		session.close();
		return n;
	}
	/**
	 * 更具企业名称查询获得的合同
	 */
	@Override
	public List<CompanyRentContractBean> findallresultcontractByName(
			CompanyRentContractBean bean) {
		SqlSession session=fa.openSession();
		List<CompanyRentContractBean> list=session.selectList("companyContractmapper.findallresultCompanyRentContractByname",bean);
		session.close();
		return list;
	}
	/**
	 * 根据合同名称查询获得的数量
	 */
	@Override
	public int findcountallresultcontractByName(String name) {
		SqlSession session=fa.openSession();
		int n=session.selectOne("companyContractmapper.findallresultcountCompanyRentContractByname",name);
		session.close();
		return n;
	}
	
	
	
	

}
