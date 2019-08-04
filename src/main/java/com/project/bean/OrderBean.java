/***********************************************************************
 * Module:  OrderBean.java
 * Author:  TQ
 * Purpose: Defines the Class OrderBean
 ***********************************************************************/
package com.project.bean;
import java.util.*;


public class OrderBean {
   
   private String id;
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
   private String tradeOrder;
   private ComplainBean complain;
   private Integer cStatus;
   
   
   
public Integer getcStatus() {
	return cStatus;
}
public void setcStatus(Integer cStatus) {
	this.cStatus = cStatus;
}
@Override
public String toString() {
	return "OrderBean [id=" + id + ", rentInfor=" + rentInfor + ", landLady=" + landLady + ", tenant=" + tenant
			+ ", tradeTime=" + tradeTime + ", partingSpace=" + partingSpace + ", lid=" + lid + ", rid=" + rid + ", tid="
			+ tid + ", tradeOrder=" + tradeOrder + ", complain=" + complain + "]";
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
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
	this.tradeTime = tradeTime;
}
public PartingSpaceBean getPartingSpace() {
	return partingSpace;
}
public void setPartingSpace(PartingSpaceBean partingSpace) {
	this.partingSpace = partingSpace;
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
public String getTradeOrder() {
	return tradeOrder;
}
public void setTradeOrder(String tradeOrder) {
	this.tradeOrder = tradeOrder;
}
public ComplainBean getComplain() {
	return complain;
}
public void setComplain(ComplainBean complain) {
	this.complain = complain;
}
   




}