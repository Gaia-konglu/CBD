/***********************************************************************
 * Module:  ILandLadyDao.java
 * Author:  konglu
 * Purpose: Defines the Interface ILandLadyDao
 ***********************************************************************/
package com.project.dao;
import java.util.*;

import org.apache.ibatis.annotations.Param;

import com.project.bean.BookInforBean;
import com.project.bean.OrderBean;
import com.project.bean.PartingSpaceBean;
import com.project.bean.PersonBean;
import com.project.bean.RentInforBean;

//包租婆Dao层接口
public interface ILandLadyDao {
	//登录验证
   public PersonBean findLandLady(@Param("name")String name, @Param("pwd")String pwd, @Param("id")int roleId);
   //添加个人停车位信息
   public void addPartingSpace(PartingSpaceBean partingSpace);
  //添加招租信息
   public void addRentInfor(RentInforBean rentInfor);
   //查询预定信息
   public List<BookInforBean> findAllBookInfor(@Param("landLady")PersonBean landLady,@Param("num")int num);
   //删除预定信息
   public void deleteBookInfor(Integer rid);
   //更新预定信息状态
   public void updateStatus(BookInforBean book);
   //根据ID查询包租婆个人车位信息
   public List<PartingSpaceBean> findMyPartById(@Param("landLady")PersonBean bean,@Param("num")int num);
   //查询停车位总数
   public int findMyPartTotal(PersonBean bean);
   //查询包租婆招租信息
   public List<RentInforBean> findMyRentById(@Param("landLady")PersonBean landLady,@Param("num")int num);
   //查询招租信息总数
   public int findRentInforTotal(PersonBean bean);
   //根据招租ID查询预定状态
   public List<BookInforBean> findStatus(Integer id);
   //删除招租信息
   public void deleteRentInfor(Integer id);
   //查询预定信息总页数
   public int findBookInforTotalPage(PersonBean bean);
   //查询车位信息和发布状态
   public int findRentStatus(Integer id);
   //查询历史交易信息
   public List<OrderBean> findTradeInfor(@Param("landLady")PersonBean bean,@Param("num")int num);
   //查询交易记录总数
   public int findTradeInforTotalPage(PersonBean bean);
   //删除车位信息
   public void deletePart(Integer pid);
   //修改招租信息状态为已生成订单
   public void updateRentStatus(Integer rid);
   //查询车位产权
   public PartingSpaceBean findPropertyNum(String propertyNum);

  
}