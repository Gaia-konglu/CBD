package com.project.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class RandomUtil {
	
	public static String getRandom(){
	     Date date=new Date();
	     SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
	        String time = format.format(date);
	        int hashCodeV = UUID.randomUUID().toString().hashCode();
	      //有可能是负数
	        if (hashCodeV < 0) {
	            hashCodeV = -hashCodeV;
	        }
	        // 0 代表前面补充0
	        // 4 代表长度为4
	        // d 代表参数为正数型
	        return time + String.format("%011d", hashCodeV);
	}

}
