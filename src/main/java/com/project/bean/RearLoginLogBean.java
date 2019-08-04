/***********************************************************************
 * Module:  RearLoginLogBean.java
 * Author:  TQ
 * Purpose: Defines the Class RearLoginLogBean
 ***********************************************************************/
package com.project.bean;
import java.util.*;

/** @pdOid b74351e3-70c2-4dfc-ba04-39ce35010cda */
public class RearLoginLogBean {
   /** @pdOid af51363b-5c57-4d83-990d-2ed2511a586b */
   private int id;
   /** @pdOid cf2bf96d-2b3d-442e-ace1-53419d21910b */
   private String name;
   /** @pdOid b9acff93-22b9-484f-807f-363e6ae77092 */
   private String time;
   /** @pdOid cccd245b-8035-4d37-b3c1-0e4be6634242 */
   private String addr;
   
   private int flag;

   
public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getTime() {
	return time;
}

public void setTime(String time) {
	this.time = time;
}

public String getAddr() {
	return addr;
}

public void setAddr(String addr) {
	this.addr = addr;
}

public int getFlag() {
	return flag;
}

public void setFlag(int flag) {
	this.flag = flag;
}

@Override
public String toString() {
	return "RearLoginLogBean [id=" + id + ", name=" + name + ", time=" + time + ", addr=" + addr + ", flag=" + flag
			+ "]";
}
   

}