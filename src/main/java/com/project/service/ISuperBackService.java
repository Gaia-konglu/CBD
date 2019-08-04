/***********************************************************************
 * Module:  ISuperBackService.java
 * Author:  Administrator
 * Purpose: Defines the Interface ISuperBackService
 ***********************************************************************/
package com.project.service;
import java.util.*;

import com.project.bean.BackStageBean;
import com.project.bean.PagesBean;

/** @pdOid d22d9676-d644-48aa-b0a1-35993e799fb1 */
public interface ISuperBackService {
   /** @param bsb
    * @pdOid afa3a291-88b4-4a15-91c5-22cb28f82bc4 */
	public boolean addBack(BackStageBean bsb);
   /** @param bsb
    * @pdOid c48b2bf6-428c-4e6c-ac18-f8c25ebb9556 */
	public boolean ChangeBackInfo(BackStageBean bsb);


	
	public List<BackStageBean> findAllBackStage(PagesBean pb);
	public int coutPages();
	public BackStageBean findBackbyId(Integer id);
	boolean ChangeBackInfo(BackStageBean nbsb, int id);
	public List<BackStageBean> findAllByCondition(BackStageBean bsb, PagesBean pb);
	public String deleteById(Integer id);
	
}