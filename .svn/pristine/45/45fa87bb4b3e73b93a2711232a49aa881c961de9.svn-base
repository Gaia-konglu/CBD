package com.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.bean.RearLoginLogBean;
import com.project.bean.RearOperationLogBean;
import com.project.dao.impl.RearLogDaoImpl;
import com.project.service.IRearLogService;

@Service
public class RearLogServiceImpl implements IRearLogService{

	@Autowired
	private RearLogDaoImpl dao;
	
	//记录后台登录日志
	@Override
	public boolean insertRegisterLog(RearLoginLogBean rll) {
		// TODO Auto-generated method stub
		boolean row = dao.insertRegisterLog(rll);
	
		return row;
	}

	//记录后台操作日志
	@Override
	public boolean insertOperationLog(RearOperationLogBean rol) {
		// TODO Auto-generated method stub
		boolean row = dao.insertOperationLog(rol);
		
		return row;
	}

	//查看后台登录日志
	@Override
	public List<RearLoginLogBean> queryRegisterLog(int page) {
		// TODO Auto-generated method stub
	//	 page = 1;
		
		 int index = (page - 1) * 3;
		List<RearLoginLogBean> list = dao.queryRegisterLog(index);
		
		return list;
	}

	//查看后台操作日志
	@Override
	public List<RearOperationLogBean> queryOperationLog(int page) {
		// TODO Auto-generated method stub			
	    int index = 1;
		
		index = (page - 1) * 3;
		List<RearOperationLogBean> list = dao.queryOperationLog(index);
		
		return list;
	}
	
	
	 /*查看后台登录日志的总页数*/
    public int findLoginLogTotalPage(){
    	int pages = 0;
    	
    	int count = dao.findLoginLogTotalPage();
    	
    	if(count % 3 ==0){
			pages = count / 3;
		}else{
			pages = (count / 3) + 1;
		}
    	
		return pages;   	
    }
    
    /*查看后台操作日志的总页数*/
    public int findRealOperationTotalPage(){
    	int pages = 0;
    	
    	int count = dao.findRealOperationTotalPage();
		
    	if(count % 3 ==0){
			pages = count / 3;
		}else{
			pages = (count / 3) + 1;
		}
    	
		return pages;   
    }

}
