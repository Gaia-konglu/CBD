package com.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.project.bean.BookInforBean;
import com.project.bean.OrderBean;
import com.project.bean.PartingSpaceBean;
import com.project.bean.PersonBean;
import com.project.bean.RentInforBean;
import com.project.dao.ILandLadyDao;
import com.project.service.ILandLadyService;
@Service
public class LandLadyServiceImpl implements ILandLadyService {
	@Autowired
	@Qualifier("landLadyDaoImpl")
	private ILandLadyDao dao;
	//添加车位信息
	@Override
	public void addPartingSpace(PartingSpaceBean partingSpaceInfor) {
		dao.addPartingSpace(partingSpaceInfor);

	}

	//添加招租信息到数据库
	@Override
	public void addRentInfor(RentInforBean rent) {
		dao.addRentInfor(rent);
		
	}
	//显示所有预定信息
	@Override
	public List<BookInforBean> checkBookInfor(PersonBean landLady,Integer page) {
		int num = (page-1)*10;
		 List<BookInforBean> books = dao.findAllBookInfor(landLady,num);
		return books;
	}
	//查询预定信息总页数
	@Override
	public int findBookInforTotalPage(PersonBean bean) {
		int totalNum = dao.findBookInforTotalPage(bean);
		return totalNum;
		
	}
	//删除预定信息
	@Override
	public void deleteBookInfor(Integer rid) {
		dao.deleteBookInfor(rid);
		
	}

	@Override
	public void addComplain(String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PersonBean login(String name, String pwd, int roleId) {
		PersonBean bean = dao.findLandLady(name, pwd, roleId);
//		System.out.println(bean);
		return bean;
	}
	//更新预定信息状态
	@Override
	public void updateStatus(BookInforBean book) {
		dao.updateStatus(book);
		
	}
	//查询包租婆个人车位信息
	@Override
	public List<PartingSpaceBean> findMyPartInfor(PersonBean bean,Integer page) {
		int num = (page-1)*10;
		List<PartingSpaceBean> list = dao.findMyPartById(bean,num);
		return list;
	}
	//查询车位总数
	@Override
	public int findMyPartTotal(PersonBean bean) {
		int num = dao.findMyPartTotal(bean);
		return num;
	}
	
	//查询包租婆个人招租信息，用于招租信息管理
	@Override
	public List<RentInforBean> findMyRentInfor(PersonBean bean,Integer page) {
		int num = (page-1)*10;
		List<RentInforBean> list = dao.findMyRentById(bean,num);
		return list;
	}
	//查询招租信息总数
	@Override
	public int findRentInforTotal(PersonBean bean) {
		int num = dao.findRentInforTotal(bean);
		return num;
	}
	//根据招租ID查询预定状态
	@Override
	public List<BookInforBean> findStatus(Integer id) {
		List<BookInforBean> status = dao.findStatus(id);
		return status;
	}
	//删除招租信息
	@Override
	public void deleteRentInfor(Integer id) {
		dao.deleteRentInfor(id);
		
	}
	//查询车位信息和发布状态
	@Override
	public int findRentStatus(Integer id) {
		int flag = dao.findRentStatus(id);
		return flag;
	}
	//查询历史交易记录
	@Override
	public List<OrderBean> checkTradeInfor(PersonBean bean,Integer page) {
		int num = (page-1)*10;
		List<OrderBean> order = dao.findTradeInfor(bean,num);
		return order;
	}

	@Override
	public int findTradeInforTotalPage(PersonBean bean) {
		int totalNum = dao.findTradeInforTotalPage(bean);
		return totalNum;

	}
	//删除车位信息
	@Override
	public void deletePart(Integer pid) {
		dao.deletePart(pid);
		
	}
	//修改招租信息状态为3表示已生成订单
	@Override
	public void updateRentStatus(Integer rid) {
		dao.updateRentStatus(rid);
		
	}
	//查询车位产权是否存在
	@Override
	public Boolean findPropertyNum(String propertyNum) {
		PartingSpaceBean part = dao.findPropertyNum(propertyNum);
		if(part==null){
			return true;
		}
		return false;
	}
	//高德地图查询
	

}
