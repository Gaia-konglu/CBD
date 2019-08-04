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
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.project.bean.CarportBean;
import com.project.bean.CompanyRentContractBean;
import com.project.bean.ThirdParkContractBean;
import com.project.bean.UserBean;
import com.project.service.ICompanyRentContractService;

@Controller
public class ContractController {
	
	private static List<CarportBean> list=new ArrayList<CarportBean>();
	
	@Autowired
	private ICompanyRentContractService service=null;
	
	//查询所有企业租赁合同
	@RequestMapping("/selectCompanyContract.do")
    public @ResponseBody Map<String,Object> findall(@RequestBody String page){
		List<CompanyRentContractBean> list=new ArrayList<CompanyRentContractBean>();
		int ppage=1;
		try{
			ppage=Integer.parseInt(page);
		}catch(Exception e){
		}
		list=service.findallCompanyRentContract(ppage);
		
		int totalpage=0;
		int s=service.findCountCompanyContract();
		if(s%7==0){
			totalpage=s/7;
		}
		else{
			totalpage=(s/7+1);
		}
		
		
		//比较时间判定合同状态
		 CompanyRentContractBean bean=new CompanyRentContractBean();
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
//				int a = (int) ((date1.getTime() - date2.getTime()) / (1000*3600*24));
				
				int a=1;
				try{
					a=(int) ((date1.getTime() - date2.getTime()) / (1000*3600*24));
				}catch(Exception e){
				}
				
				
				if(a>=0 && a<5){
					bean.setStatus("即将到期");
				    service.changeCompanyContract(bean);
					
				}
				if(a<0){
					bean.setStatus("已过期");
					service.changeCompanyContract(bean);
					
				}
				if(a>5){
					if(bean.getStatus().equals("即将到期") || bean.getStatus().equals("已过期")){
					bean.setStatus("状态正常");
					service.changeCompanyContract(bean);
					}
				}
		    }
		
		Map<String,Object> map=new HashMap<String,Object>();
		
		map.put("companycontract", list);
		map.put("totalpage", totalpage);
		
		return map;
	}
	
	@RequestMapping(value={"/CompanyContract.do"},method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> detail(@RequestBody String page,HttpSession session){
		String id=(String) session.getAttribute("contractid");
		System.out.println("当前合同编号"+id);
		CompanyRentContractBean bean=new CompanyRentContractBean();
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
		list=service.findCarPortByCompanyContract(bean);
		int totalpage=service.fingcountCarportCompanyRentContractById(cid);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("carport", list);
		map.put("totalpage", totalpage);
		System.out.println(list);
		
		return map ;
		
	}
	
	@RequestMapping("/changepage.do")
	public String change(HttpServletRequest req,HttpSession session){
		String i=req.getParameter("contractid");
		session.setAttribute("contractid", i);
		System.out.println("获取到的合同id为"+i);
		return "redirect:/jsp/ContractCarPort.jsp";
	}
	
	//续约选项方法
	@RequestMapping("/updatepage.do")
	public  String update(HttpServletRequest req,HttpSession session){
		
		
		String contacts=(String) req.getParameter("contacts");
		String phone=(String) req.getParameter("phone");
		
		System.out.println("续约的联系人为："+contacts);
		System.out.println("续约的联系人电话为 "+phone);
		
		String starttime= req.getParameter("startDate");
		String endtime = req.getParameter("endDate");
		
		System.out.println("合同生效及截止日期为："+starttime+"至"+endtime);
		
		//生成合同编号
		String num=(String) session.getAttribute("num");	
		System.out.println("合同编号为"+num);
		
		//生成合同id号
		int id=(int) session.getAttribute("companycontractid");
		
		System.out.println("续约的合同id号"+id);
		
		
		
		CompanyRentContractBean bean=new CompanyRentContractBean();
		bean.setId(id);
		bean.setNumber(num);
		bean.setContacts(contacts);
		bean.setPhone(phone);
		bean.setStartTime(starttime);
		bean.setEndTime(endtime);
		
		
		
		service.updateCompanyRentContract(bean);
		
		return "redirect:/jsp/uploadUpdateContract.jsp";
	}
	
	@RequestMapping("/updateContractpage.do")
	public  String updatepage(HttpServletRequest req,HttpSession session){
		//生成合同编号
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddhhMMss");
		String sendTime = sf.format(new Date());
		String num="【停】字"+sendTime;
		session.setAttribute("num", num);
		
		String i=req.getParameter("contractid");
		int id=1;
		try{
			id=Integer.parseInt(i);
		}catch(Exception e){
		}
		session.setAttribute("companycontractid", id);
		String oldnum=service.findCompanycontractNumByCompanyId(id);
		session.setAttribute("oldnum", oldnum);
		
		
		
		return "redirect:/jsp/updateCompanyRentContract.jsp";
	}
	
	//上传续约文件
	@RequestMapping("/uploadxueyue.do")
	public  String uploads(MultipartFile imgFile,HttpServletRequest req,HttpSession session,HttpServletResponse resp){
		
		//获取上一页面传过来的合同id值
		int id= (int) session.getAttribute("companycontractid");
		
		String pathaddress="/CBDParkingManagementSystem/upload/"+imgFile.getOriginalFilename()+"";
		
		//更改表中复印件路径
		CompanyRentContractBean bean=new CompanyRentContractBean();
		bean.setId(id);
		bean.setCopy(pathaddress);
		service.saveUploadfile(bean);
		
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
		
		return "redirect:/jsp/uploadcontractsucess.jsp";
		
	}
	
	//上传文件
	@RequestMapping("/upload.do")
	public  String upload(MultipartFile imgFile,HttpServletRequest req,HttpSession session,HttpServletResponse resp){
		
		//获取上一页面传过来的合同id值
		int  newid=(int) session.getAttribute("newcopycontractid");
		
		String pathaddress="/CBDParkingManagementSystem/upload/"+imgFile.getOriginalFilename()+"";
		
		//更改表中复印件路径
		CompanyRentContractBean bean=new CompanyRentContractBean();
		bean.setId(newid);
		bean.setCopy(pathaddress);
		service.saveUploadfile(bean);
		
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
		
		return "redirect:/jsp/uploadcontractsucess.jsp";
		
	}
	
	
	@RequestMapping("/selectcopy.do")
	public String copy(HttpServletRequest req,HttpSession session){
		String i=req.getParameter("contractid");
		session.setAttribute("contractid", i);
		System.out.println("获取到的合同id为"+i);
		int id=1;
		try{
			id=Integer.parseInt(i);
		}catch(Exception e){
		}
		String result=service.findCompanyContractCopyById(id);
		System.out.println("复印件"+result);
		session.setAttribute("img", result);
		return "redirect:/jsp/selectcopy.jsp";
	}
	
	
	@RequestMapping("/delete.do")
	public String delete(HttpServletRequest req,HttpSession session){
		String i=req.getParameter("contractid");
		session.setAttribute("contractid", i);
		int id=1;
		try{
			id=Integer.parseInt(i);
		}catch(Exception e){
		}
		System.out.println("获取到的合同id为"+i);
		service.deleteCompanyRentContract(id);
		service.changeSstatusTer(id);
		return "redirect:/jsp/deletecontractsuccess.jsp";
	}
	
	@RequestMapping("/addcompanycontractcarport.do")
	public @ResponseBody Map<String,Object> addcompanycontractcarport(@RequestBody String adress,HttpServletResponse response){
		
		StringBuffer buf = new StringBuffer(adress);
		buf.delete(0,11); 
		buf.delete(buf.length()-2, buf.length());
		
		String res=""+buf;

		Map<String,Object> map = new HashMap<String, Object>();
		List<CarportBean> list=service.findcarnumByaddressCompany(res);
		System.out.println("获取到的车位地址信息为:"+res);
		System.out.println("查询到的车位编号为"+list);
		map.put("carnum", list);
		
		return map;
		
	}
	

	
	//打开添加合同页面自动搜索地址信息显示在地址选择栏
	@RequestMapping("/newcarport.do")
	public @ResponseBody Map<String,Object> newcarport(HttpServletRequest req,HttpSession session){
		List<CarportBean> lists=service.findalladdresscompany();
		
		List<CarportBean> listom=new ArrayList<CarportBean>();
		session.setAttribute("addcarports",listom);
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("newcarports", lists);
		return map;
	}
	
	
	
	
	
	//添加合同信息
	@RequestMapping("/addnewcarport.do")
	public String addnewcarport(HttpServletRequest req,HttpSession session){
		//获取到添加的车位编号
		List<CarportBean> li=new ArrayList<CarportBean>();
		li=(List<CarportBean>) session.getAttribute("addcarports");
		String num=req.getParameter("newcontractnumbers");
		String company=req.getParameter("company");
		String contacts=req.getParameter("contacts");
		String phone=req.getParameter("phone");
		String startDate=req.getParameter("startDate");
		String endDate=req.getParameter("endDate");
		
		
	
		
		
		CompanyRentContractBean bean=new CompanyRentContractBean();
		bean.setNumber(num);
		bean.setCompany(company);
		bean.setContacts(contacts);
		bean.setPhone(phone);
		bean.setStartTime(startDate);
		bean.setEndTime(endDate);
		
		
		service.addCompanyRentContract(bean);
		session.setAttribute("newcopycontractid", bean.getId());
		
		for(int i=0;i<li.size();i++){
			String nums=li.get(i).getCarNum();
			int id=bean.getId();
			String address=li.get(i).getAdress();
			String carnumber=li.get(i).getCarNum();
			
			//更改车位表中信息，添加合同号
			CompanyRentContractBean beans=new CompanyRentContractBean();
			beans.setId(id);
			beans.setAddress(address);
			beans.setCarnumber(carnumber);
			service.insertCarportByCompanyRentContract(beans);
		}

		list.clear();
		return "redirect:/jsp/uploadContract.jsp";
	}
	
	//添加合同时页面框内显示合同中车位编号
		@RequestMapping("/selectnewcarport.do")
		public @ResponseBody Map<String,Object> selectnewcarport(@RequestBody CarportBean car,String number,
				HttpServletRequest req,HttpSession session){
            
			List<CarportBean> listom=new ArrayList<CarportBean>();
			listom=(List<CarportBean>) session.getAttribute("addcarports");
			
			String address=car.getAdress();
			String carnum=car.getCarNum();
			
			if(!carnum.equals("----请--选--择----")){
			CarportBean bean=new CarportBean();
			bean.setAdress(address);
			bean.setCarNum(carnum);
			listom.add(bean);
			//将选取的车位编号存入
			session.setAttribute("addcarports", listom);
			}
			
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("newcarport", listom);
			map.put("backerror", "已选择车位");
			return map;
		}
	
		@RequestMapping("/deletenewcarport.do")
        public @ResponseBody Map<String,Object> deletecar(@RequestBody String i,HttpSession session,HttpServletRequest req){
			List<CarportBean> li=new ArrayList<CarportBean>();
			li=(List<CarportBean>) session.getAttribute("addcarports");
			System.out.println("要删除的值"+li);
			int id=1;
			try{
				id=Integer.parseInt(i);
			}catch(Exception e){
			}
			li.remove(id);
			session.setAttribute("addcarports", li);
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("newcarportnum", li);
			if(li.size()==0){
				map.put("backerror", "[]");
			}
			return map;
		}


		
		//生成新合同编号
				@RequestMapping("/newcontractnumber.do")
				public String newbutton(HttpServletRequest req,HttpSession session){
					//生成合同编号
					SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddhhMMss");
					String sendTime = sf.format(new Date());
					String num="【停】字"+sendTime;
					
					
					session.setAttribute("contractnum", num);
					
					
					return "redirect:/jsp/addCompanyRentContract.jsp";
					
				}
				
				//状态筛选至新的页面
				@RequestMapping("/selectresult.do")
				public String statusresult(HttpServletRequest req,HttpSession session){
					String status=req.getParameter("FirstCate");
					session.setAttribute("statusResult", status);
					
					return "redirect:/jsp/CompanyRentContractStatus.jsp";
				}
				//删除页面状态筛选至新的页面
				@RequestMapping("/deleteselectresult.do")
				public String statusresultdelete(HttpServletRequest req,HttpSession session){
					String status=req.getParameter("FirstCate");
					session.setAttribute("statusResult", status);
					
					return "redirect:/jsp/terminateCompanyContractByStatus.jsp";
				}
				//模糊查询企业名称至新的页面
				@RequestMapping("/selectresultByname.do")
				public String statusresultbyname(HttpServletRequest req,HttpSession session){
					String companyname=req.getParameter("companyname");
					session.setAttribute("statusResultByname", companyname);
					
					return "redirect:/jsp/CompanyRentContractByName.jsp";
				}
				//删除时模糊查询企业名称至新的页面
				@RequestMapping("/deleteresultByname.do")
				public String deleteresultbyname(HttpServletRequest req,HttpSession session){
					String companyname=req.getParameter("companyname");
					session.setAttribute("statusResultByname", companyname);
					
					return "redirect:/jsp/terminatecompanycontractByname.jsp";
				}
				
				//筛选合同状态后的所有合同
				@RequestMapping("/selectCompanyContractByStatus.do")
			    public @ResponseBody Map<String,Object> findallresult(@RequestBody String page,HttpSession session){
					List<CompanyRentContractBean> list=new ArrayList<CompanyRentContractBean>();
					int ppage=1;
					try{
						ppage=Integer.parseInt(page);
					}catch(Exception e){
					}
					CompanyRentContractBean bean=new CompanyRentContractBean();
					int index=(ppage-1)*7;
					bean.setIndex(index);
					String status=(String) session.getAttribute("statusResult");
					bean.setStatus(status);
					list=service.findallresultcontract(bean);
					
					int totalpage=0;
					int s=service.findresultcountBystatus(status);
					if(s%7==0){
						totalpage=s/7;
					}
					else{
						totalpage=(s/7+1);
					}
					
					
					//比较时间判定合同状态
					 CompanyRentContractBean beans=new CompanyRentContractBean();
					    for(int i=0;i<list.size();i++){
					    	beans=list.get(i);
					    	
					    	String endtime=beans.getEndTime();
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
//							int a = (int) ((date1.getTime() - date2.getTime()) / (1000*3600*24));
							
							int a=1;
							try{
								a=(int) ((date1.getTime() - date2.getTime()) / (1000*3600*24));
							}catch(Exception e){
							}
							
							
							if(a>=0 && a<5){
								beans.setStatus("即将到期");
							    service.changeCompanyContract(beans);
								
							}
							if(a<0){
								beans.setStatus("已过期");
								service.changeCompanyContract(beans);
								
							}
							if(a>5){
								if(beans.getStatus().equals("即将到期") || beans.getStatus().equals("已过期")){
								beans.setStatus("状态正常");
								service.changeCompanyContract(beans);
								}
							}
					    }
					
					Map<String,Object> map=new HashMap<String,Object>();
					
					map.put("companycontract", list);
					map.put("totalpage", totalpage);
					
					return map;
				}
				
				//查询企业名称后的所有合同
				@RequestMapping("/selectCompanyContractByname.do")
			    public @ResponseBody Map<String,Object> findallresultByname(@RequestBody String page,HttpSession session){
					List<CompanyRentContractBean> list=new ArrayList<CompanyRentContractBean>();
					int ppage=1;
					try{
						ppage=Integer.parseInt(page);
					}catch(Exception e){
					}
					CompanyRentContractBean bean=new CompanyRentContractBean();
					int index=(ppage-1)*7;
					bean.setIndex(index);
					String name=(String) session.getAttribute("statusResultByname");
					String a="%"+name+"%";
					
					bean.setCompany(a);
					list=service.findallresultcontractByName(bean);
					
					 
					int totalpage=0;
					int s=service.findcountallresultcontractByName(a);
					if(s%7==0){
						totalpage=s/7;
					}
					else{
						totalpage=(s/7+1);
					}
					
					
					//比较时间判定合同状态
					 CompanyRentContractBean beans=new CompanyRentContractBean();
					    for(int i=0;i<list.size();i++){
					    	beans=list.get(i);
					    	
					    	String endtime=beans.getEndTime();
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
//							int a = (int) ((date1.getTime() - date2.getTime()) / (1000*3600*24));
							
							int b=1;
							try{
								b=(int) ((date1.getTime() - date2.getTime()) / (1000*3600*24));
							}catch(Exception e){
							}
							
							
							if(b>=0 && b<5){
								beans.setStatus("即将到期");
							    service.changeCompanyContract(beans);
								
							}
							if(b<0){
								beans.setStatus("已过期");
								service.changeCompanyContract(beans);
								
							}
							if(b>5){
								if(beans.getStatus().equals("即将到期") || beans.getStatus().equals("已过期")){
								beans.setStatus("状态正常");
								service.changeCompanyContract(beans);
								}
							}
					    }
					
					Map<String,Object> map=new HashMap<String,Object>();
					
					map.put("companycontract", list);
					map.put("totalpage", totalpage);
					
					return map;
				}
				
				
				
				
			

		
		
		
	
	
	
	
	
	
}
