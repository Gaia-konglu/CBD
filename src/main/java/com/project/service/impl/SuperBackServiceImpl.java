package com.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.bean.BackStageBean;
import com.project.bean.PagesBean;
import com.project.dao.IBackDao;
import com.project.dao.ISuperBakDao;
import com.project.dao.impl.BackDaoImpl;
import com.project.dao.impl.SuperBakDaoImpl;
import com.project.service.IBackService;
import com.project.service.ISuperBackService;
@Service
public class SuperBackServiceImpl implements ISuperBackService{
	@Autowired
	private SuperBakDaoImpl dao;
	
	@Autowired
	private BackDaoImpl dao2;
	@Override
	public boolean addBack(BackStageBean bsb) {
		// TODO Auto-generated method stub
		return dao.add(bsb);
	}

	

	@Override
	public List<BackStageBean> findAllBackStage(PagesBean page) {
		List<BackStageBean> list=dao.findAllBackStage(page.getStartPos(),page.getPageSize());
		return list;
	}

	@Override
	public int coutPages() {
		int tatolCount=dao.countPages();
		return tatolCount;
	}

	@Override
	public BackStageBean findBackbyId(Integer id) {
		BackStageBean bsb=	dao.findByid(id);
		return bsb;
	}

	@Override
	public boolean ChangeBackInfo(BackStageBean bsb) {
		 
		if(dao.update(bsb)){
			return true;
			
		}
    	return false;
	}



	@Override
	public boolean ChangeBackInfo(BackStageBean nbsb, int id) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public List<BackStageBean> findAllByCondition(BackStageBean bsb, PagesBean pb) {
		
		List<BackStageBean> bsblist=dao.findByCondition(bsb,pb);
		
		return bsblist;
	}



	@Override
	public String deleteById(Integer id) {
		String result="删除失败";
		
		boolean isDelete =dao.deleteById(id);
		if(isDelete){
			
			result="删除成功";
		}
		
		return result;
	}

}
