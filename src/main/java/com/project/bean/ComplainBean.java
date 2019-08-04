/***********************************************************************
 * Module:  ComplainBean.java
 * Author:  Administrator
 * Purpose: Defines the Class ComplainBean
 ***********************************************************************/
package com.project.bean;
import java.util.*;


public class ComplainBean {
   
   private int id;
  
   private Date complainTime;

   private String complainContent;
  
   private String status;
  
   private String returnContent;
  
   private PersonBean person=new PersonBean();
   
   private PersonBean person2=new PersonBean();
  
   private BackStageBean bsb=new BackStageBean();
  
   private OrderBean order=new OrderBean();
   
   private String time;
   private Integer cpStatus;
   
   

public Integer getCpStatus() {
	return cpStatus;
}
public void setCpStatus(Integer cpStatus) {
	this.cpStatus = cpStatus;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Date getComplainTime() {
	return complainTime;
}
public void setComplainTime(Date complainTime) {
	this.complainTime = complainTime;
}
public String getComplainContent() {
	return complainContent;
}
public void setComplainContent(String complainContent) {
	this.complainContent = complainContent;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getReturnContent() {
	return returnContent;
}
public void setReturnContent(String returnContent) {
	this.returnContent = returnContent;
}
public PersonBean getPerson() {
	return person;
}
public void setPerson(PersonBean person) {
	this.person = person;
}
public PersonBean getPerson2() {
	return person2;
}
public void setPerson2(PersonBean person2) {
	this.person2 = person2;
}
public BackStageBean getBsb() {
	return bsb;
}
public void setBsb(BackStageBean bsb) {
	this.bsb = bsb;
}
public OrderBean getOrder() {
	return order;
}
public void setOrder(OrderBean order) {
	this.order = order;
}
@Override
public String toString() {
	return "ComplainBean [id=" + id + ", complainTime=" + complainTime + ", complainContent=" + complainContent
			+ ", status=" + status + ", returnContent=" + returnContent + ", person=" + person + ", person2=" + person2
			+ ", bsb=" + bsb + ", order=" + order + "]";
}
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}
   

}