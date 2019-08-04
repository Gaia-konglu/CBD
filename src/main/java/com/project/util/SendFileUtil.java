package com.project.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class SendFileUtil {
	
public static String send(String dir,MultipartFile imgFile,HttpServletRequest request){
		
		String img = changeName(imgFile.getOriginalFilename());
		
		ServletContext context = request.getServletContext();
		String path = context.getRealPath("/"+dir);
		
		File f = new File(path);
		if(!f.exists()) f.mkdir();
		
		//将文件保存到img文件夹中
		File file = new File(path,img);
		
		try {
			imgFile.transferTo(file);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return img;
	}

	private static String changeName(String name) {
		String newName = UUID.randomUUID()+"_"+name;
		return newName;
	}

}
