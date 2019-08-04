package com.project.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.project.bean.CarportBean;
import com.project.bean.CompanyRentContractBean;
import com.project.bean.ThirdParkContractBean;
import com.project.service.IThirdParkContractService;

@Controller
public class ThirdParkContractController {
	@Autowired
	private IThirdParkContractService service=null;
	
	//查询所有企业租赁合同
		@RequestMapping("/selectThirdContract.do")
	    public @ResponseBody Map<String,Object> findall(@RequestBody String page){
			List<ThirdParkContractBean> list=new ArrayList<ThirdParkContractBean>();
			int ppage=1;
			try{
				ppage=Integer.parseInt(page);
			}catch(Exception e){
			}
			list=service.findallThirdRentContract(ppage);
			int totalpage=service.findcountThirdParkContract();
			//比较时间判定合同状态
			 ThirdParkContractBean bean=new ThirdParkContractBean();
			    for(int i=0;i<list.size();i++){
			    	bean=list.get(i);
			    	
			    	String endtime=bean.getEndTime();
					SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
					String sendTime = sf.format(new Date());
					
					Date date1=null;
					try {
						date1 = sf.parse(endtime);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Date date2=null;
					try {
						date2 = sf.parse(sendTime);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					int a = (int) ((date1.getTime() - date2.getTime()) / (1000*3600*24));
					
					
					
					if(a>=0 && a<5){
						bean.setStatus("即将到期");
					    service.changeThirdParkContractStatus(bean);
						
					}
					if(a<0){
						bean.setStatus("已过期");
						service.changeThirdParkContractStatus(bean);
						
					}
					if(a>5){
						if(bean.getStatus().equals("即将到期") || bean.getStatus().equals("已过期")){
						bean.setStatus("状态正常");
						service.changeThirdParkContractStatus(bean);
						}
					}
			    }
			
			Map<String,Object> map=new HashMap<String,Object>();
			
			map.put("thirdparkcontract", list);
			map.put("totalpage", totalpage);
			
			return map;
		}
		
		@RequestMapping("/changethirdcontractpage.do")
		public String change(HttpServletRequest req,HttpSession session){
			String i=req.getParameter("contractid");
			session.setAttribute("contractid", i);
			System.out.println("获取到的合同id为"+i);
			return "redirect:/jsp/thirdparkcarport.jsp";
		}
		//查看合同对应车位信息
		@RequestMapping(value={"/ThirdParkContract.do"},method=RequestMethod.POST)
		public @ResponseBody Map<String,Object> detail(@RequestBody String page,HttpSession session){
			String id=(String) session.getAttribute("contractid");
			System.out.println("当前合同编号"+id);
			ThirdParkContractBean bean=new ThirdParkContractBean();
			int cid=1;
			try{
				cid=Integer.parseInt(id);
			}catch(Exception e){
			}
			//设置bean当前合同id
			bean.setId(cid);
			//设置bean合同index
			
			int ppage=1;
			try{
				ppage=Integer.parseInt(page);
			}catch(Exception e){
			}
			int index=(ppage-1)*7;
			bean.setIndex(index);
			
			List<CarportBean> list=new ArrayList<CarportBean>();
			list=service.findCarPortByThirdParkContractById(bean);
			int totalpage=service.fingcountCarportThirdPortContractById(cid);
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("thirdcarport", list);
			map.put("totalpage", totalpage);
			System.out.println(list);
			
			return map ;
			
		}
		
		@RequestMapping("/selectthirdparkcontractcopy.do")
		public String copy(HttpServletRequest req,HttpSession session){
			String i=req.getParameter("contractid");
			session.setAttribute("contractid", i);
			System.out.println("获取到的合同id为"+i);
			int id=1;
			try{
				id=Integer.parseInt(i);
			}catch(Exception e){
			}
			String result=service.findthirdparkContractCopyById(id);
			System.out.println("复印件"+result);
			session.setAttribute("img", result);
			return "redirect:/jsp/selectcopy.jsp";
		}
		@RequestMapping("/deletethirdparkcontract.do")
		public String delete(HttpServletRequest req,HttpSession session){
			String i=req.getParameter("contractid");
			session.setAttribute("contractid", i);
			int id=1;
			try{
				id=Integer.parseInt(i);
			}catch(Exception e){
			}
			System.out.println("获取到的合同id为"+i);
			if(service.selectRambid(id)>0){
				return "redirect:/jsp/deletecontractfail.jsp";
			}
			service.deleteThirdRentContract(id);
			service.changeThirdCarportStatus(id);
			return "redirect:/jsp/deletecontractsuccess.jsp";
		}
	
		@RequestMapping("/changeupdatethirdContractpage.do")
		public  String updatepage(HttpServletRequest req,HttpSession session){
			//生成合同编号
			SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddhhMMss");
			String sendTime = sf.format(new Date());
			String num="【停】字"+sendTime;
			session.setAttribute("thirdnum", num);
			
			String i=req.getParameter("contractid");
			session.setAttribute("thirdcontractid", i);
			int id=1;
			try{
				id=Integer.parseInt(i);
			}catch(Exception e){
			}
			String oldnum=service.findthirdnumbyid(id);
			session.setAttribute("companycontractid", id);
			session.setAttribute("oldnums", oldnum);
			
			return "redirect:/jsp/updatethirdparkcontract.jsp";
		}
		//续约第三方合同
		@RequestMapping("/updatethirdparkcontract.do")
		public  String update(HttpServletRequest req,HttpSession session){
			String contacts=(String) req.getParameter("contacts");
			String phone=(String) req.getParameter("phone");
			String starttime= req.getParameter("startDate");
			String endtime = req.getParameter("endDate");
			
			//生成合同编号
			String num=(String) session.getAttribute("thirdnum");	
			//合同id号
			String nid=(String) session.getAttribute("thirdcontractid");
			int id=1;
			try{
				id=Integer.parseInt(nid);
			}catch(Exception e){
			}
			ThirdParkContractBean bean=new ThirdParkContractBean();
			bean.setId(id);
			bean.setNumber(num);
			bean.setContacts(contacts);
			bean.setPhone(phone);
			bean.setStartTime(starttime);
			bean.setEndTime(endtime);
			service.updateThirdRentContract(bean);
			return "redirect:/jsp/uploadupdateThirdcontract.jsp";
		}
		//续约第三方合同跳转页面添加合同复印件
				@RequestMapping("/uploadthirdxueyue.do")
				public  String  uploadthird(MultipartFile imgFile,HttpServletRequest req,HttpSession session){
					
					
					String ids= (String) session.getAttribute("thirdcontractid");
					int id=1;
					try{
						id=Integer.parseInt(ids);
					}catch(Exception e){
					}
					String pathaddress="/CBDParkingManagementSystem/upload/"+imgFile.getOriginalFilename()+"";
					ThirdParkContractBean bean=new ThirdParkContractBean();
					bean.setId(id);
					bean.setCopy(pathaddress);
					service.savethirdparkcopy(bean);
					
					ServletContext context = req.getServletContext();
					String path = context.getRealPath("/upload");
					File f = new File(path);
					if(!f.exists()) f.mkdirs();
					//将文件保存到upload文件夹
					File file = new File(path,imgFile.getOriginalFilename());
					try {
						imgFile.transferTo(file);
					} catch (IllegalStateException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return "/jsp/uploadcontractsucess.jsp";
					
				}
		//添加第三方合同跳转页面添加合同复印件
		@RequestMapping("/uploadthirdparkcontract.do")
		public  String  upload(MultipartFile imgFile,HttpServletRequest req,HttpSession session){
			
			
			int newid=(int) session.getAttribute("thirdparkcontractid");
			String pathaddress="/CBDParkingManagementSystem/upload/"+imgFile.getOriginalFilename()+"";
			ThirdParkContractBean bean=new ThirdParkContractBean();
			bean.setId(newid);
			bean.setCopy(pathaddress);
			service.savethirdparkcopy(bean);
			
			ServletContext context = req.getServletContext();
			String path = context.getRealPath("/upload");
			File f = new File(path);
			if(!f.exists()) f.mkdirs();
			//将文件保存到upload文件夹
			File file = new File(path,imgFile.getOriginalFilename());
			try {
				imgFile.transferTo(file);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "/jsp/addThirdParkContractCarport2.jsp";
			
		}
		
		//生成新合同编号
		@RequestMapping("/newthirdcontractnumber.do")
		public String newbutton(HttpServletRequest req,HttpSession session){
			//生成合同编号
			SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddhhMMss");
			String sendTime = sf.format(new Date());
			String num="【停】字"+sendTime;
			
			
			session.setAttribute("thirdcontractnum", num);
			
			return "redirect:/jsp/addthirdparkcontract.jsp";
			
		}
		//添加第三方合同
		@RequestMapping("/addnewthirdparkcarport.do")
		public String addnewcarport(HttpServletRequest req,HttpSession session){
			//获取到添加的车位编号
			
			String num=(String) session.getAttribute("thirdcontractnum");
			System.out.println("新合同编号"+num);
			String address=req.getParameter("address");
			String company=req.getParameter("company");
			String contacts=req.getParameter("contacts");
			String phone=req.getParameter("phone");
			String startDate=req.getParameter("startDate");
			String endDate=req.getParameter("endDate");
			
			ThirdParkContractBean bean=new ThirdParkContractBean();
			bean.setAddr(address);
			bean.setNumber(num);
			bean.setCompany(company);
			bean.setContacts(contacts);
			bean.setPhone(phone);
			bean.setStartTime(startDate);
			bean.setEndTime(endDate);
			
			
			service.addThirdRentContract(bean);
			
			int thirdparkcontractid=bean.getId();
			session.setAttribute("thirdparkcontractid", thirdparkcontractid);
			return "redirect:/jsp/uploadthierdparkcontractcopy.jsp";
		}

}
