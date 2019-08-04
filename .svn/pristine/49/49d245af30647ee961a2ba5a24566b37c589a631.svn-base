/***********************************************************************
 * Module:  PersonService.java
 * Author:  Administrator
 * Purpose: Defines the Interface PersonService
 ***********************************************************************/
package com.project.service;
import java.util.*;

import com.project.bean.PersonBean;
import com.project.exception.AccountExistException;
import com.project.vo.PersonVo;

/** @pdOid 7e8976bb-1b6f-49db-a6b8-aa21a32b982b */
public interface IPersonService {
   /** @pdOid 4bc198bf-267e-4bba-bb38-c654aa8a0364 */
	public List<PersonBean> selectAll();
   /** @param id
    * @pdOid f83120f7-b54c-469c-86a5-573fffa946ab */
	public PersonBean selectById(Integer id);
   /** @param name
    * @pdOid 8aeac12c-146a-4c98-b735-c66b873ade3e */
	public PersonBean selectByName(java.lang.String name);
   /** @param rents
    * @pdOid 3fba7401-4390-4afc-815e-40a0b8a41bee */
	public Integer selectByObj(PersonBean rents);
   /** @param rents
    * @pdOid d79a677e-9622-4b12-b5b2-f5dc953a8003 */
	public void insert(PersonBean rents);
   /** @param perb
    * @pdOid 1a20504e-cde1-4966-85fa-1a74891d946c */
	public void updateCreditById(PersonBean perb);
   /** @param pb
    * @pdOid caba0953-342a-4224-a85e-83db601c4d28 */
	public boolean ChangeInfo(PersonBean pb,int id);
	
	/**
     * 注册包租婆/抢租客
     * @param personVo
     * @throws AccountExistException
     */
    void add(PersonVo personVo) throws AccountExistException;

    /**
     * 根据名字找用户
     * @param name
     * @return
     */
    PersonBean findByName(String name);

}