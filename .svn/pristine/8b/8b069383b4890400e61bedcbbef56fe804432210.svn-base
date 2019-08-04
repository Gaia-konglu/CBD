package com.project.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.bean.BackStageBean;
import com.project.dao.IBackDao;

@Repository
public class BackDaoImpl implements IBackDao{

	@Autowired
	private SqlSessionFactory fa = null;
	
	
	@Override
	public List<BackStageBean> selectAll() {
		SqlSession session=fa.openSession();
		List<BackStageBean> list=session.selectList("BackGroundMapper.getAllBack");
		session.close();
		return list;
	}

	@Override
	public BackStageBean selectById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public Integer selectByObj(BackStageBean backstage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	//修改后台管理员信息（登录密码电话号码）
	public boolean update(BackStageBean bsb) {
		// TODO Auto-generated method stub
		
		SqlSession session = fa.openSession();
		int row = session.update("BackGroundMapper.updatePassAndTel",bsb);
				
		session.close();
		
		if(row > 0){
			return true;
		}
		
		return false;	
		
	}

	@Override
	public BackStageBean getBackById(int id) {
		// TODO Auto-generated method stub
		SqlSession session = fa.openSession();
		BackStageBean bsb=session.selectOne("BackGroundMapper.getBackById",id);
		session.close();
		return bsb;
	}

	@Override
	public BackStageBean getBackByAccount(String account) {
		
		SqlSession session = fa.openSession();
		BackStageBean bsb=session.selectOne("BackGroundMapper.getBackByAccount",account);
		session.close();
		return bsb;
		
		
	}

}
