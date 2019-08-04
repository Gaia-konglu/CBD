package com.project.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.project.bean.BookInforBean;
import com.project.bean.PartingSpaceBean;
import com.project.bean.PersonBean;
import com.project.bean.RentInforBean;
import com.project.bean.OrderBean;
import com.project.dao.ITenantDao;
import com.project.service.ITenantService;

@Service
public class TenantServiceImpl implements ITenantService {
	@Autowired
	@Qualifier("tenantDaoImpl")
	private ITenantDao dao;
	
	//查询所有已发布招租车位信息
	@Override
	public List<RentInforBean> checkAllRentInfor(RentInforBean rent,Integer page) {
		int num = (page-1)*10;
		List<RentInforBean> list = dao.findAll(rent,num);
		 
		 return list;
	}

	//添加预定信息
	@Override
	public void addBookInfor(RentInforBean rentInfor, PersonBean tenant,PersonBean landLady, String message) {
		BookInforBean book = new BookInforBean();
		book.setMessage(message);
		book.setLandLady(landLady);
		book.setTenant(tenant);
		book.setRent(rentInfor);
		dao.addBookInfor(book);
		
	}
	//删除招租信息
	@Override
	public void deleteRentInfor(RentInforBean rentInfor) {
		dao.deleteRentInfor(rentInfor);
	}
	//通过招租信息ID查询包租婆ID，用于预定信息查询
	@Override
	public int findLandLadyId(int id) {
		int landLadyId = dao.findLandLadyId(id);
		return landLadyId;
	}
	//查看可支付的预定信息
	@Override
	public List<BookInforBean> checkPayBookInfor(Integer id) {
		List<BookInforBean> list = dao.findBookInforByTenant(id);
		return list;
	}
	//查询总页数
	@Override
	public int findTotalPages(RentInforBean rent) {
		int totalNum = dao.findTotalPages(rent);
		
		return totalNum;
	}
	 //通过被投诉人id查询总订单数
	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED)
	public int findCountByPersonId(int id1, int id2) {
		int complainTenantCount=dao.findCountByPersonId(id1, id2);
		return complainTenantCount;
	}
	//通过订单号查询预定信息
	@Override
	public BookInforBean findBookInforByTradeOder(String tradeOrder) {
		BookInforBean book = dao.findBookInforByTradeOrder(tradeOrder);
		return book;
	}
	//添加交易记录
	@Override
	public void addTradeInfor(OrderBean order) {
		dao.addTradeInfor(order);
		
	}
	//通过订单id查询订单信息
	@Override
	public OrderBean findThingBycp_or_id(String order_id) {
		OrderBean order=dao.findThingBycp_or_id(order_id);
		return order;
	}
	//删除已完成的可支付的订单信息
	@Override
	public void deletePayBookInfor(BookInforBean book) {
		dao.deletePayBookInfor(book);
		
	}
	//查询历史交易信息
	@Override
	public List<OrderBean> checkTradeInfor(PersonBean bean, Integer page) {
		int num = (page-1)*10;
		List<OrderBean> list = dao.findTradeInfor(bean,num);
		return list;
	}
	//查询历史成交总数
	@Override
	public int findTradeInforTotal(PersonBean bean) {
		int num = dao.findTradeInforTotal(bean);
		return num;
	}
	//高德地图查询招租信息
	@Override
	public List<RentInforBean> checkGaodeInfor(RentInforBean rent) {
		List<RentInforBean> list = dao.findAllRentInfor(rent);
		return list;
	}

	

}
