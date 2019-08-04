package com.project.service;

import java.util.List;

import com.project.bean.CarportBean;
import com.project.bean.CompanyRentContractBean;
import com.project.bean.ThirdParkContractBean;

public interface IThirdParkContractService {
	/**
	 * 添加第三方租赁合同信息
	 */
	public boolean addThirdRentContract(ThirdParkContractBean bean);
	/**
	 * 续约第三方租赁合同信息
	 */
	public boolean updateThirdRentContract(ThirdParkContractBean bean);
	/**
	 * 解约第三方租赁合同信息
	 */
	public boolean deleteThirdRentContract(int id);
	/**
	 * 查询第三方租赁合同信息
	 */
	public ThirdParkContractBean selectThirdRentContract(int id);
	/**
	 * 查询第三方所有合同信息
	 */
	public List<ThirdParkContractBean> findallThirdRentContract(int index);
	/**
	 * 查询第三方企业合同数量
	 */
	public int findcountThirdParkContract();
	/**
     * 改变合同状态
     */
    public void changeThirdParkContractStatus(ThirdParkContractBean bean);
    /**
     * 通过合同id查询所属车位编号
     */
    public List<CarportBean> findCarPortByThirdParkContractById(ThirdParkContractBean bean);
    /**
     * 通过合同号查车位数量
     */
    public int fingcountCarportThirdPortContractById(int id);
    /**
     * 通过合同id查询对应的复印件
     */
    public String findthirdparkContractCopyById(int id);
    /**
     * 根据合同id查询合同 编号
     */
    public String findthirdnumbyid(int id);
    /**
     * 添加合同复印件
     */
    public boolean savethirdparkcopy(ThirdParkContractBean bean);
    /**
     * 解约时更改车位状态
     */ 
    public boolean changeThirdCarportStatus(int id);
    /**
     * 解约时判断合同租赁情况
     */
    public int selectRambid(int id);
    /**
     * 查看第三方合约有哪些企业租赁车位
     */
    public List<CompanyRentContractBean> findrentCarport(int id);

}
