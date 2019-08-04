/***********************************************************************
 * Module:  IBackDao.java
 * Author:  Administrator
 * Purpose: Defines the Interface IBackDao
 ***********************************************************************/
package com.project.dao;
import java.util.*;

import com.project.bean.BackStageBean;

/** @pdOid 0ac5df90-19b7-4398-8c3e-338fe5870d96 */
public interface IBackDao {
   /** @pdOid b48cfe4b-4b0b-45db-9d9d-7bcfca3fe5e8 */
	public List<BackStageBean> selectAll();
   /** @param id
    * @pdOid 0979b877-541b-4aac-b6ab-01999f77e445 */
   public BackStageBean selectById(Integer id);
   /** @param name
    * @pdOid 119627df-0d6c-4819-8fab-a55d8e1e1a3e */
   public BackStageBean getBackByAccount(String account);
   /** @param backstage
    * @pdOid 6e9d3337-eac5-47fd-b54b-265b3856c91d */
   public Integer selectByObj(BackStageBean backstage);
   /** @param bsb
    * @pdOid 6f913555-3841-47b3-8e42-e639681a0cbf */
   public boolean update(BackStageBean bsb);
   /** @param id
    * @pdOid ffcf72d5-5e22-4fc6-a49b-a873ab35fe4c */
   public BackStageBean getBackById(int id);

}