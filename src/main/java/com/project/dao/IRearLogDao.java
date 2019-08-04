/***********************************************************************
 * Module:  日志Dao.java
 * Author:  Administrator
 * Purpose: Defines the Interface 日志Dao
 ***********************************************************************/
package com.project.dao;
import java.util.*;

import org.apache.ibatis.annotations.Param;

import com.project.bean.RearLoginLogBean;
import com.project.bean.RearOperationLogBean;

/** @pdOid 944250f2-cdfe-46a5-ba9e-ee3acbe8932c */
public interface IRearLogDao {
   /** @param rll
    * @pdOid 992b367c-a1b0-4c4e-b8be-abe67efd6797 
    * 记录后台登录日志*/
    public boolean insertRegisterLog(RearLoginLogBean rll);
   /** @param rol
    * @pdOid cddfde72-451d-4d0b-8d76-76725770b3ef 
    * 记录后台操作日志*/
    public boolean insertOperationLog(RearOperationLogBean rol);
   /** @pdOid 76e2afc8-22d7-4cba-a432-50c21d80a3aa 
    * 查看后台登录日志*/
    public List<RearLoginLogBean> queryRegisterLog(@Param("index")int index);
   /** @pdOid af8f2775-d154-45d5-bb2e-31207b9a0c97 
    * 查看后台操作日志*/
    public List<RearOperationLogBean> queryOperationLog(@Param("index")int index);
    
    /*查看后台登录日志的总页数*/
    public int findLoginLogTotalPage();
    /*查看后台操作日志的总页数*/
    public int findRealOperationTotalPage();
    
}