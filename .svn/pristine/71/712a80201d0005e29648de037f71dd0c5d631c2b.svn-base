package com.project.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.project.bean.CarportBean;
import com.project.bean.CompanyRentContractBean;
import com.project.bean.ThirdParkContractBean;
import com.project.dao.ICompanyRentContractDao;
import com.project.dao.IThirdParkContractDao;
import com.project.dao.impl.ThirdParkContractDaoImpl;
import com.project.service.IThirdParkContractService;
@Service
public class ThirdParkContractServiceImpl implements IThirdParkContractService {

	@Autowired
	@Qualifier("thirdParkContractDaoImpl")
	private ThirdParkContractDaoImpl dao=null;
    /**
     * 添加第三方合同
     */
	@Override
	public boolean addThirdRentContract(ThirdParkContractBean bean) {
		if(dao.addThirdRentContract(bean)){
			return true;
		}
		return false;
	}
	/**
	 * 续约第三方合同
	 */

	@Override
	public boolean updateThirdRentContract(ThirdParkContractBean bean) {
		if(dao.updateThirdRentContract(bean)){
			return true;
		}
		return false;
	}
	/**
	 * 解约第三方合同
	 */

	@Override
	public boolean deleteThirdRentContract(int id) {
		if(dao.deleteThirdRentContract(id)){
			return true;
		}
		return false;
	}
    /**
     * 查询第三方合同
     */
	@Override
	public ThirdParkContractBean selectThirdRentContract(int id) {
		ThirdParkContractBean bean=dao.selectThirdRentContract(id);
		return bean;
	}
	/**
	 * 查询所有第三方合同
	 */
	@Override
	public List<ThirdParkContractBean> findallThirdRentContract(int index) {
		int indexs=(index-1)*7;
		List<ThirdParkContractBean> list=dao.findallThirdRentContract(indexs);
		return list;
	}
	/**
	 * 查询第三方合同总页数
	 */
	@Override
	public int findcountThirdParkContract() {
		int totalPage=0;
		int a=dao.findcountThirdParkContract();
		if(a%7==0){
			totalPage=a/7;
		}
		else{
			totalPage=(a/7+1);
		}
		return totalPage;
	}
	/**
	 * 更改合同状态
	 */
	@Override
	public void changeThirdParkContractStatus(ThirdParkContractBean bean) {
		dao.updateThirdRentContract(bean);
		
	}
	/**
	 * 查询车位编号
	 */
	@Override
	public List<CarportBean> findCarPortByThirdParkContractById(
			ThirdParkContractBean bean) {
		List<CarportBean> list=dao.findCarPortByThirdParkContractById(bean);
		return list;
	}
	/**
	 * 根据合同id查询车位数量
	 */
	@Override
	public int fingcountCarportThirdPortContractById(int id) {
		int row=dao.fingcountCarportThirdPortContractById(id);
		int totalPage;
	    if(row%3==0){
			totalPage=row/3;
		}
		else{
			totalPage=(row/3+1);
		}
		return totalPage;
	}
	/**
	 * 根据合同id查询复印件
	 */
	@Override
	public String findthirdparkContractCopyById(int id) {
		String re=dao.findthirdparkContractCopyById(id);
		return re;
	}
	/**
	 * 根据合同id查询合同编号
	 */
	@Override
	public String findthirdnumbyid(int id) {
		String num=dao.findthirdnumbyid(id);
		return num;
	}
	/**
	 * 添加复印件
	 */
	@Override
	public boolean savethirdparkcopy(ThirdParkContractBean bean) {
		if(dao.savethirdparkcopy(bean)){
			return true;
		}
		return false;
	}
	/**
	 * 解约时更改车位状态
	 */
	@Override
	public boolean changeThirdCarportStatus(int id) {
		if(dao.changeThirdCarportStatus(id)){
			return true;
		}
		return false;
	}
	/**
	 * 解约时判断合同租赁情况
	 */
	@Override
	public int selectRambid(int id) {
		int num=dao.selectRambid(id);
		return num;
	}
	/**
     * 查看第三方合约有哪些企业租赁车位
     */
	@Override
	public List<CompanyRentContractBean> findrentCarport(int id) {
		List<CompanyRentContractBean> list=dao.findrentCarport(id);
		return list;
	}

}
