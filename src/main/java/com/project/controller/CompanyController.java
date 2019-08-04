package com.project.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.project.bean.CarportBean;
import com.project.bean.CompanyBean;
import com.project.bean.PersonBean;
import com.project.service.ICompanyService;
import com.project.util.RegularUtil;

@Controller
public class CompanyController {
	
	@Autowired
	private ICompanyService service;
	
	//企业action
	@RequestMapping(value={"/companyLogin.do"},method=RequestMethod.POST)
	public void loginAction(HttpServletRequest request,HttpServletResponse response,String admin){
		System.out.println("进入到了action中");
		System.out.println("admin:"+admin);
		//获取session对象
		HttpSession session = request.getSession();
		CompanyBean companyBean = service.findCompanyNameByAdmin(admin);
		companyBean.setAdmin(admin);
		System.out.println("companyBean:"+companyBean);
		if(!companyBean.getName().equals(null)){
			//将包含企业登录名和企业名称的companyBean存在session中
			session.setAttribute("companyBean",companyBean);
			//进行页面跳转
			/*request.getRequestDispatcher("jsp/companyFront.jsp").forward(request,response);*/
			try {
				response.sendRedirect("jsp/company_front_index.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			try {
				response.sendRedirect("jsp/companyLogin.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	//根据企业名称查询企业已租赁车位
	@RequestMapping("/alreadyRent.do")
	public @ResponseBody Map<String,Object> alreadyRent(
			int page,HttpServletRequest request,
			String addr,String p_number,String b_number,
			String start_time,String end_time){
		
		System.out.println("进入到了alreadyRent方法中");
		System.out.println("page:"+page);
		System.out.println("addr:"+addr);
		System.out.println("p_number:"+p_number);
		System.out.println("b_number:"+b_number);
		System.out.println("start_time:"+start_time);
		System.out.println("end_time:"+end_time);
		
		//进行模糊查询
		
		System.out.println("进入到controller企业已租赁模糊查询");
		//获取session对象中的companyBean,得到name
		HttpSession session = request.getSession();
		CompanyBean companyBean = (CompanyBean) session.getAttribute("companyBean");
		String name = companyBean.getName();
		//将page换算分页(一页8行)的index
		int index = (page-1)*8;
		//查询list
		List<CarportBean> list = service.findCompanyAlreadyRentedFuzzyQuery(index,name,addr,p_number,
				b_number,start_time,end_time);
		System.out.println("list:"+list);
		//查询企业已租赁车位总数量（分页），从而获得总页数
		int num = service.findCompanyAlreadyRentedFuzzyQueryTotalNum(name, addr, p_number, b_number, start_time, end_time);
		int totalPage = 0;
		if(num%8 == 0){
			totalPage = num/8;
		}else{
			totalPage = (num/8)+1;
		}
		//将list和totalPage放到map中
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("list", list);
		map.put("totalPage", totalPage);
		map.put("num", num);
		return map;
	}
	
	//根据企业名称查询CDB车位管理平台系统的未租赁的空闲车位
	@RequestMapping("/notRent.do")
	public @ResponseBody Map<String,Object> notRent(int page,String addr,String p_number,String end_time){
		System.out.println("进入到了notRent方法中");
		System.out.println("page:"+page);
		System.out.println("addr:"+addr);
		System.out.println("p_number:"+p_number);
		System.out.println("end_time:"+end_time);
		//将page换算分页(一页8行)的index
		int index = (page-1)*8;
		List<CarportBean> list = service.findCompanyNotRentedFuzzyQuery(index,addr,p_number,end_time);
		System.out.println("list.size():"+list.size());
		System.out.println("list:"+list);
		//查询企业已租赁车位总数量（分页），从而获得总页数
		int num = service.findCompanyNotRentedFuzzyQueryTotalNum(addr,p_number,end_time);
		System.out.println("controller层获得的num:"+num);
		int totalPage = 0;
		if(num%8 == 0){
			totalPage = num/8;
		}else{
			totalPage = (num/8)+1;
		}
		//将list和totalPage放到map中
		Map<String,Object> map2 = new HashMap<String,Object>();
		map2.put("list", list);
		map2.put("totalPage", totalPage);
		map2.put("num", num);
		return map2;
	}
	
	//根据输入企业名称、楼层位置、联系人以及联系电话的模糊查找功能
	@RequestMapping(value={"/companyFuzzyQuery.do"},method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> fuzzyQuery(
		HttpServletRequest request,HttpServletResponse response,
		Integer page,String name, String addr, 
		String contacts, String phone,Integer deleteId,
		String isSubmit,Integer update_id,String update_name,String update_addr,
		String update_contacts,String update_phone,
		String[] checkID){
		System.out.println("进入到了 controller fuzzyQuery方法中");
		System.out.println("page:"+page);
		System.out.println("name:"+name);
		System.out.println("addr:"+addr);
		System.out.println("contacts:"+contacts);
		System.out.println("phone:"+phone);
		System.out.println("从companyFuzzyQueryList.jsp页面传过来的deleteId:"+deleteId);
		System.out.println("isSubmit:"+isSubmit);
		System.out.println("update_name:"+update_id);
		System.out.println("update_name:"+update_name);
		System.out.println("update_addr:"+update_addr);
		System.out.println("update_contacts:"+update_contacts);
		System.out.println("update_phone:"+update_phone);
		System.out.println("checkID.length:"+checkID.length);
		
		//建立一个map
		Map<String,Object> ShowListMap = new HashMap<String,Object>();
		ShowListMap.put("name1", "");
		ShowListMap.put("name2", "");
		ShowListMap.put("addr1", "");
		ShowListMap.put("contacts1", "");
		ShowListMap.put("phone1", "");
		ShowListMap.put("deleteSuccess1", "");
		ShowListMap.put("modifySuccess1", "");
		/*Map<String,Object> modifyInfoMap = null;*/
		//有deleteId传过来，则先进行删除
		if(deleteId!=null){
			String info = companyDelete(deleteId);
			if(info.equals("删除成功")){
				ShowListMap.put("deleteSuccess1","删除成功");
				System.out.println("controller层删除成功");
			}
		}
		//如果checkID不为空，则输出checkID中的id，按照这些id进行删除
		if(checkID.length != 0){
			for(int i=0;i<checkID.length;i++){
				System.out.println("checkID[i]:"+checkID[i]);
				Integer a = Integer.parseInt(checkID[i]);
				companyDelete(a);
			}
		}
		
		//进行数据更新
		if(isSubmit.equals("submit")){
			System.out.println("准备创建companyBean2");
			CompanyBean companyBean2 = new CompanyBean();
			companyBean2.setId(update_id);
			System.out.println("id:"+companyBean2.getId());
			companyBean2.setName(update_name);
			companyBean2.setAddr(update_addr);
			companyBean2.setContacts(update_contacts);
			companyBean2.setPhone(update_phone);
			System.out.println("准备进行调用service测修改方法");
			//修改企业时的异常信息modifyInfoMap
			Map<String,Object> modifyInfoMap = service.companyBackstageModify(companyBean2);
			System.out.println("controller层modifyInfoMap:"+modifyInfoMap);
			String name1 = (String) modifyInfoMap.get("name1");
			String name2 = (String) modifyInfoMap.get("name2");
			String addr1 = (String) modifyInfoMap.get("addr1");
			String contacts1 = (String) modifyInfoMap.get("contacts1");
			String phone1 = (String) modifyInfoMap.get("phone1");
			String deleteSuccess1 = (String) modifyInfoMap.get("deleteSuccess1");
			String modifySuccess1 = (String) modifyInfoMap.get("modifySuccess1");
			//放到ShowListMap中
			ShowListMap.put("name1",name1);
			ShowListMap.put("name2",name2);
			ShowListMap.put("addr1",addr1);
			ShowListMap.put("contacts1",contacts1);
			ShowListMap.put("phone1",phone1);
			ShowListMap.put("deleteSuccess1",deleteSuccess1);
			ShowListMap.put("modifySuccess1",modifySuccess1);
		}
		CompanyBean companyBean = new CompanyBean();
		companyBean.setName(name);
		companyBean.setAddr(addr);
		companyBean.setContacts(contacts);
		companyBean.setPhone(phone);
		//将page换算分页(一页4行)的index
		Integer index = 0;
		if(page.equals(null)){
			index = -1;
		}else{
			index = (page-1)*4;
		}
		List<CompanyBean> list = service.findCompany(companyBean,index);
		System.out.println("查询到的list:"+list);
		//模糊查询到的企业总数量（分页），从而获得总页数
		Integer num = service.findCompanyTotalNum(companyBean);
		System.out.println("controller类模糊查询到的企业总数量："+num);
		int totalPage = 0;
		if(num%4 == 0){
			totalPage = num/4;
		}else{
			totalPage = (num/4)+1;
		}
		//将list和totalPage放到ShowListMap中
		ShowListMap.put("list", list);
		ShowListMap.put("totalPage", totalPage);
		ShowListMap.put("num", num);
		System.out.println("ShowListMap:"+ShowListMap);
		//返回到jsp
		return ShowListMap;
	}

	//根据输入企业信息进行新增企业
	@RequestMapping(value={"/companyAdd.do"},method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> companyAdd(
		HttpServletRequest request,HttpServletResponse response,
		String admin,String pass,String rePass,
		String name, String addr, String contacts, String phone){
		//建立一个map
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("admin1", "");
		map.put("admin2", "");
		map.put("pass1", "");
		map.put("rePass1", "");
		map.put("name1", "");
		map.put("name2", "");
		map.put("addr1", "");
		map.put("contacts1", "");
		map.put("phone1", "");
		map.put("success1", "");
		
		System.out.println("进入到了controller companyAdd方法中");
		/*response.setContentType("text/html;charset=utf-8");*/
		CompanyBean companyBean = new CompanyBean();
		companyBean.setAdmin(admin);
		companyBean.setPass(pass);
		companyBean.setRePass(rePass);
		companyBean.setName(name);
		companyBean.setAddr(addr);
		companyBean.setContacts(contacts);
		companyBean.setPhone(phone);
		System.out.println("companyBean:"+companyBean);
		Map map2 = service.addCompany(companyBean);
		map.put("admin1", map2.get("admin1"));
		map.put("admin2", map2.get("admin2"));
		map.put("pass1", map2.get("pass1"));
		map.put("rePass1", map2.get("rePass1"));
		map.put("name1", map2.get("name1"));
		map.put("name2", map2.get("name2"));
		map.put("addr1", map2.get("addr1"));
		map.put("contacts1", map2.get("contacts1"));
		map.put("phone1", map2.get("phone1"));
		map.put("success1", map2.get("success1"));
		
		System.out.println("action层map:"+map);
		//回显，将查询到的companyBean也存到map中
		System.out.println("准备跳转将companyBean放到map中");
		map.put("companyBean", companyBean);
		System.out.println("添加companyBean后的map:"+map);
		return map;
	}
	//删除企业（软删除）
	@RequestMapping(value={"/companyDelete.do"},method=RequestMethod.GET)
	public String companyDelete(int id){
		System.out.println("从companyFuzzyQueryList.jsp页面传过来的:"+id);
		boolean bo = service.deleteCompany(id);
		if(bo==true){
			return "删除成功";
		}else{
			return "删除失败";
		}
	}
	
	@RequestMapping("/updateCompany.do")
	public ModelAndView updateBack(CompanyBean cb, HttpSession httpsession){
		ModelAndView model=new ModelAndView();
		model.setViewName("/jsp/ccJsp.jsp");
		if(!cb.getPass().matches("^[a-zA-Z0-9]{6,15}$|{0}")){
			model.addObject("passError","密码只能为6-15位数字或字母组成");
			return model;
		}
		
		if(!cb.getPhone().matches("^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$|{0}")){
			model.addObject("phoneError", "电话格式不对");
			return model;
		}
		
		if(!cb.getContacts().matches("^[A-Za-z\u4e00-\u9fa5]+$|{0}")){
			System.out.println(cb.getContacts());
			model.addObject("contactsError", "联系人只能输入中文和字母");
			return model;
		}
		
		
		//取个人用户登录时存在session中的id
		CompanyBean cbb = (CompanyBean) httpsession.getAttribute("companyBean");
//		System.out.println(cbb);
		int id=cbb.getId();
		if(cb.getPass().matches("^[a-zA-Z0-9]{6,15}$")){
			//加密密码
			String admin=cbb.getAdmin();
			SimpleHash hash=new SimpleHash("md5", cb.getPass(), admin, 3);
			String hashPass=hash.toBase64();
			cb.setPass(hashPass);
		}

		//如果更新成功就跳转到成功页面，反之跳转到失败页面
		if(service.ChangeInfo(cb, id)){
			model.addObject("success","修改成功");
			return model;
			}
		model.addObject("success","修改失败");
		
		return model;
	}

}
