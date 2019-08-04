package com.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.project.bean.PartingSpaceBean;
import com.project.bean.PersonBean;
import com.project.dao.impl.ApprovalOpinionDaoImpl;
import com.project.service.IApprovalOpinionService;

@Service
public class ApprovalOpinionServiceImpl implements IApprovalOpinionService{

	@Autowired
	private ApprovalOpinionDaoImpl dao;

	//查询需要审批的包租婆添加的所有私人招租车位信息+包租婆的个人信息
	@Override
	public List<PartingSpaceBean> queryParking(int page) {
		// TODO Auto-generated method stub
		
		 int index = (page - 1) * 5;
		 
		List<PartingSpaceBean> list = dao.queryParking(index);
		return list;
	}

	@Override
	public PersonBean queryPersonalInformation() {
		// TODO Auto-generated method stub
		return null;
	}

	//查询所有包租婆的全部车位信息
	@Override
	public List<PartingSpaceBean> findAll(int page) {
		// TODO Auto-generated method stub
		
		 int index = (page - 1) * 5;
		 
		List<PartingSpaceBean> list = dao.findAll(index);
		
		return list;
	}
	
	
	//查询 所有包租婆的全部车位信息的总页数
	  public int findAllTotalPage(){
		  int pages = 0;
		  
		  int count = dao.findAllTotalPage();
		  
		  if(count % 5 ==0){
				pages = count / 5;
			}else{
				pages = (count / 5) + 1;
			}
		  
		return pages;
		  
	  }
	
	//审批包租婆添加的车位
	public boolean approval(int id){
		boolean row = dao.approval(id);
		
		return row;		
	}
	
	
	//查询 审批包租婆添加的车位的总页数
	  public int findWaitApproveTotalPage(){
		  int pages = 0;
		  
		  int count = dao.findWaitApproveTotalPage();		  
		  if(count % 5 ==0){
				pages = count / 5;
			}else{
				pages = (count / 5) + 1;
			}
		  
		return pages;
		  
	  }
	
	  
	//一键审批包租婆添加的车位（一键通过审批）
	  public boolean oneKeyApproval(){
		  boolean bow = dao.oneKeyApproval();
		  
		return bow;
		  
	  }
	  
}
