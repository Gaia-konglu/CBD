/***********************************************************************
 * Module:  CompanyRentContractBean.java
 * Author:  TQ
 * Purpose: Defines the Class CompanyRentContractBean
 ***********************************************************************/
package com.project.bean;
import java.util.*;

import org.hibernate.validator.constraints.NotEmpty;




   /** @pdOid c32a77b9-3d96-4135-8c61-424c5a69df15 */
   public class CompanyRentContractBean {
   /** @pdOid c07dc7f7-ae32-43c3-836f-0d6fe9e3ad00 */
   private int id;
   /** @pdOid 93e79255-7ab8-4932-a307-7459e180efd0 */
   private String number;
   
   @NotEmpty(message="企业名称不能为空")
   private String company;
   
   /** @pdOid 78126df7-c7d3-4bb6-b49f-df10afe086b2 */
   private java.lang.String contacts;
   /** @pdOid 1db229fd-1009-4456-818b-042dc09b638b */
   private String phone;
   /** @pdOid b9a66dd1-6c70-42b7-8230-1e496c293573 */
   private java.lang.String startTime;
   /** @pdOid a1966346-fefd-4ff1-994a-bfd4ceed428f */
   private java.lang.String endTime;
   /** @pdOid 9d3f324d-ce79-42a1-8729-8113bae8f11c */
   private java.lang.String copy;
   /** @pdOid 06f21f34-73dc-422a-9a7b-6c5f9d7bb3c5 */
   private java.lang.String status;
   /** @pdOid 68c1129d-a0ca-4adf-a1ad-125cc3c48f43 */
   private List<String> carNum;
   private int index;
   private String carnumber;
   private String address;
   

public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getCarnumber() {
	return carnumber;
}
public void setCarnumber(String carnumber) {
	this.carnumber = carnumber;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

public String getNumber() {
	return number;
}
public void setNumber(String number) {
	this.number = number;
}
public java.lang.String getCompany() {
	return company;
}
public void setCompany(java.lang.String company) {
	this.company = company;
}
public java.lang.String getContacts() {
	return contacts;
}
public void setContacts(java.lang.String contacts) {
	this.contacts = contacts;
}

public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public java.lang.String getStartTime() {
	return startTime;
}
public void setStartTime(java.lang.String startTime) {
	this.startTime = startTime;
}
public java.lang.String getEndTime() {
	return endTime;
}
public void setEndTime(java.lang.String endTime) {
	this.endTime = endTime;
}
public java.lang.String getCopy() {
	return copy;
}
public void setCopy(java.lang.String copy) {
	this.copy = copy;
}
public java.lang.String getStatus() {
	return status;
}
public void setStatus(java.lang.String status) {
	this.status = status;
}
public List<String> getCarNum() {
	return carNum;
}
public void setCarNum(List<String> carNum) {
	this.carNum = carNum;
}

public int getIndex() {
	return index;
}
public void setIndex(int index) {
	this.index = index;
}
@Override
public String toString() {
	return "CompanyRentContractBean [id=" + id + ", number=" + number
			+ ", company=" + company + ", contacts=" + contacts + ", phone="
			+ phone + ", startTime=" + startTime + ", endTime=" + endTime
			+ ", copy=" + copy + ", status=" + status + ", carNum=" + carNum
			+ ", index=" + index + ", carnumber=" + carnumber + "]";
}



   
   
   

}