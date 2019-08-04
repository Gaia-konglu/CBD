/***********************************************************************
 * Module:  ITenantService.java
 * Author:  konglu
 * Purpose: Defines the Interface ITenantService
 ***********************************************************************/
package com.project.service;
import java.util.*;

import com.project.bean.BookInforBean;
import com.project.bean.PartingSpaceBean;
import com.project.bean.PersonBean;
import com.project.bean.RentInforBean;
import com.project.bean.OrderBean;

//抢租客业务层
public interface ITenantService {
   
	//查看所有招租信息
   public List<RentInforBean> checkAllRentInfor(RentInforBean rent,Integer page);
   //添加预定信息
   public void addBookInfor(RentInforBean rentInfor, PersonBean tenant,PersonBean landLady, String message);
   //删除招租信息
   public void deleteRentInfor(RentInforBean rentInfor);
   //通过招租信息ID查询招租婆ID
   public int findLandLadyId(int id);
   //查看可支付的预定信息
   public List<BookInforBean> checkPayBookInfor(Integer id);
   //查询总页数
   public int findTotalPages(RentInforBean rent);
   //通过被投诉人id查询总订单数
   public int findCountByPersonId(int id1, int id2);
   //通过订单号查询预定信息
   public BookInforBean findBookInforByTradeOder(String tradeOrder);
   //添加交易信息
   public void addTradeInfor(OrderBean order);
 //通过订单id查询订单信息
   public OrderBean findThingBycp_or_id(String order_id);
   //删除已完成的可支付预定信息
   public void deletePayBookInfor(BookInforBean book);
   //查询历史交易信息
   public List<OrderBean> checkTradeInfor(PersonBean bean, Integer page);
   //查询历史总交易数
   public int findTradeInforTotal(PersonBean bean);
   //高德地图查询
   public List<RentInforBean> checkGaodeInfor(RentInforBean rent);
}