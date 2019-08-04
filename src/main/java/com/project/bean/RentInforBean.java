/***********************************************************************
 * Module:  RentInforBean.java
 * Author:  konglu
 * Purpose: Defines the Class RentInforBean
 ***********************************************************************/
package com.project.bean;

import java.util.List;

import org.omg.CORBA.PERSIST_STORE;

//招租信息类
public class RentInforBean {
   
   private int id;
   private String startTime;
   private String endTime;
   private double price;
   private PartingSpaceBean personCarSpaceInfor;
   
   private PersonBean landLady;
   private String message;
   private int bookId;
   private String bookOrder;
   private int flag;
   private String region;
   
   public String getRegion() {
	return region;
}
public void setRegion(String region) {
	this.region = region;
}
public int getFlag() {
	return flag;
}
public void setFlag(int flag) {
	this.flag = flag;
}
public String getBookOrder() {
	return bookOrder;
}
public void setBookOrder(String bookOrder) {
	this.bookOrder = bookOrder;
}
public PersonBean getLandLady() {
	return landLady;
}
public void setLandLady(PersonBean landLady) {
	this.landLady = landLady;
}
@Override
public String toString() {
	return "RentInforBean [id=" + id + ", startTime=" + startTime + ", endTime=" + endTime + ", price=" + price
			+ ", personCarSpaceInfor=" + personCarSpaceInfor + ", landLady=" + landLady + ", message=" + message
			+ ", bookId=" + bookId + ", bookOrder=" + bookOrder + ", flag=" + flag + "]";
}
public int getBookId() {
	return bookId;
}
public void setBookId(int bookId) {
	this.bookId = bookId;
}

public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}

public PartingSpaceBean getPersonCarSpaceInfor() {
	return personCarSpaceInfor;
}
public void setPersonCarSpaceInfor(PartingSpaceBean personCarSpaceInfor) {
	this.personCarSpaceInfor = personCarSpaceInfor;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getStartTime() {
	return startTime;
}
public void setStartTime(String startTime) {
	this.startTime = startTime;
}
public String getEndTime() {
	return endTime;
}
public void setEndTime(String endTime) {
	this.endTime = endTime;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}

}