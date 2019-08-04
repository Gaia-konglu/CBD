package com.project.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.bean.BackStageBean;
import com.project.bean.PagesBean;
import com.project.dao.ISuperBakDao;
@Repository
public class SuperBakDaoImpl implements ISuperBakDao {
	@Autowired
	private SqlSessionFactory fa=null;
	@Override
	public boolean update(BackStageBean bsb) {
		// TODO Auto-generated method stub
		SqlSession session=fa.openSession();
		int row=session.update("SuperMapper.changeBackInfo",bsb);
		session.close();
		if(row>0){return true;}
		return false;
	}

	@Override
	public boolean add(BackStageBean bsb) {
		// TODO Auto-generated method stub
		SqlSession session=fa.openSession();
		int row=session.insert("SuperMapper.addback",bsb);
		session.close();
		if(row>0){return true;}
		
		return false;
	}

	@Override
	public List<BackStageBean> findAllBackStage(int pageNow,int pageSize) {
		Map<String, Integer> map=new HashMap<String, Integer>();
		map.put("0", pageNow);
		map.put("1", pageSize);
		
		SqlSession session=fa.openSession();
		List<BackStageBean>  bsblist=session.selectList("SuperMapper.selectAllBackStage",map);
		session.close();
		
		return bsblist;
	}


	public int countPages() {
		SqlSession session=fa.openSession();
		int tatol=session.selectOne("SuperMapper.countPages");
		session.close();
		return tatol;
	}

	@Override
	public BackStageBean findByid(int id) {
		SqlSession session=fa.openSession();
		BackStageBean bsb=session.selectOne("SuperMapper.findByid",id);
		session.close();
		return bsb;
	}

	public List<BackStageBean> findByCondition(BackStageBean bsb, PagesBean pb) {
		
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("0", pb.getStartPos());
		map.put("1", pb.getPageSize());
		map.put("bsb", bsb);
		
		SqlSession session=fa.openSession();
		List<BackStageBean>  bsblist=session.selectList("SuperMapper.selectByCondition",map);
		session.close();
		
		return bsblist;
		
		
	}

	public boolean deleteById(Integer id) {
		SqlSession session=fa.openSession();
		
		 int line=session.delete("SuperMapper.deleteById",id);
		
		 session.close();
		 if(line>0){
			 return true;
		 }
		
		return false;
	}

}
