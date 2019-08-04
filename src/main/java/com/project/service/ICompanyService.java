/***********************************************************************
 * Module:  ICompanyService.java
 * Author:  Administrator
 * Purpose: Defines the Interface ICompanyService
 ***********************************************************************/
package com.project.service;
import java.util.*;

import org.apache.ibatis.annotations.Param;

import com.project.bean.CarportBean;
import com.project.bean.CompanyBean;
public interface ICompanyService {
   public List<CompanyBean> selectAll();
   public CompanyBean selectById(Integer id);
   public CompanyBean selectByName(java.lang.String name);
   public Integer selectByObj(CompanyBean company);
   public CompanyBean getConpanyUserById(int id);
   public boolean ChangeInfo(CompanyBean cb,int id);
   //查询企业名称
   public CompanyBean findCompanyNameByAdmin(String admin);
   //企业已租赁车位模糊查询
   public List<CarportBean> findCompanyAlreadyRentedFuzzyQuery(int index,String name,String addr,String p_number,String b_number,String start_time,String end_time);
   //企业已租赁车位模糊查询总数量（分页）
   public Integer findCompanyAlreadyRentedFuzzyQueryTotalNum(String name,String addr,String p_number,String b_number,String start_time,String end_time);
   //CBD平台未租赁车位模糊查询
   public List<CarportBean> findCompanyNotRentedFuzzyQuery(int index,String addr,String p_number,String end_time);
   //CBD平台未租赁车位模糊查询总数量（分页）
   public Integer findCompanyNotRentedFuzzyQueryTotalNum(String addr,String p_number,String end_time);
   //模糊查询企业
   public List<CompanyBean> findCompany(CompanyBean companyBean,@Param("index") int index);
   //查询模糊查询企业总数量（分页）
   public Integer findCompanyTotalNum(CompanyBean companyBean);
   //新增企业
   public Map<String,Object> addCompany(CompanyBean companyBean);
   //删除企业
   public boolean deleteCompany(int id);
   //后台进行企业信息的修改
   public Map<String,Object> companyBackstageModify(CompanyBean companyBean);
   
   CompanyBean findByName(String admin);
}