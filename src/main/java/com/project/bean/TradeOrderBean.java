/***********************************************************************
 * Module:  OrderBean.java
 * Author:  TQ
 * Purpose: Defines the Class OrderBean
 ***********************************************************************/
package com.project.bean;
import java.util.*;


public class TradeOrderBean {
   
   private int id;
   private RentInforBean rentInfor;
   //招租婆
   private PersonBean landLady;
   //抢租客
   private PersonBean tenant;
   private String tradeTime;
   private PartingSpaceBean partingSpace;
   private int lid;
   private int rid;
   private int tid;
   
   public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getLid() {
	return lid;
}
public void setLid(int lid) {
	this.lid = lid;
}
public int getRid() {
	return rid;
}
public void setRid(int rid) {
	this.rid = rid;
}
public int getTid() {
	return tid;
}
public void setTid(int tid) {
	this.tid = tid;
}
@Override
public String toString() {
	return "TradeOrderBean [id=" + id + ", rentInfor=" + rentInfor + ", landLady=" + landLady + ", tenant=" + tenant
			+ ", tradeTime=" + tradeTime + ", partingSpace=" + partingSpace + ", lid=" + lid + ", rid=" + rid + ", tid="
			+ tid + "]";
}

public RentInforBean getRentInfor() {
	return rentInfor;
}
public void setRentInfor(RentInforBean rentInfor) {
	this.rentInfor = rentInfor;
}
public PersonBean getLandLady() {
	return landLady;
}
public void setLandLady(PersonBean landLady) {
	this.landLady = landLady;
}
public PersonBean getTenant() {
	return tenant;
}
public void setTenant(PersonBean tenant) {
	this.tenant = tenant;
}
public String getTradeTime() {
	return tradeTime;
}
public void setTradeTime(String tradeTime) {
	tradeTime = tradeTime;
}
public PartingSpaceBean getPartingSpace() {
	return partingSpace;
}
public void setPartingSpace(PartingSpaceBean partingSpace) {
	this.partingSpace = partingSpace;
}



}