/***********************************************************************
 * Module:  ISuperBakDao.java
 * Author:  Administrator
 * Purpose: Defines the Interface ISuperBakDao
 ***********************************************************************/
package com.project.dao;
import java.util.*;

import com.project.bean.BackStageBean;

/** @pdOid cd14ec09-b183-4a03-8e30-ec6b4798d8f5 */
public interface ISuperBakDao {
   /** @param bsb
    * @pdOid c06b5d0a-aaab-4c73-a7aa-18b5457a34c0 */
   boolean update(BackStageBean bsb);
   /** @param bsb
    * @pdOid 969a835b-a8f4-40fb-a200-1ecefce89e5b */
   boolean add(BackStageBean bsb);

   public List<BackStageBean> findAllBackStage(int pageNow,int pageSize);
   
   public int countPages();
   
   public BackStageBean findByid(int id);
}