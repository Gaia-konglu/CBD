package com.project.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.bean.BookInforBean;
import com.project.bean.OrderBean;
import com.project.bean.PartingSpaceBean;
import com.project.bean.PersonBean;
import com.project.bean.RentInforBean;
import com.project.dao.ILandLadyDao;
@Repository
public class LandLadyDaoImpl implements ILandLadyDao {
	@Autowired
	private SqlSessionFactory fa;
	//查找包租婆信息用于登录验证
	@Override
	public PersonBean findLandLady(String name, String pwd, int roleId) {
		SqlSession session = fa.openSession();
		ILandLadyDao dao = session.getMapper(ILandLadyDao.class);
		PersonBean person = dao.findLandLady(name, pwd, roleId);
		session.close();
		return person;
	}
	//添加车位信息
	@Override
	public void addPartingSpace(PartingSpaceBean partingSpace) {
		SqlSession session = fa.openSession();
		ILandLadyDao dao = session.getMapper(ILandLadyDao.class);
		dao.addPartingSpace(partingSpace);
		session.close();
	}
	
	//发布招租信息
	@Override
	public void addRentInfor(RentInforBean rentInfor) {
		SqlSession session = fa.openSession();
		ILandLadyDao dao = session.getMapper(ILandLadyDao.class);
		dao.addRentInfor(rentInfor);
		session.close();
	}
	//查询抢租客预定信息
	@Override
	public List<BookInforBean> findAllBookInfor(PersonBean landLady,int num) {
		SqlSession session = fa.openSession();
		ILandLadyDao dao = session.getMapper(ILandLadyDao.class);
		List<BookInforBean> list =  dao.findAllBookInfor(landLady,num);
		session.close();
		return list;
	}
	//删除相关预定信息
	@Override
	public void deleteBookInfor(Integer rid) {
		SqlSession session = fa.openSession();
		ILandLadyDao dao = session.getMapper(ILandLadyDao.class);
		dao.deleteBookInfor(rid);
		session.close();
	}
	//更新预定信息状态
	@Override
	public void updateStatus(BookInforBean book) {
		SqlSession session = fa.openSession();
		ILandLadyDao dao = session.getMapper(ILandLadyDao.class);
		dao.updateStatus(book);
		session.close();
	}
	//查询包租婆个人车位信息
	@Override
	public List<PartingSpaceBean> findMyPartById(PersonBean landLady,int num) {
		SqlSession session = fa.openSession();
		ILandLadyDao dao = session.getMapper(ILandLadyDao.class);
		List<PartingSpaceBean> list = dao.findMyPartById(landLady,num);
		session.close();
		return list;
	}
	//查询停车位总数
	@Override
	public int findMyPartTotal(PersonBean bean) {
		SqlSession session = fa.openSession();
		ILandLadyDao dao = session.getMapper(ILandLadyDao.class);
		int  num = dao.findMyPartTotal(bean);
		return num;
	}
	//查询包租婆招租信息
	@Override
	public List<RentInforBean> findMyRentById(PersonBean landLady,int num) {
		SqlSession session = fa.openSession();
		ILandLadyDao dao = session.getMapper(ILandLadyDao.class);
		List<RentInforBean> list = dao.findMyRentById(landLady,num);
		session.close();
		return list;
	}
	//根据招租ID查询预定状态
	@Override
	public List<BookInforBean> findStatus(Integer id) {
		SqlSession session = fa.openSession();
		ILandLadyDao dao = session.getMapper(ILandLadyDao.class);
		List<BookInforBean> status  = dao.findStatus(id);
		session.close();
		return status;
	}
	//删除招租信息
	@Override
	public void deleteRentInfor(Integer id) {
		SqlSession session = fa.openSession();
		ILandLadyDao dao = session.getMapper(ILandLadyDao.class);
		dao.deleteRentInfor(id);
		session.close();
	}
	//查询预定信息总数
	@Override
	public int findBookInforTotalPage(PersonBean bean) {
		SqlSession session = fa.openSession();
		ILandLadyDao dao = session.getMapper(ILandLadyDao.class);
		int num = dao.findBookInforTotalPage(bean);
		return num;
	}
	//查询车位信息和发布状态
	@Override
	public int findRentStatus(Integer id) {
		SqlSession session = fa.openSession();
		ILandLadyDao dao = session.getMapper(ILandLadyDao.class);
		int flag = dao.findRentStatus(id);
		return flag;
	}
	//查询历史交易信息
	@Override
	public List<OrderBean> findTradeInfor(PersonBean bean,int num) {
		SqlSession session = fa.openSession();
		ILandLadyDao dao = session.getMapper(ILandLadyDao.class);
		List<OrderBean> order = dao.findTradeInfor(bean,num);
		return order;
	}
	//查询交易记录总数
	@Override
	public int findTradeInforTotalPage(PersonBean bean) {
		SqlSession session = fa.openSession();
		ILandLadyDao dao = session.getMapper(ILandLadyDao.class);
		int num = dao.findTradeInforTotalPage(bean);
		return num;
	}
	//删除个人车位信息
	@Override
	public void deletePart(Integer pid) {
		SqlSession session = fa.openSession();
		ILandLadyDao dao = session.getMapper(ILandLadyDao.class);
		dao.deletePart(pid);
		session.close();
		
	}
	//查询招租信息总数
	@Override
	public int findRentInforTotal(PersonBean bean) {
		SqlSession session = fa.openSession();
		ILandLadyDao dao = session.getMapper(ILandLadyDao.class);
		int num = dao.findRentInforTotal(bean);
		session.close();
		return num;
	}
	 //修改招租信息状态为已生成订单
	@Override
	public void updateRentStatus(Integer rid) {
		SqlSession session = fa.openSession();
		ILandLadyDao dao = session.getMapper(ILandLadyDao.class);
		dao.updateRentStatus(rid);
		session.close();
	}
	//查询车位产权
	@Override
	public PartingSpaceBean findPropertyNum(String propertyNum) {
		SqlSession session = fa.openSession();
		ILandLadyDao dao = session.getMapper(ILandLadyDao.class);
		PartingSpaceBean part = dao.findPropertyNum(propertyNum);
		session.close();
		return part;
	}


}
