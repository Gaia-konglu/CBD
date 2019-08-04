package com.project.dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.project.bean.CarportBean;
import com.project.bean.CompanyRentContractBean;
import com.project.bean.ThirdParkContractBean;
import com.project.dao.IThirdParkContractDao;
@Repository
public class ThirdParkContractDaoImpl implements IThirdParkContractDao {
	@Autowired
	private SqlSessionFactory fa=null;
	
	
	public void setFa(SqlSessionFactory fa) {
		this.fa = fa;
	}
    /**
     * 添加第三方合同
     */
	@Override
	public boolean addThirdRentContract(ThirdParkContractBean bean) {
		SqlSession session=fa.openSession();
		int row=session.update("thirdparkContractmapper.addThirdParkContract",bean);
		session.close();
		if(row>0){
			return true;
		}
		return false;
	}
    /**
     * 续约第三方合同
     */
	@Override
	public boolean updateThirdRentContract(ThirdParkContractBean bean) {
		SqlSession session=fa.openSession();
		int row=session.update("thirdparkContractmapper.updateThirdParkContractById",bean);
		session.close();
		if(row>0){
			return true;
		}
		return false;
	}
	/**
	 * 解约第三方合同
	 */

	@Override
	public boolean deleteThirdRentContract(int id) {
		SqlSession session=fa.openSession();
		int row=session.update("thirdparkContractmapper.deleteThirdParkContractById",id);
		session.close();
		if(row>0){
			return true;
		}
		return false;
	}
	/**
	 * 查询第三方合约
	 */

	@Override
	public ThirdParkContractBean selectThirdRentContract(int id) {
		SqlSession session=fa.openSession();
		ThirdParkContractBean bean=session.selectOne("thirdparkContractmapper.findThirdParkContractById",id);
		session.close();
		return bean;
		
	}
	/**
	 * 查询所有第三方合同信息
	 */
	@Override
	public List<ThirdParkContractBean> findallThirdRentContract(int index) {
		SqlSession session=fa.openSession();
		List<ThirdParkContractBean> list=session.selectList("thirdparkContractmapper.findallThirdParkContract",index);
		session.close();
		return list;
	}
	/**
	 * 查询第三方企业合同所有数量
	 */
	@Override
	public int findcountThirdParkContract() {
		SqlSession session=fa.openSession();
		int num=session.selectOne("thirdparkContractmapper.findcountThirdParkContract");
		session.close();
		return num;
	}
	/**
	 * 更改合同状态
	 */
	@Override
	public void changeThirdParkContractStatus(ThirdParkContractBean bean) {
		SqlSession session=fa.openSession();
		session.update("thirdparkContractmapper.updateThirdParkContractStatus",bean);
		session.close();
	}
	/**
	 * 根据合同号查询车位编号
	 */
	@Override
	public List<CarportBean> findCarPortByThirdParkContractById(
			ThirdParkContractBean bean) {
		SqlSession session=fa.openSession();
		List<CarportBean> list=session.selectList("thirdparkContractmapper.findCarPortByThirdPrakContractId",bean);
		session.close();
		return list;
	}
	/**
	 * 根据合同id查询车位数量
	 */
	@Override
	public int fingcountCarportThirdPortContractById(int id) {
		SqlSession session=fa.openSession();
		int num=session.selectOne("thirdparkContractmapper.findCountCarportByThirdPartContractId",id);
		session.close();
		return num;
	}
	/**
	 * 根据合同id查询复印件
	 */
	@Override
	public String findthirdparkContractCopyById(int id) {
		SqlSession session=fa.openSession();
		String num=session.selectOne("thirdparkContractmapper.findthirdparkContractCopyById",id);
		session.close();
		return num;
	}
	/**
	 * 根据合同id查询合同编号
	 */
	@Override
	public String findthirdnumbyid(int id) {
		SqlSession session=fa.openSession();
		String num=session.selectOne("thirdparkContractmapper.findthirdcontractnumbyids",id);
		session.close();
		return num;
	}
	/**
	 * 添加合同复印件
	 */
	@Override
	public boolean savethirdparkcopy(ThirdParkContractBean bean) {
		SqlSession session=fa.openSession();
		int num=session.update("thirdparkContractmapper.saveupthirdloadfile",bean);
		session.close();
		if(num>0){
			return true;
		}
		return false;
	}
	/**
	 * 解约时更改车位状态
	 */
	@Override
	public boolean changeThirdCarportStatus(int id) {
		SqlSession session=fa.openSession();
		int num=session.update("thirdparkContractmapper.changeThirdcarportStatus",id);
		session.close();
		if(num>0){
			return true;
		}
		return false;
	}
	/**
	 * 解约时判断合同租赁情况
	 */
	@Override
	public int selectRambid(int id) {
		SqlSession session=fa.openSession();
		int num=session.selectOne("thirdparkContractmapper.findIfthirdContractById",id);
		session.close();
		return num;
	}
	 /**
     * 查看第三方合约有哪些企业租赁车位
     */
	@Override
	public List<CompanyRentContractBean> findrentCarport(int id) {
		SqlSession session=fa.openSession();
		List<CompanyRentContractBean> list=session.selectList("thirdparkContractmapper.findCarportCompanyRentByIdthird",id);
		session.close();
		return list;
	}
	

}
