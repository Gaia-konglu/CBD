/***********************************************************************
 * Module:  IApprovalOpinionService.java
 * Author:  Administrator
 * Purpose: Defines the Interface IApprovalOpinionService
 ***********************************************************************/
package com.project.service;
import java.util.*;

import com.project.bean.PartingSpaceBean;
import com.project.bean.PersonBean;

/** @pdOid b3a8f1b3-22f2-4a55-8997-915d3e1d36c8 */
public interface IApprovalOpinionService {
   /** @param flag
    * @pdOid 26b50c99-1d8a-4fb6-9e2d-8e8c27cabbd1
    * 查询包租婆添加的车位 */
	public List<PartingSpaceBean> queryParking(int page);
   /** @pdOid 0182a7f4-de20-4cea-884c-cdd3cf6d8bb2 
    * 查询包租婆的个人信息*/
	public PersonBean queryPersonalInformation();
	
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