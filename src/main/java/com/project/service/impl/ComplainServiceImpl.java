package com.project.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.project.bean.ComplainBean;
import com.project.bean.OrderBean;
import com.project.bean.PagesBean;
import com.project.bean.PersonBean;
import com.project.dao.IComplainDao;
import com.project.dao.impl.ComplainDAOImpl;
import com.project.service.IComplainService;

@Service
public class ComplainServiceImpl implements IComplainService {
	@Autowired
    private ComplainDAOImpl dao;
	@Autowired
	private SqlSessionFactory fa=null;
	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED)
	public List<ComplainBean> findUntreatComplain(PagesBean page) {
//		dao=new ComplainDAOImpl();
		List<ComplainBean> list=dao.findUntreateComplian(page);
		return list;
	}

	

	@Override
	public void updateStatusById(int comId) {
		dao.updateStatusById(comId);

	}

	@Override
	public void updateComplainRecontent(ComplainBean complain) {
		dao.updateComplainRecontent(complain);
	}



	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED)
	public ComplainBean findComplainById(int comId) {
		ComplainBean com=dao.findComplainById(comId);
		return com;
	}



	@Override
	public int fingSingleContaintByCper(String name,String name2) {
		SqlSession session=fa.openSession();
		IComplainDao dao=session.getMapper(IComplainDao.class);
		int id=dao.fingSingleContaintByCper(name,name2);
		
		session.close();
		return id;
	}


	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED)
	public void updateComplainRecontentAndStatus(ComplainBean complain) {
		dao.updateComplainRecontentAndStatus(complain);
		
	}



	@Override
	public int findUntreateComplainCount(String status) {
		int untreateCount=dao.findUntreateComplainCount(status);
		return untreateCount;
	}



	@Override
	public boolean isSuccessComplain(String status) {
		if(status.equals("投诉生效")){
			return true;
		}
		return false;
	}



	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED)
	public int findComplainCountBynferAndStatus(ComplainBean com) {
		
		int dferCount=dao.findComplainCountBynferAndStatus(com);
		
		
		return dferCount;
	}



	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED)
	public List<ComplainBean> findComplianByad_idAndStatus(PagesBean page) {
		List<ComplainBean> list=dao.findComplianByad_idAndStatus(page);
		return list;
	}



	@Override
	public int findComplainCountByStatusAndad_id(ComplainBean complain) {
		int WaitHandleComplainCount=dao.findComplainCountByStatusAndad_id(complain);
		return WaitHandleComplainCount;
	}



	@Override
	public void AddComplain(ComplainBean com) {
		dao.AddComplain(com);
		
	}


	//通过订单id与被投诉者id查询投诉信息
	@Override
	public ComplainBean findComolainByidAndOrder_id(ComplainBean com) {
		ComplainBean com1=dao.findComolainByidAndOrder_id(com);
		return com1;
	}



	@Override
	public List<ComplainBean> findcomBystaAndPerName(PagesBean p) {
		List<ComplainBean> list=dao.findcomBystaAndPerName(p);
		return list;
	}



	@Override
	public int findCountBystandname(PagesBean p) {
		int c=dao.findCountBystandname(p);
				return c;
	}
	
	

}
