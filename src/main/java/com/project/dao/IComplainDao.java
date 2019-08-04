/***********************************************************************
 * Module:  ComplainDao.java
 * Author:  Administrator
 * Purpose: Defines the Interface ComplainDao
 ***********************************************************************/
package com.project.dao;
import java.util.*;

import com.project.bean.ComplainBean;
import com.project.bean.OrderBean;
import com.project.bean.PagesBean;
import com.project.bean.PersonBean;


public interface IComplainDao {
  //通过投诉状态查找投诉信息
   public List<ComplainBean> findUntreateComplian(PagesBean page);
   //通过投诉id更新投诉状态
   public void updateStatusById(int comId);
  //通过投诉者和被投诉者账户名查找单条投诉信息
    public int fingSingleContaintByCper(String name,String name2);
    //通过投诉状态超找投诉数
   public int findUntreateComplainCount(String status);
   //更新投诉回复内容
   public void updateComplainRecontent(ComplainBean complain);
   //通过投诉id查找投诉信息
   public ComplainBean findComplainById(int comId);
   //更新状态与回复
   public void updateComplainRecontentAndStatus(ComplainBean complain);
   //通过状态与被投诉id查找投诉数量
   public int findComplainCountBynferAndStatus(ComplainBean com);
   //通过操作员id与状态查找投诉信息
   public List<ComplainBean> findComplianByad_idAndStatus(PagesBean page);
   //通过状态与操作员id查找投诉数
   public int findComplainCountByStatusAndad_id(ComplainBean complain);
   //添加投诉信息
   public void AddComplain(ComplainBean com);
   //通过订单id与被投诉者id查询投诉信息
   public ComplainBean findComolainByidAndOrder_id(ComplainBean com);
   
   public List<ComplainBean> findcomBystaAndPerName(PagesBean p);
   
   public int findCountBystandname(PagesBean p);
    

}