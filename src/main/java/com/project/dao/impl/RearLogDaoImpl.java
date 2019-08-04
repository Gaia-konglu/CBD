package com.project.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.bean.RearLoginLogBean;
import com.project.bean.RearOperationLogBean;
import com.project.dao.IRearLogDao;

@Repository
public class RearLogDaoImpl implements IRearLogDao{

	@Autowired
	private SqlSessionFactory fa = null;
	
	//记录后台登录日志
	@Override
	public boolean insertRegisterLog(RearLoginLogBean rll) {
		// TODO Auto-generated method stub
		SqlSession session = fa.openSession();
		int row = session.insert("LogMapper.RealLog",rll);
		
		session.close();
		if(row > 0){
			return true;
		}
		
		return false;
	}

	//记录后台操作日志
	@Override
	public boolean insertOperationLog(RearOperationLogBean rol) {
		// TODO Auto-generated method stub
		SqlSession session = fa.openSession();
		int row = session.insert("LogMapper.RealOperation",rol);
		
		session.close();
		if(row > 0){
			return true;
		}
		return false;
	}

	//查看后台登录日志
	@Override
	public List<RearLoginLogBean> queryRegisterLog(int index) {
		// TODO Auto-generated method stub
		SqlSession session = fa.openSession();
		List<RearLoginLogBean> list = session.selectList("LogMapper.findLoginLog",index);
		
		session.close();
		return list;
	}

	//查看后台操作日志
	@Override
	public List<RearOperationLogBean> queryOperationLog(int index) {
		// TODO Auto-generated method stub
		SqlSession session = fa.openSession();
		List<RearOperationLogBean> list = session.selectList("LogMapper.findRealOperation",index);
		
		session.close();
		return list;
	}

	 /*查看后台登录日志的总页数*/
    public int findLoginLogTotalPage(){
    	SqlSession session = fa.openSession();
    	int pages = session.selectOne("LogMapper.findLoginLogTotalPage");
		session.close();
    	return pages;	
		
    }
    
    
    /*查看后台操作日志的总页数*/
    public int findRealOperationTotalPage(){
    	SqlSession session = fa.openSession();
    	int count = session.selectOne("LogMapper.findRealOperationTotalPage");
    	session.close();
		return count;	 	
    }
    
}
