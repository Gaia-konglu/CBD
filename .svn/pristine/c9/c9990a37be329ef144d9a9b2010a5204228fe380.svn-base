/***********************************************************************
 * Module:  PersonDao.java
 * Author:  Administrator
 * Purpose: Defines the Interface PersonDao
 ***********************************************************************/
package com.project.dao;
import java.util.*;

import com.project.bean.PersonBean;

/** @pdOid 1a864e02-1c3d-4442-9833-f0468fcfa67a */
public interface IPersonDao {
   /** @param perb
    * @pdOid ca844c33-296f-4da8-9c74-94211f5538ce */
   void updateCreditById(PersonBean perb);
   /** @param personBean
    * @pdOid de248160-c690-47bd-af57-4d6da34d99a2 */
   boolean ChangeInfo(PersonBean personBean);
   /** @pdOid 342e9874-0feb-4035-b302-f518c05a1d2d */
   List<PersonBean> selectAll();
   /** @param id
    * @pdOid 8df093ff-64b8-4f56-873d-722bb1e15b89 */
   PersonBean selectById(Integer id);
   /** @param name
    * @pdOid f03172b6-4cb4-43a3-a6e8-905bf2d12f73 */
//   PersonBean selectByName(java.lang.String name);
   /** @param rents
    * @pdOid 48e07ece-d161-4153-b6e9-94fe30fda791 */
   Integer selectByObj(PersonBean rents);
   /** @param rents
    * @pdOid 682d25b1-3082-46d4-a948-879b378ef2f6 */
  // void insert(PersonBean rents);
   
   /**
    * 查找包租婆/抢租客
    * @param name
    * @return
    */
   PersonBean selectByName(String name);

   /**
    * 注册包租婆/抢租客
    * @param personBean
    */
   void insert(PersonBean personBean);
   

}