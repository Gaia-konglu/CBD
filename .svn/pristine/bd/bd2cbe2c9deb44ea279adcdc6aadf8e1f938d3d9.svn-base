/***********************************************************************
 * Module:  IlogService.java
 * Author:  Administrator
 * Purpose: Defines the Interface IlogService
 ***********************************************************************/
package com.project.service;
import java.util.*;

import com.project.bean.RearLoginLogBean;
import com.project.bean.RearOperationLogBean;

/** @pdOid 9c03f715-9aa4-47af-ae4b-4151985d4773 */
public interface IRearLogService {
   /** @param rll
    * @pdOid c041c4f4-19d1-47fe-8b02-2f448f261d85 
    * 记录后台登录日志*/
	public boolean insertRegisterLog(RearLoginLogBean rll);
   /** @param rol
    * @pdOid 68018240-a6f2-433e-9979-9355ea802012 
    * 记录后台操作日志*/
	public boolean insertOperationLog(RearOperationLogBean rol);
   /** @pdOid b861bb9a-0e77-4c8c-a38f-544696d731ce 
    * 查看后台登录日志*/
	public List<RearLoginLogBean> queryRegisterLog(int index);
   /** @pdOid ea37d019-1e5d-4215-8e2b-d4915d34e384 
    * 查看后台操作日志*/
	public List<RearOperationLogBean> queryOperationLog(int index);
	
	 /*查看后台登录日志的总页数*/
    public int findLoginLogTotalPage();
    /*查看后台操作日志的总页数*/
    public int findRealOperationTotalPage();

}