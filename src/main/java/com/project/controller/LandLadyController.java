package com.project.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.project.bean.BookInforBean;
import com.project.bean.ComplainBean;
import com.project.bean.OrderBean;
import com.project.bean.PartingSpaceBean;
import com.project.bean.PersonBean;
import com.project.bean.RentInforBean;
import com.project.service.IComplainService;
import com.project.service.ILandLadyService;
import com.project.service.IPersonService;
import com.project.service.ITenantService;
import com.project.util.RandomUtil;
import com.project.util.SendFileUtil;

@Controller
public class LandLadyController {
	@Autowired
	private ILandLadyService serviceL;
	@Autowired
	private ITenantService serviceT;
	//个人信息登录
	@RequestMapping(value = {"/login.do"},method = RequestMethod.POST)
	public String login(Model model,String name,String pwd,Integer roleId,Integer num,HttpServletRequest request){
		//包租婆和抢租客个人信息登录验证
		PersonBean bean = serviceL.login(name, pwd, roleId);
		
		if(bean == null){
			return "jsp/personLogin.jsp";
		}
		
		if(roleId == 1){
			//查看预定车位信息
			request.getSession().setAttribute("person", bean);
			return "redirect:jsp/landLady_front_index.jsp";
		}
		
		if(roleId == 2){
			request.getSession().setAttribute("tenant", bean);
		}
		
		return "redirect:jsp/tenant_front_index2.jsp";
	}
	
	//显示预定车位信息
	@RequiresRoles("包租婆")
	@RequestMapping("showBookInfor.do")
	public @ResponseBody Map<String,Object> showBookInfor(Integer page,HttpServletRequest request){
		
		PersonBean bean = (PersonBean) request.getSession().getAttribute("person");
		List<BookInforBean> list = serviceL.checkBookInfor(bean,page);
		//查询预定信息总页数
		int totalNum = serviceL.findBookInforTotalPage(bean);
		int totalPage;
		if(totalNum%10 == 0){
			totalPage = totalNum/10;
		}else{
			totalPage = (totalNum/10)+1;
		}
		Map<String,Object> maps = new HashMap<String,Object>();
		maps.put("list", list);
		maps.put("totalPage", totalPage);
		maps.put("num", totalNum);
		return maps;
	}
	
	//申请个人车位
	@RequiresRoles("包租婆")
	@RequestMapping(value="addPartingSpace.do",method=RequestMethod.POST)
	public String addPartingSpace(MultipartFile imgFile,PartingSpaceBean parting,HttpServletRequest request,String lnglat){
		//传递产权证复印件文件
		String copy = SendFileUtil.send("img", imgFile, request);
		parting.setCopy(copy);
		String [] l = parting.getLnglat().split("\\,");
		String lng=l[0];
		String lat=l[1];
		System.out.println(lng);
		System.out.println(lat);
		//根据车位产权证查询是否存在同样车位产权
		Boolean re = serviceL.findPropertyNum(parting.getPropertyNum());
		System.out.println(re);
		if(re == true){
			PersonBean bean = (PersonBean) request.getSession().getAttribute("person");
			parting.setPerson(bean);
			parting.setLat(lat);
			parting.setLng(lng);
			serviceL.addPartingSpace(parting);
	
		return "redirect:jsp/landLadyPartShow.jsp";
		}
		
		return "redirect:jsp/GaodeLandLady.jsp";
	}
	
	//显示我的个人车位信息
	@RequiresRoles("包租婆")
	@RequestMapping("showMyPart.do")
	public  @ResponseBody Map<String,Object> showMyPartStatus(Integer page,HttpServletRequest request){
		PersonBean bean = (PersonBean) request.getSession().getAttribute("person");
		System.out.println(page);
		List<PartingSpaceBean> part = serviceL.findMyPartInfor(bean,page);
		//查询预定信息总条数
		int totalNum = serviceL.findMyPartTotal(bean);
		int totalPage;
		if(totalNum%10 == 0){
			totalPage = totalNum/10;
			}else{
			totalPage = (totalNum/10)+1;
		}
		Map<String,Object> maps = new HashMap<String,Object>();
		maps.put("list", part);
		maps.put("totalPage", totalPage);
		maps.put("num", totalNum);
		return maps;
	}
	
	//删除个人车位
	@RequiresRoles("包租婆")
	@RequestMapping("deletePart.do")
	public @ResponseBody String deletePart(Integer pid){
		System.out.println(pid);
//		Integer pids = Integer.parseInt(pid);
		serviceL.deletePart(pid);
		return "success";
	
	}
	
	//车位发布
	@RequiresRoles("包租婆")
	@RequestMapping("publishRentInfor.do")
	public String publishRentInfor(Model model,HttpServletRequest request){
		PersonBean bean = (PersonBean) request.getSession().getAttribute("person");
		
		List<PartingSpaceBean> part = serviceL.findMyPartInfor(bean,1);
		
		model.addAttribute("list",part);
		return "jsp/publishRentInfor.jsp";
	}

		

	//发布招租信息
	@RequiresRoles("包租婆")
	@RequestMapping("addRentInfor.do")
	public @ResponseBody String addPartingSpace(Integer pid,String startTime,String endTime,String price){
//		
//		startTime=startTime.replace("T", " ").trim();
//		endTime=endTime.replace("T", " ").trim();
		System.out.println(startTime+":"+endTime);
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			if(dateFormat.parse(startTime).getTime() < dateFormat.parse(endTime).getTime()){
				RentInforBean rent=new RentInforBean();
				//获取车位信息
				PartingSpaceBean part = new PartingSpaceBean();
				part.setId(pid);
				
				rent.setPersonCarSpaceInfor(part);
				rent.setStartTime(startTime);
				rent.setEndTime(endTime);
				rent.setStartTime(startTime);
				Double prices;
				//检验数据有效性
				try {
					 prices=Double.parseDouble(price);
					if(prices>10000) return "over";
				} catch (Exception e) {
					 return "priceError";
				}
				rent.setPrice(prices);
			   serviceL.addRentInfor(rent);
			   return "success";
			}
		} catch (ParseException e1) {
			
			e1.printStackTrace();
			 return "fail";
		}
		
	   return "fail";
	}
	
	//招租信息管理
	@RequiresRoles("包租婆")
	@RequestMapping("showMyRentInfor.do")
	public @ResponseBody Map<String,Object> showMyRentInfor(HttpServletRequest request,Integer page){
		PersonBean bean = (PersonBean) request.getSession().getAttribute("person");
		List<RentInforBean> rents = serviceL.findMyRentInfor(bean,page);
		for (RentInforBean rentInforBean : rents) {
			System.out.println(rentInforBean);
		}
		//查询预定信息总条数
				int totalNum = serviceL.findRentInforTotal(bean);
				int totalPage;
				if(totalNum%10 == 0){
					totalPage = totalNum/10;
					}else{
					totalPage = (totalNum/10)+1;
				}
				Map<String,Object> maps = new HashMap<String,Object>();
				maps.put("list", rents);
				maps.put("totalPage", totalPage);
				maps.put("num", totalNum);
				return maps;
	}
	//招租信息管理-删除
	@RequiresRoles("包租婆")
	@RequestMapping("deleteRentInfor.do")
	public @ResponseBody String deleteRentInfor(Integer id){
		System.out.println(id);
		int flag= serviceL.findRentStatus(id);
		if(flag==1 || flag==2){
			serviceL.deleteRentInfor(id);
			return "success";
		}
		
		return "fail";
		
	}
	
	//修改预定信息状态，显示为可以支付
	@RequiresRoles("包租婆")
	@RequestMapping("updateStatus.do")
	public  String updateStatus(Integer bid,Integer rid){
		BookInforBean book = new BookInforBean();
		book.setId(bid);
		book.setOrder(RandomUtil.getRandom());
		serviceL.updateStatus(book);
		//删除预定信息和相同招租ID的不同预定信息
		//修改招租信息为状态为3，表示已生成订单
		serviceL.updateRentStatus(rid);
		serviceL.deleteBookInfor(rid);
		return "jsp/landLadyBookInfor.jsp";
	}
	
	//查询历史交易记录
	@RequiresRoles("包租婆")
	@RequestMapping("checkTradeInfor.do")
	public @ResponseBody Map<String,Object> checkTradeInfor(HttpServletRequest request,Integer page){
		PersonBean bean = (PersonBean) request.getSession().getAttribute("person");
		List<OrderBean> order = serviceL.checkTradeInfor(bean,page);
		
		for (OrderBean orderBean : order) {
			if(orderBean.getcStatus()==null){
				orderBean.setcStatus(0);
			}
		}
		//查询预定信息总条数
		int totalNum = serviceL.findTradeInforTotalPage(bean);
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
