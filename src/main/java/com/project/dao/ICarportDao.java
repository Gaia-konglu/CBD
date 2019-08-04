/***********************************************************************
 * Module:  CarportDao.java
 * Author:  Administrator
 * Purpose: Defines the Interface CarportDao
 ***********************************************************************/
package com.project.dao;
import java.util.*;

import org.apache.ibatis.annotations.Insert;

import com.project.bean.CarportBean;

/** @pdOid 9114d0b2-b7bd-4cb7-afb4-f4b9e9a466bf */
public interface ICarportDao {
   /** @param carId
    * @pdOid 7f510ed4-1daa-410d-9944-3bc0ffb220b3 */
 public  CarportBean findById(int carId);
   /** @pdOid f3ccbf6d-926e-4c14-8f10-efc4f518361b */
 public List<CarportBean> findAllCarport(int pageNow,int pageSize);
  
 @Insert("insert into t_cbdpark(p_address,p_number,oam_t_id,ram_b_id) values(#{adress},#{carNum},#{tpc.id},#{crc.id})")
 public void insertCarport(CarportBean cpb);
   /** @param cpb 
    * @param count
    * @pdOid 95023fae-e1a2-449c-9eac-a15023a7f5cd */
 public  void insertMany(List<CarportBean> cblist);
   
 public  int countCarport();

public List<CarportBean> findByCondition(Map<String, Object> map);
public int countCarport2(CarportBean cb);
public void updateCarport(CarportBean cpb);
public void deletecarport(int[] carportId);
}