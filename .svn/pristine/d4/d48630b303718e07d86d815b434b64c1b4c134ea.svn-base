package com.project.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.alipay.api.domain.Image;
import com.project.bean.ComplainBean;
import com.project.bean.OrderBean;
import com.project.bean.PagesBean;
import com.project.bean.PersonBean;
import com.project.dao.IComplainDao;

@Repository
public class ComplainDAOImpl implements IComplainDao {
	@Autowired
     private SqlSessionFactory fa=null;
	@Override
	public List<ComplainBean> findUntreateComplian(PagesBean page) {
		SqlSession session=fa.openSession();
		List<ComplainBean> list=session.selectList("com.project.dao.IComplainDao.findUntreateComplian", page);
		System.out.println(list);
		
		session.close();
		return list;
	}


	@Override
	public void updateStatusById(int comId) {
		SqlSession session=fa.openSession();
		session.update("com.project.dao.IComplainDao.updateStatusById", comId);
		
		session.commit();
		session.close();

	}

	@Override
	public void updateComplainRecontent(ComplainBean complain) {
		SqlSession session=fa.openSession();
		session.insert("com.project.dao.IComplainDao.addComplainMessage",complain);
		
		session.commit();
		session.close();
	}

	@Override
	public ComplainBean findComplainById(int comId) {
		SqlSession session=fa.openSession();
		ComplainBean com=session.selectOne("com.project.dao.IComplainDao.findComplainById",comId);
		
		session.close();
		return com;
	}


	

	@Override
	public void updateComplainRecontentAndStatus(ComplainBean complain) {
		
		SqlSession session=fa.openSession();
		session.insert("com.project.dao.IComplainDao.updateComplainRecontentAndStatus",complain);
		
		session.commit();
		session.close();
	}

	@Override
	public int fingSingleContaintByCper(String name, String name2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int findUntreateComplainCount(String status) {
		SqlSession session=fa.openSession();
		int untreateCount=session.selectOne("com.project.dao.IComplainDao.findUntreateComplainCount",status);
		
		session.close();
		return untreateCount;
	}

	@Override
	public int findComplainCountBynferAndStatus(ComplainBean com) {
		SqlSession session=fa.openSession();
		int dferCount=session.selectOne("com.project.dao.IComplainDao.findComplainCountBynferAndStatus",com);
		
		session.close();
		return dferCount;
	}

	@Override
	public List<ComplainBean> findComplianByad_idAndStatus(PagesBean page) {
		SqlSession session=fa.openSession();
		List<ComplainBean> list=session.selectList("com.project.dao.IComplainDao.findComplianByad_idAndStatus", page);
		System.out.println(list);
		
		session.close();
		return list;
	}

	@Override
	public int findComplainCountByStatusAndad_id(ComplainBean complain) {
		SqlSession session=fa.openSession();
		int WaitHandleComplainCount=session.selectOne("com.project.dao.IComplainDao.findComplainCountByStatusAndad_id",complain);
		
		session.close();
		return WaitHandleComplainCount;
	}

	//添加投诉信息
	@Override
	public void AddComplain(ComplainBean com) {
		SqlSession session=fa.openSession();
		session.insert("com.project.dao.IComplainDao.AddComplain",com);
		
		session.commit();
		session.close();
		
	}

	//通过订单id与被投诉者id查询投诉信息
	@Override
	public ComplainBean findComolainByidAndOrder_id(ComplainBean com) {
		SqlSession session=fa.openSession();
		IComplainDao dao=session.getMapper(IComplainDao.class);
		ComplainBean com1=dao.findComolainByidAndOrder_id(com);
		
		session.close();
		return com1;
	}


	@Override
	public List<ComplainBean> findcomBystaAndPerName(PagesBean p) {
		SqlSession session=fa.openSession();
		IComplainDao dao=session.getMapper(IComplainDao.class);
		List<ComplainBean> list=dao.findcomBystaAndPerName(p);
		return list;
	}


	@Override
	public int findCountBystandname(PagesBean p) {
		SqlSession session=fa.openSession();
		IComplainDao dao=session.getMapper(IComplainDao.class);
		int c=dao.findCountBystandname(p);
		return c;
	}

}
