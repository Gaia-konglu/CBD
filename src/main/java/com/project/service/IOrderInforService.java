/***********************************************************************
 * Module:  IOrderInforService.java
 * Author:  Administrator
 * Purpose: Defines the Interface IOrderInforService
 ***********************************************************************/
package com.project.service;
import java.util.*;

import com.project.bean.PersonBean;
import com.project.bean.RentInforBean;

/** @pdOid 2d5333a4-4ef3-4fe4-b0ed-d5ea7c85ca55 */
public interface IOrderInforService {
   /** @param rentInfor 
    * @param tenant 
    * @param time
    * @pdOid 47a785d4-50e0-4cd1-833a-d72320e9b658 */
   void addOrder(RentInforBean rentInfor, PersonBean tenant, String time);

}