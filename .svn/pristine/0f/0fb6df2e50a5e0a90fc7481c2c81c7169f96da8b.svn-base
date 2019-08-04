/***********************************************************************
 * Module:  CarportService.java
 * Author:  Administrator
 * Purpose: Defines the Interface CarportService
 ***********************************************************************/
package com.project.service;
import java.util.*;

import com.project.bean.CarportBean;
import com.project.bean.PagesBean;

/** @pdOid c2bb94d9-0502-4193-90cf-dcc1a0714866 */
public interface ICarportService {
   /** @pdOid 49a40844-8e55-42ae-8aa0-f3641de00d5c */
   List<CarportBean> findAllCarport(PagesBean pb);
   /** @pdOid 0c6fea1b-f41f-4d0c-9872-d8ef3023e92e */
   String addCarport(CarportBean cpb);
   /** @pdOid 37c19f63-c11c-4d8a-9444-a26ecad6548c */
   String addManyCarport(CarportBean cb,String areaId,Integer caportId,Integer carportNum);
   
   int coutPages();
List<CarportBean> findCarportByCondition(PagesBean pb, CarportBean cb);
int coutPages2(CarportBean cb);
void updateCarport(CarportBean cpb);
void deletecarport(int[] carportId);

}