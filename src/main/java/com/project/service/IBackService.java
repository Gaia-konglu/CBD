/***********************************************************************
 * Module:  IBackService.java
 * Author:  Administrator
 * Purpose: Defines the Interface IBackService
 ***********************************************************************/
package com.project.service;
import java.util.*;

import com.project.bean.BackStageBean;

/** @pdOid a2c017ad-9a16-4d01-bf64-9fa4c322a991 */
public interface IBackService {
   /** @param bsb
    * @pdOid 3b3cc394-4057-4109-88b4-203186957b11 
    * 后台管理人员修改登录密码和电话号码*/
   public Map<String,Object> ChangeInfo(BackStageBean bsb);
   /** @pdOid 60b3cc70-60db-44f7-ac90-81d8096b1bf5 */
   public List<BackStageBean> selectAll();
   /** @param id
    * @pdOid b436c57b-1326-445b-8476-cd866f327527 */
   public BackStageBean selectById(Integer id);
   /** @param name
    * @pdOid 779266da-f7f2-4195-b095-a70c31d5649e */
   public BackStageBean selectByName(java.lang.Short name);
   /** @param backstage
    * @pdOid 8603065b-f7bc-445f-b6a7-5c7401bc96a9 */
   public Integer selectByObj(BackStageBean backstage);
   //通过账户查询后台管理员
   public BackStageBean getBackByAccount(String account);

}