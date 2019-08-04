/***********************************************************************
 * Module:  ITenantDao.java
 * Author:  konglu
 * Purpose: Defines the Interface ITenantDao
 ***********************************************************************/
package com.project.dao;
import java.util.*;

import org.apache.ibatis.annotations.Param;

import com.project.bean.BookInforBean;
import com.project.bean.PartingSpaceBean;
import com.project.bean.PersonBean;
import com.project.bean.RentInforBean;
import com.project.bean.OrderBean;


public interface ITenantDao {
	//查询所有招租信息
	public List<RentInforBean> findAll(@Param("rent")RentInforBean rent,@Param("num")int num);
  //添加预定信息
   public void addBookInfor(BookInforBean bookInfor);
  //删除招租信息
   public void deleteRentInfor(RentInforBean rentInfor);
   //查询招租婆ID通过招租信息ID，用于预定信息的添加
   public int findLandLadyId(int id);
   //查看可支付的预定信息
   public List<BookInforBean> findBookInforByTenant(Integer id);
   //查询总页数
   public int findTotalPages(RentInforBean rent);
   //通过被投诉人id查询总订单数
   public int findCountByPersonId(int id1,int id2);
   //通过订单号查询预定信息
   public BookInforBean findBookInforByTradeOrder(String tradeOrder);
   //添加交易记录
   public void addTradeInfor(OrderBean order);
   //通过订单id查询订单信息
   public OrderBean findThingBycp_or_id(String order_id);
   //删除可支付的已完成的预定信息
   public void deletePayBookInfor(BookInforBean book);
   //查询历史交易信息
   public List<OrderBean> findTradeInfor(@Param("tenant")PersonBean bean,@Param("num")int num);
   //查询历史成交总数
   public int findTradeInforTotal(PersonBean bean);
   //高德地图显示招租信息
   public List<RentInforBean> findAllRentInfor(RentInforBean rent);
}