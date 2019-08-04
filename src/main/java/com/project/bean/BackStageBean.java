/***********************************************************************
 * Module:  BackStageBean.java
 * Author:  TQ
 * Purpose: Defines the Class BackStageBean
 ***********************************************************************/
package com.project.bean;
import java.util.*;

import javax.validation.constraints.Pattern;

/** @pdOid 350c3851-62f1-4c17-a761-9cee797fc80e */
public class BackStageBean {
   /** @pdOid 34df2729-8b00-4937-b9ea-6be6c368d552 */
   private int id;
 //  @NotEmpty(message="工号不能为空")
 @Pattern(regexp="^[0-9]{4}$",message="工号为4位数字")
   private String num;
  
//  @NotEmpty(message="密码不能为空")
 @Pattern(regexp="^[0-9]{6,15}$",message="密码为6-15位数字")
   private String pass;
 // @NotEmpty(message="姓名不能为空")
 @Pattern(regexp="^[\u4e00-\u9fa5]{2,6}$",message="姓名为2-6个汉字")
   private String name;
  @Pattern(regexp="^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0-9]))\\d{8}$",message="电话号码格式错误")
   private String phone;
   /** @pdOid 9a153a34-5a7e-4f2e-a65c-2cc1ed54d005 */
   private String user_authority;
   /** @pdOid 627d99e2-1b0e-48a5-a065-d3ed88c42de1 */
   private String car_authority;
   /** @pdOid 7235264c-da16-4d67-b9a3-1400b976cec3 */
   private String pact_authority;
   /** @pdOid 5a845200-b599-4c67-916e-bc5cc93fe4ba */
   private String complain_authority;
   /** @pdOid 8ad7bee0-c99e-4b1b-9564-e384aa3e1fde */
   private String admin_authority;
   
   public String getAdmin_authority() {
	   if(admin_authority==null){
		   
		   admin_authority="1";
	   }
	   
	return admin_authority;
}

public void setAdmin_authority(String admin_authority) {
	this.admin_authority = admin_authority;
}
private RoleBean role;
   
   //用于存储权限列表
   private List<String> permissons=new ArrayList<String>();
   
   public List<String> getPlist(){
	   
	   permissons.add(user_authority);
	   permissons.add(car_authority);
	   permissons.add(pact_authority);
	   permissons.add(complain_authority);
	   permissons.add(getAdmin_authority());
	   
	return permissons;
	   
   }
   
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNum() {
	return num;
}
public void setNum(String num) {
	this.num = num;
}
public String getPass() {
	return pass;
}
public void setPass(String pass) {
	this.pass = pass;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getUser_authority() {
	return user_authority;
}
public void setUser_authority(String user_authority) {
	this.user_authority = user_authority;
}
public String getCar_authority() {
	return car_authority;
}
public void setCar_authority(String car_authority) {
	this.car_authority = car_authority;
}
public String getPact_authority() {
	return pact_authority;
}
public void setPact_authority(String pact_authority) {
	this.pact_authority = pact_authority;
}
public String getComplain_authority() {
	return complain_authority;
}
public void setComplain_authority(String complain_authority) {
	this.complain_authority = complain_authority;
}
public RoleBean getRole() {
	return role;
}
public void setRole(RoleBean role) {
	this.role = role;
}

   
}