package com.project.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.bean.TimeBean;
import com.project.dao.timedao;
@Repository
public class timedaoImpl implements timedao{
	@Autowired
	private SqlSessionFactory fa=null;
	
	@Override
	public void inserttime(Map<String, Object> map) {
		// TODO Auto-generated method stub
		SqlSession session=fa.openSession();
		int row=session.insert("TimeMapper.addtime",map);
		System.out.println(row);
		session.close();
	}

	@Override
	public List<TimeBean> selectAll() {
		// TODO Auto-generated method stub
		SqlSession session=fa.openSession();
		List<TimeBean> list=session.selectList("TimeMapper.showtime");
		session.close();
		return list;
	}

}
