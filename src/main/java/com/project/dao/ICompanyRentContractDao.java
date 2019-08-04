package com.project.dao;

import java.util.List;

import com.project.bean.CarportBean;
import com.project.bean.CompanyRentContractBean;

public interface ICompanyRentContractDao {
	/**
	 * 添加企业租赁合同信息
	 */
	public boolean addCompanyRentContract(CompanyRentContractBean bean);
	/**
	 * 续约企业租赁合同信息
	 */
	public boolean updateCompanyRentContract(CompanyRentContractBean bean);
	/**
	 * 解约企业租赁合同信息
	 */
	public boolean deleteCompanyRentContract(int id);
	/**
	 * 查询企业租赁合同信息
	 */
	public CompanyRentContractBean selectCompanyRentContract(int id);
	/**
	 * 查询所有企业租赁合同
	 */
	public List<CompanyRentContractBean> findallCompanyRentContract(int page);
	/**
	 * 查询所有企业合同数量
	 */
	public int findCountCompanyContract();
	/**
	 * 改变合同状态
	 */
	public void changeCompanyContract(CompanyRentContractBean bean);
	/**
     * 通过合同id查询所属车位编号
     */
    public List<CarportBean> findCarPortByCompanyContract(CompanyRentContractBean bean);
    /**
     * 通过合同号查车位数量
     */
    public int fingcountCarportCompanyRentContractById(int id);
    /**
     * 通过合同id查询对应的复印件
     */
    public String findCompanyContractCopyById(int id);
    /**
     * 根据地址查询车位编号
     */
    public List<CarportBean> findcarnumByaddressCompany(String address);
    /**
     * 查询所有的车位地址
     */
    public List<CarportBean> findalladdresscompany();
    /**
     * 企业租赁合同添加车位
     */
     public boolean insertCarportByCompanyRentContract(CompanyRentContractBean bean);
     /**
 	 * 查询新加入的车位信息
 	 */
     public List<CarportBean> findnewinsertcarportCompanycontract(String num);

     /**
      * 根据合同id查询合同编号
      */
     public String findCompanycontractNumBycompanyId(int id);
     /**
      * 根据合同编号查询合同id
      */
     public int findcompanyidbycompanynum(String num);
     /**
      * 将合同复印件存入
      */
     public boolean saveUploadfile(CompanyRentContractBean bean);
     /**
      * 解约更改车位表状态
      */
     public boolean changeSstatusTer(int id);
     /**
      * 状态筛选后的所有合同信息
      */
     public List<CompanyRentContractBean> findallresultcontract(CompanyRentContractBean bean);
     /**
      * 根据状态筛选后的合同信息数量
      */
     public int findresultcountBystatus(String status);
     /**
      * 根据企业名称查询获得的合同
      */
     public List<CompanyRentContractBean> findallresultcontractByName(CompanyRentContractBean bean);
     /**
      * 根据企业名称查询获得的合同的数量
      */
     public int findcountallresultcontractByName(String name);
     
}
