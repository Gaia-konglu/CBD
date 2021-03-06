package com.project.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.project.bean.BookInforBean;
import com.project.bean.PersonBean;
import com.project.bean.RentInforBean;
import com.project.bean.OrderBean;
import com.project.service.ILandLadyService;
import com.project.service.ITenantService;

@Controller
public class TenantController {
	@Autowired
	private ITenantService service;
	
	//抢租客首页显示招租信息,并根据时间查询招租信息
	@RequiresRoles("抢租客")
	@RequestMapping("showAllRentInfor.do")
	public @ResponseBody Map<String,Object> showAllRentInfor(String region,Integer page,String startTime,String endTime){
		if(startTime==null){
			startTime="";
		}
	
		if(endTime==null){
			endTime="";
		}
		if(region==null)region="";
		
		Map<String,Object> maps = new HashMap<String,Object>();
		System.out.println(page+":"+startTime+":"+endTime+":"+region);
		RentInforBean rent = new RentInforBean();
		rent.setStartTime(startTime);
		rent.setEndTime(endTime);	
		rent.setRegion(region);
		List<RentInforBean> rents = service.checkAllRentInfor(rent,page);
		for (RentInforBean rentInforBean : rents) {
			System.out.println(rentInforBean);
		}
		int totalNum = service.findTotalPages(rent);
		int totalPage;
		if(totalNum%10 == 0){
			totalPage = totalNum/10;
		}else{
			totalPage = (totalNum/10)+1;
		}
		
		maps.put("list", rents);
		maps.put("totalPage", totalPage);
		maps.put("num", totalNum);
		return maps;
	}
	//高德地图显示招租信息
	@RequiresRoles("抢租客")
	@RequestMapping("showGaodeInfor.do")
	public @ResponseBody Map<String,Object> showGaodeInfor(Model model,String keyword,String startTime,String endTime){
		if(startTime==null){
			startTime="";
		}else{
			startTime=startTime.replace("T", " ").trim();
		}
		if(endTime==null){
			endTime="";
		}else{
			endTime=endTime.replace("T", " ").trim();
		}
		if(keyword==null)keyword="";
		
		Map<String,Object> maps = new HashMap<String,Object>();
		System.out.println(startTime+":"+endTime+":"+keyword);
		RentInforBean rent = new RentInforBean();
		rent.setStartTime(startTime);
		rent.setEndTime(endTime);	
		rent.setRegion(keyword);
		
		List<RentInforBean> rents = service.checkGaodeInfor(rent);
		for (RentInforBean rentInforBean : rents) {
			System.out.println(rentInforBean);
		}
//		model.addAttribute("list",rents);
		maps.put("list", rents);
//		return "jsp/GaodeTenant.jsp";
		return maps;
	}
	
	//添加预定信息,同时删除招租信息
	@RequiresRoles("抢租客")
	@RequestMapping("addBookInfor.do")
	public @ResponseBody String addBookInfor(Integer rid,String message,HttpServletRequest request){
		//获取抢租客对象
		PersonBean tenant = (PersonBean) request.getSession().getAttribute("tenant");
		//获取包租婆对象
		int id  = service.findLandLadyId(rid);
		PersonBean landLady = new PersonBean();
		landLady.setId(id);
		//获取招租信息对象
		RentInforBean rents = new RentInforBean();
		rents.setId(rid);
		service.addBookInfor(rents, tenant,landLady, message);
		service.deleteRentInfor(rents);
		return "success";
	}
	
	//查询可支付的预定信息
	@RequiresRoles("抢租客")
	@RequestMapping("checkPayBook.do")
	public String checkPayBookInfor(Model model,HttpServletRequest request){
		PersonBean tenant = (PersonBean) request.getSession().getAttribute("tenant");
		
		List<BookInforBean> list = service.checkPayBookInfor(tenant.getId());
		for (BookInforBean bookInforBean : list) {
			System.out.println(bookInforBean);
		}
		model.addAttribute("list",list);
		
		return "jsp/tenantPayBookInfor.jsp";
			
	}
	//添加交易记录
	@RequiresRoles("抢租客")
	@RequestMapping("addTradeInfor.do")
	public String addTradeInfor(HttpServletRequest request){
		
//		System.out.println("订单号:"+outTradeNo);
//		System.out.println("交易单号:"+tradeNo);
//		System.out.println("交易时间:"+timeStamp);
		//查找完成交易的预定信息
		BookInforBean book = service.findBookInforByTradeOder(request.getSession().getAttribute("out_trade_no").toString());
		OrderBean order = new OrderBean();
		order.setTradeOrder(request.getSession().getAttribute("trade_no").toString());
		order.setLid(book.getLid());
		order.setRid(book.getRid());
		order.setTid(book.getTid());
		order.setTradeTime(request.getSession().getAttribute("timestamp").toString());
		//添加交易记录
		service.addTradeInfor(order);
		request.getSession().setAttribute("tenant", book.getTenant());
		service.deletePayBookInfor(book);
		return "redirect:/jsp/tenant_front_index2.jsp";
	}
	
	//删除可支付的预定信息
	@RequiresRoles("抢租客")
	@RequestMapping("deletePayBooKInfor.do")
	public @ResponseBody String deletePayBookInfor(Integer bookId){
		System.out.println(bookId);
		BookInforBean book = new BookInforBean();
		book.setId(bookId);
		service.deletePayBookInfor(book);
		return "success";
	}
	
	//查询历史交易信息
	@RequiresRoles("抢租客")
	@RequestMapping("checkTenantTradeInfor.do")
	public @ResponseBody Map<String,Object> checkTradeInfor(HttpServletRequest request,Integer page){
		PersonBean bean = (PersonBean) request.getSession().getAttribute("tenant");
		List<OrderBean> order = service.checkTradeInfor(bean,page);
		for (OrderBean orderBean : order) {
			if(orderBean.getcStatus()==null){
				orderBean.setcStatus(0);
			}
		}
		//查询预定信息总条数
		int totalNum = service.findTradeInforTotal(bean);
		int totalPage;
		if(totalNum%10 == 0){
			totalPage = totalNum/10;
			}else{
			totalPage = (totalNum/10)+1;
		}
		Map<String,Object> maps = new HashMap<String,Object>();
		maps.put("list", order);
		maps.put("totalPage", totalPage);
		maps.put("num", totalNum);
		return maps;
	}
	
}
