/***********************************************************************
 * Module:  ICompanyDao2.java
 * Author:  Administrator
 * Purpose: Defines the Interface ICompanyDao2
 ***********************************************************************/
package com.project.dao;
import java.util.*;

import org.apache.ibatis.annotations.Param;

import com.project.bean.CarportBean;
import com.project.bean.CompanyBean;

public interface ICompanyDao {
   public List<CompanyBean> selectAll();
   public CompanyBean selectById(Integer id);
   public CompanyBean selectByName(java.lang.String name);
   public Integer selectByObj(CompanyBean company);
   public CompanyBean getConpanyUserById(int id);
   public boolean update(CompanyBean cb);
   //查询企业名称
   public CompanyBean findCompanyNameByAdmin(String admin);
   //企业已租赁车位模糊查询
   public List<CarportBean> findCompanyAlreadyRentedFuzzyQuery(@Param("index") int index,@Param("name") String name,@Param("addr") String addr,@Param("p_number") String p_number,@Param("b_number") String b_number,@Param("start_time") String start_time,@Param("end_time") String end_time);
   //企业已租赁车位模糊查询总数量（分页）
   public Integer findCompanyAlreadyRentedFuzzyQueryTotalNum(@Param("name") String name,@Param("addr") String addr,@Param("p_number") String p_number,@Param("b_number") String b_number,@Param("start_time") String start_time,@Param("end_time") String end_time);
   //CBD平台未租赁车位模糊查询
   public List<CarportBean> findCompanyNotRentedFuzzyQuery(@Param("index")int index,@Param("addr")String addr,@Param("p_number")String p_number,@Param("end_time")String end_time);
   //CBD平台未租赁车位模糊查询总数量（分页）
   public Integer findCompanyNotRentedFuzzyQueryTotalNum(@Param("addr")String addr,@Param("p_number")String p_number,@Param("end_time")String end_time);
   //模糊查询企业
   public List<CompanyBean> findCompany(@Param("companyBean") CompanyBean companyBean,@Param("index") int index);
   //查询模糊查询企业总数量（分页）
   public Integer findCompanyTotalNum(@Param("companyBean") CompanyBean companyBean);
   //新增企业
   public boolean addCompany(CompanyBean companyBean);
   //删除企业
   public boolean deleteCompany(int id);
   //后台进行企业信息的修改
   public boolean companyBackstageModify(CompanyBean companyBean);
   //查询企业是否已存在
   //通过id查
   public CompanyBean selectIsExistByCompanyId(Integer id);
   //通过name查
   public CompanyBean selectIsExistByCompanyName(String name);
}