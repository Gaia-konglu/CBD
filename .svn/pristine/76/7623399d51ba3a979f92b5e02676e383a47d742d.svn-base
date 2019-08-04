/***********************************************************************
 * Module:  IApprovalOpinionDao.java
 * Author:  Administrator
 * Purpose: Defines the Interface IApprovalOpinionDao
 ***********************************************************************/
package com.project.dao;
import java.util.*;

import com.project.bean.PartingSpaceBean;

/** @pdOid 2547bd1e-fae8-47fe-b4fc-4f70142ebd1c */
public interface IApprovalOpinionDao {
   /** @param flag
    * @pdOid 6f7b40dd-9082-471d-a38c-6d94eafb97b9 
    * 查询包租婆添加的车位*/
   public List<PartingSpaceBean> queryParking(int page);
   /** @pdOid 927b6440-5aa6-49d3-95ec-095a569797ee 
    * 查询包租婆的个人信息*/
   public int queryPersonalInformation();
   
   //查询所有包租婆的全部车位信息
  public List<PartingSpaceBean> findAll(int page);
  
  //查询 所有包租婆的全部车位信息的总条数
  public int findAllTotalPage();

  //审批包租婆添加的车位
  public boolean approval(int id);
  
  //查询 审批包租婆添加的车位的总页数
  public int findWaitApproveTotalPage();
  
 //一键审批包租婆添加的车位（一键通过审批）
  public boolean oneKeyApproval();
  
}