package com.project.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Test;

import com.project.bean.CarportBean;
import com.project.bean.CompanyRentContractBean;
import com.project.bean.ThirdParkContractBean;
import com.project.dao.ICarportDao;
import com.project.dao.impl.CarPortDaoImpl;

public class LiuYingShuangTestDemo {

	
	@Test
	public void insertCarport(){
		ICarportDao dao=new CarPortDaoImpl();
		CarportBean bean=new CarportBean();
		bean.setAdress("成都市高新区天府软件园a区地下停车场");
		bean.setCarNum("asdf001");
		bean.setStatus("已出租");
		CompanyRentContractBean crc=new CompanyRentContractBean();
		crc.setId(1);
		
		ThirdParkContractBean tcp=new ThirdParkContractBean();
		tcp.setId(1);
		
		
		bean.setCrc(crc);
		bean.setTpc(tcp);
		
		dao.insertCarport(bean);
		
	}
	
	@Test
	public void test2(){
		
		SimpleHash hash=new SimpleHash("md5", "123456", "0000",3);
		String s=hash.toBase64();
		System.out.println(s);
	}
	

	@Test
	public void test21(){
		
		SimpleHash hash=new SimpleHash("md5", "12345678", "18582580168",3);
		String s=hash.toBase64();
		System.out.println(s);
	}
	
	@Test
	public void test4(){
	    //定义数组
        String[] strs={"1","2","3","4"};
       //定义随机组合最多位数
       int size=strs.length;
       eachStr(size,strs);//调用
		
	}
	

   public static void pintStr(int num,String[] strs,String beforeStr,String beforeChar){
       num--;
       for(int i=0;i<strs.length;i++){
           if(strs[i].equals(beforeChar)){
               continue;
           }
           if(num==0){
               System.out.println((beforeStr==null?"":beforeStr)+strs[i]);
           }else{
              pintStr(num,strs,(beforeStr==null?"":beforeStr)+strs[i],strs[i]);
           }
      }
   }
   public static void eachStr(int num,String[] strs){
    while (num>0) {
        pintStr(num, strs, null,null);
           num--;
        }
   }

}
