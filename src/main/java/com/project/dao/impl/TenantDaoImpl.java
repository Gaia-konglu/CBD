package com.project.dao.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.bean.BookInforBean;
import com.project.bean.PartingSpaceBean;
import com.project.bean.PersonBean;
import com.project.bean.RentInforBean;
import com.project.bean.OrderBean;
import com.project.dao.ITenantDao;

@Repository
public class TenantDaoImpl implements ITenantDao{

	@Autowired
	private SqlSessionFactory fa;
	
	//分页查询所有招租信息(包括时间段查询)
	@Override
	public List<RentInforBean> findAll(RentInforBean rent,int num) {		
		SqlSession session = fa.openSession();
		ITenantDao dao = session.getMapper(ITenantDao.class);
		List<RentInforBean> list = dao.findAll(rent,num);
		session.close();
		return list;
	}

	//添加预定信息
	@Override
	public void addBookInfor(BookInforBean bookInfor) {
		SqlSession session = fa.openSession();
		ITenantDao dao = session.getMapper(ITenantDao.class);
		dao.addBookInfor(bookInfor);
		session.close();
	}
	//删除招租信息
	@Override
	public void deleteRentInfor(RentInforBean rentInfor) {
		SqlSession session = fa.openSession();
		ITenantDao dao = session.getMapper(ITenantDao.class);
		dao.deleteRentInfor(rentInfor);
		session.close();
	}
	//查询招租婆ID
	@Override
	public int findLandLadyId(int id) {
		SqlSession session = fa.openSession();
		ITenantDao dao = session.getMapper(ITenantDao.class);
		int landLadyId = dao.findLandLadyId(id);
		session.close();
		return landLadyId;
	}
	//查看可支付的预定信息
	@Override
	public List<BookInforBean> findBookInforByTenant(Integer id) {
		SqlSession session = fa.openSession();
		ITenantDao dao = session.getMapper(ITenantDao.class);
		List<BookInforBean> list = dao.findBookInforByTenant(id);
		session.close();
		return list;
	}
	//查询总页数
	@Override
	public int findTotalPages(RentInforBean rent) {
		SqlSession session = fa.openSession();
		ITenantDao dao = session.getMapper(ITenantDao.class);
		int total = dao.findTotalPages(rent);
		session.close();
		return total;
	}

	@Override
	public int findCountByPersonId(int id1, int id2) {
		SqlSession session = fa.openSession();
		ITenantDao dao = session.getMapper(ITenantDao.class);
		int complainTenantCount=dao.findCountByPersonId(id1, id2);
		session.close();
		return complainTenantCount;
	}
	//通过订单号查询预定信息
	@Override
	public BookInforBean findBookInforByTradeOrder(String tradeOrder) {
		SqlSession session = fa.openSession();
		ITenantDao dao = session.getMapper(ITenantDao.class);
		BookInforBean book = dao.findBookInforByTradeOrder(tradeOrder);
		session.close();
		return book;
	}
	//添加交易记录
	@Override
	public void addTradeInfor(OrderBean order) {
		SqlSession session = fa.openSession();
		ITenantDao dao = session.getMapper(ITenantDao.class);
		dao.addTradeInfor(order);
		session.close();
	}

	//通过订单id查询订单信息
	@Override
	public OrderBean findThingBycp_or_id(String order_id) {
		SqlSession session = fa.openSession();
		ITenantDao dao = session.getMapper(ITenantDao.class);
		OrderBean order=dao.findThingBycp_or_id(order_id);
		session.close();
		return order;
	}

	//删除可支付的已完成的预定信息
	@Override
	public void deletePayBookInfor(BookInforBean book) {
		SqlSession session = fa.openSession();
		ITenantDao dao = session.getMapper(ITenantDao.class);
		dao.deletePayBookInfor(book);
		session.close();
		
	}
	//查询历史交易记录
	@Override
	public List<OrderBean> findTradeInfor(PersonBean bean, int num) {
		SqlSession session = fa.openSession();
		ITenantDao dao = session.getMapper(ITenantDao.class);
		List<OrderBean> list = dao.findTradeInfor(bean, num);
		return list;
	}
	//查询历史成交总数
	@Override
	public int findTradeInforTotal(PersonBean bean) {
		SqlSession session = fa.openSession();
		ITenantDao dao = session.getMapper(ITenantDao.class);
		int num = dao.findTradeInforTotal(bean);
		session.close();
		return num;
	}
	//高德地图显示招租信息
	@Override
	public List<RentInforBean> findAllRentInfor(RentInforBean rent) {
		SqlSession session = fa.openSession();
		ITenantDao dao = session.getMapper(ITenantDao.class);
		List<RentInforBean> list= dao.findAllRentInfor(rent);
		return list;
	}

	
	
}
