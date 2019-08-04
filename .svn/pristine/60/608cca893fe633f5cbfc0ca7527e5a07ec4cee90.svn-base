package com.project.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.bean.BackStageBean;
import com.project.service.IBackService;

//修改后台管理员密码电话号码
@Controller
public class BackgroundAction {

	@Autowired
	private IBackService service;
	
	@RequestMapping("/updateBack.do")
	public void updateBack(BackStageBean bsb, HttpSession httpsession, 
			HttpServletRequest request, HttpServletResponse response){
		
		/*httpsession.setAttribute("id", 1);
		int id = (int) httpsession.getAttribute("id");*/
		
		//取管理员登录时存在session中的id
		BackStageBean bean = (BackStageBean) httpsession.getAttribute("BackStageBean");
		int id = bean.getId();
		
		String num = bean.getNum();
		SimpleHash hash=new SimpleHash("md5", bsb.getPass(), num, 3);
		String hashPass=hash.toBase64();
		 
		System.out.println(bsb.getPhone());
		System.out.println(bsb.getPass());
		System.out.println("MD5后的pass="+hashPass);
		bsb.setId(id);
		bsb.setPass(hashPass);
		
		Map map = service.ChangeInfo(bsb);
		//将BackStageBean bsb 里面的值，存在map中用作数据回显示
		map.put("BackStageBean", bsb);
		
		request.setAttribute("map", map);
		
			
		System.out.println("BackgroundAction里");
		
		
	//	return "redirect:/jsp/success.jsp";
		try {
			request.getRequestDispatcher("jsp/BackgroundAlter.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}     
	}
	
	@RequestMapping("/showAllBack.do")
	public String showBack(HttpSession httpsession){
		List<BackStageBean> list=service.selectAll();
		httpsession.setAttribute("backs", list);
		return "redirect:/jsp/SuperBack.jsp";
	}
}
