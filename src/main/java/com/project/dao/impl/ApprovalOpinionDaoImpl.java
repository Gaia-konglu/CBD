package com.project.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.bean.PartingSpaceBean;
import com.project.dao.IApprovalOpinionDao;

@Repository
public class ApprovalOpinionDaoImpl implements IApprovalOpinionDao{

	@Autowired
	private SqlSessionFactory fa = null;
	
	//查询需要审批的包租婆添加的所有私人招租车位信息+包租婆的个人信息
	@Override
	public List<PartingSpaceBean> queryParking(int page) {		
		// TODO Auto-generated method stub
		SqlSession session = fa.openSession();
		List<PartingSpaceBean> list = session.selectList("RentInforMapper.findWaitApprove",page);		
		session.close();
		
		return list;
	}

	@Override
	public int queryPersonalInformation() {
		// TODO Auto-generated method stub
		return 0;
	}

	//查询所有包租婆的全部车位信息
	@Override
	public List<PartingSpaceBean> findAll(int page) {
		// TODO Auto-generated method stub
        SqlSession session = fa.openSession();
		
		List<PartingSpaceBean> list = session.selectList("RentInforMapper.findAll",page);
		session.close();
		
		return list;
			
	}

	
	//查询 所有包租婆的全部车位信息的总条数
	  public int findAllTotalPage(){
		  SqlSession session = fa.openSession();
		  int count = session.selectOne("RentInforMapper.findAllTotalPage");
		  
		  session.close();
		return count;
		  
	  }
	  
	
	//审批包租婆添加的车位
	public boolean approval(int id){
		SqlSession session = fa.openSession();
		int row = session.update("RentInforMapper.approve",id);
		
		session.close();
		if(row>0){
			return true;
		}
		return false;
		
	}
	
	
	//查询 审批包租婆添加的车位的总页数
	  public int findWaitApproveTotalPage(){
		  SqlSession session = fa.openSession();
		  int pages = session.selectOne("RentInforMapper.findWaitApproveTotalPage");
		  
		  session.close();
		return pages;
		  
	  }

	  
	//一键审批包租婆添加的车位（一键通过审批）
	  public boolean oneKeyApproval(){
		  SqlSession session = fa.openSession();
		  int row = session.update("RentInforMapper.oneKeyApprove");
		  session.close();
		  
		  if(row > 0){
			  return true;
		  }
		return false;
		  
	  }
	  
}
