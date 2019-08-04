/***********************************************************************
 * Module:  ILandLadyService.java
 * Author:  konglu
 * Purpose: Defines the Interface ILandLadyService
 ***********************************************************************/
package com.project.service;

import java.util.List;

import com.project.bean.BookInforBean;
import com.project.bean.OrderBean;
import com.project.bean.PartingSpaceBean;
import com.project.bean.PersonBean;
import com.project.bean.RentInforBean;

//包租婆业务层
public interface ILandLadyService {
	//添加停车位信息
  public void addPartingSpace(PartingSpaceBean partingSpaceInfor);
  //删除车位信息
  public void deletePart(Integer pid);
  //发布招租车位信息
  public void addRentInfor(RentInforBean rent);
   //查看预定车位信息
  public List<BookInforBean> checkBookInfor(PersonBean landLady, Integer page);
   //删除预定车位信息
  public void deleteBookInfor(Integer rid);
  //删除招租信息
  public void deleteRentInfor(Integer id);
  //添加投诉
  public void addComplain(String message);
   //包租婆登录
  public PersonBean login(String name, String pwd, int roleId);
  //更新预定信息状态
  public void updateStatus(BookInforBean book);
  //查询包租婆的个人车位信息，用于车位信息管理
  public List<PartingSpaceBean> findMyPartInfor(PersonBean landLady,Integer page);
  //查询停车位总数
  public int findMyPartTotal(PersonBean bean);
  //查询包租婆招租信息，用于招租信息管理
  public List<RentInforBean> findMyRentInfor(PersonBean landLady,Integer page);
  //查询招租信息总条数
  public int findRentInforTotal(PersonBean bean);
  //根据招租ID查询预定状态
  public List<BookInforBean> findStatus(Integer id);
  //查询预定信息总页数
  public int findBookInforTotalPage(PersonBean bean);
  //查询车位信息和发布状态
  public int findRentStatus(Integer id);
  //查询历史交易信息
  public List<OrderBean> checkTradeInfor(PersonBean bean,Integer page);
  //查询交易总记录数
  public int findTradeInforTotalPage(PersonBean bean);
  //修改招租信息状态为已生成订单
  public void updateRentStatus(Integer rid);
  //查询车位产权
  public Boolean findPropertyNum(String propertyNum);
 
}