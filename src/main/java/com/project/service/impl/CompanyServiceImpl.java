package com.project.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.project.bean.CarportBean;
import com.project.bean.CompanyBean;
import com.project.dao.ICompanyDao;
import com.project.dao.impl.CompanyDaoImpl;
import com.project.service.ICompanyService;
import com.project.util.MD5_Encoding;
import com.project.util.RegularUtil;

@Service
public class CompanyServiceImpl implements ICompanyService{
	
	@Autowired
	/*@Qualifier("companyDaoImpl")*/
	private CompanyDaoImpl dao;

	
	 @Override
	    public CompanyBean findByName(String admin) {
	        return dao.selectByName(admin);
	    }
	@Override
	public List<CompanyBean> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CompanyBean selectById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CompanyBean selectByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer selectByObj(CompanyBean company) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CompanyBean getConpanyUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean ChangeInfo(CompanyBean ncb,int id) {
		// TODO Auto-generated method stub
//		System.out.println(ncb);
//		System.out.println(id);
		CompanyBean cb=dao.selectById(id);
		
//		System.out.println(cb);
		if(ncb.getPass()!=""){cb.setPass(ncb.getPass());}
		if(ncb.getContacts()!=""){cb.setContacts(ncb.getContacts());}
		if(ncb.getPhone()!=""){cb.setPhone(ncb.getPhone());}
		return dao.update(cb);

	}
	
	//根据企业登录名查询企业名称
	@Override
	public CompanyBean findCompanyNameByAdmin(String admin) {
		CompanyBean bean = dao.findCompanyNameByAdmin(admin);
		return bean;
	}
	//企业已租赁车位模糊查询
	@Override
	public List<CarportBean> findCompanyAlreadyRentedFuzzyQuery(int index, String name, String addr, String p_number,
			String b_number, String start_time, String end_time) {
		List<CarportBean> list = dao.findCompanyAlreadyRentedFuzzyQuery(index,name,addr,p_number,
				b_number,start_time,end_time);
		return list;
	}
	//企业已租赁车位模糊查询总数量（分页）
	@Override
	public Integer findCompanyAlreadyRentedFuzzyQueryTotalNum(String name, String addr, String p_number,
			String b_number, String start_time, String end_time) {
		int num = dao.findCompanyAlreadyRentedFuzzyQueryTotalNum(name, addr, p_number, b_number, start_time, end_time);
		return num;
	}
	//CBD平台未租赁车位模糊查询
	@Override
	public List<CarportBean> findCompanyNotRentedFuzzyQuery(int index, String addr, String p_number, String end_time) {
		List<CarportBean> list = dao.findCompanyNotRentedFuzzyQuery(index,addr,p_number,end_time);
		return list;
	}
	//CBD平台未租赁车位模糊查询总数量（分页）
	@Override
	public Integer findCompanyNotRentedFuzzyQueryTotalNum(String addr, String p_number, String end_time) {
		Integer num = dao.findCompanyNotRentedFuzzyQueryTotalNum(addr,p_number,end_time);
		return num;
	}
	//根据输入企业名称、楼层位置、联系人以及联系电话的模糊查找功能
	@Override
	public List<CompanyBean> findCompany(CompanyBean companyBean,int index) {
		List<CompanyBean> list = dao.findCompany(companyBean,index);
		return list;
	}
	//查询模糊查询企业总数量（分页）
	@Override
	public Integer findCompanyTotalNum(CompanyBean companyBean) {
		Integer num = dao.findCompanyTotalNum(companyBean);
		return num;
	}
	//根据输入企业信息进行新增企业
	@Override
	public Map<String,Object> addCompany(CompanyBean companyBean) {
		//建立map，用于存放info
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
		//判断登录账号格式
		System.out.println("companyBean.getAdmin():"+companyBean.getAdmin());
		System.out.println("companyBean.getAdmin().length():"+companyBean.getAdmin().length());
		if(!companyBean.getAdmin().matches(RegularUtil.TEL)){
			map.put("admin1","格式不正确，请输入11位有效的手机号;");
			System.out.println("格式不正确，请输入11位有效的手机号;");
		}
		//判断账号是否已经在数据库中存在了
		System.out.println("接下来查询Name");
		CompanyBean bean = dao.findCompanyNameByAdmin(companyBean.getAdmin());
		System.out.println("查询Name之后，bean:"+bean);
		if(bean!=null){
			map.put("admin2","该企业登录账号已存在，请重新输入");
			System.out.println("该企业登录账号已存在，请重新输入");
		}else{
			map.put("admin2","");
		}
		//判断登录密码格式
		if(companyBean.getPass().length()<6 || companyBean.getPass().length()>18){
			map.put("pass1","登录密码的长度必须为6~18位;");
			System.out.println("登录密码的长度必须为6~18位");
		}
		//判断2次输入的密码是否一致
		if(!(companyBean.getPass()).equals(companyBean.getRePass())){
			map.put("rePass1","2次输入的密码必须一致;");
			System.out.println("2次输入的密码必须一致");
		}
		System.out.println("接下来判断企业是否为空");
		//判断输入的企业名称是否为空
		if((companyBean.getName()).length()==0){
			map.put("name1","企业名称不能为空;");
			System.out.println("企业名称不能为空");
		}
		System.out.println("接下来判断企业是否已存在");
		//判断企业名称是否已经存在
		CompanyBean Be = dao.selectIsExistByCompanyName(companyBean.getName());
		System.out.println("Be:"+Be);
		if(Be != null){
			map.put("name2","该企业名称已存在;");
			System.out.println("该企业名称已存在");
		}else{
			map.put("name2","");
			System.out.println("企业不存在");
		}
		System.out.println("接下来判断楼层");
		//判断输入的企业楼层位置是否为空
		if((companyBean.getAddr()).length()==0){
			map.put("addr1","企业楼层位置不能为空;");
			System.out.println("企业楼层位置不能为空");
		}
		System.out.println("接下来判断联系人");
		//判断联系人名字格式是否正确（2~4个汉字）
		if(!companyBean.getContacts().matches(RegularUtil.NAME)){
			map.put("contacts1","请输入2~4个中文汉字;");
			System.out.println("请输入2~4个中文汉字");
		}
		System.out.println("接下来判断电话");
		//判断联系电话是否正确
		if(!companyBean.getPhone().matches(RegularUtil.TEL)){
			map.put("phone1","格式不正确，请输入11位有效的手机号;");
			System.out.println("格式不正确，请输入11位有效的手机号");
		}
		//格式正确后，进行企业新增
		System.out.println("马上进行新增前的判断");
		if(map.get("admin1").equals("") && 
			map.get("admin2").equals("") && 
			map.get("pass1").equals("") && 
			map.get("rePass1").equals("") && 
			map.get("name1").equals("") && 
			map.get("name2").equals("") && 
			map.get("addr1").equals("") && 
			map.get("contacts1").equals("") && 
			map.get("phone1").equals("")){
			System.out.println("已进入新增判断");
			String rawpass = companyBean.getPass();
			//使用MD5加salt加密
			SimpleHash hash = new SimpleHash("MD5", companyBean.getPass(), companyBean.getAdmin(), 3);
			String passLocked = hash.toBase64();
			System.out.println("加密完毕");
			System.out.println("passLocked；"+passLocked);
			companyBean.setPass(passLocked);
			//进行企业新增
			boolean bo = dao.addCompany(companyBean);
			System.out.println("新增完毕");
			if(bo==true){
				//将之前的密码换回去，用于页面回显
				companyBean.setPass(rawpass);
				map.put("success1","新增企业成功,您可以前往查询模块进行查询");
				System.out.println("新增企业成功,您可以前往查询模块进行查询");
			}
		}
			return map;
	}
	//删除企业（软删除）
	@Override
	public boolean deleteCompany(int id) {
		boolean bo = dao.deleteCompany(id);
		return bo;
	}
	//后台进行企业信息的修改
	@Override
	public Map<String,Object> companyBackstageModify(CompanyBean companyBean) {
		//建立map，用于存放info
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("name1", "");
		map.put("name2", "");
		map.put("addr1", "");
		map.put("contacts1", "");
		map.put("phone1", "");
		map.put("deleteSuccess1", "");
		map.put("modifySuccess1", "");
		System.out.println("companyBean.getName()).length():"+(companyBean.getName()).length());
		//判断输入的企业名称是否为空
		if((companyBean.getName()).length()==0){
			map.put("name1","企业名称不能为空;");
			System.out.println("企业名称不能为空");
		}
		//判断企业名称是否已经存在
		int update_id = companyBean.getId();
		if((dao.selectIsExistByCompanyId(update_id)).getName().equals(companyBean.getName())){
			map.put("name2","");
		}else if(dao.selectIsExistByCompanyName(companyBean.getName()) !=null){
			map.put("name2","输入的企业已存在");
		}
		
		//判断输入的企业楼层位置是否为空
		if((companyBean.getAddr()).length()==0){
			map.put("addr1","企业楼层位置不能为空;");
			System.out.println("企业楼层位置不能为空");
		}
		//判断联系人名字格式是否正确（2~4个汉字）
		if(!companyBean.getContacts().matches(RegularUtil.NAME)){
			map.put("contacts1","请输入2~4个中文汉字;");
			System.out.println("请输入2~4个中文汉字");
		}
		
		//判断联系电话是否正确
		if(!companyBean.getPhone().matches(RegularUtil.TEL)){
			map.put("phone1","请输11位有效的手机号;");
			System.out.println("请输11位有效的手机号");
		}
		//格式正确后，进行企业信息修改
		if(map.get("name1").equals("") && 
			map.get("name2").equals("") && 
			map.get("addr1").equals("") && 
			map.get("contacts1").equals("") && 
			map.get("phone1").equals("")){
			boolean bo = dao.companyBackstageModify(companyBean);
			if(bo==true){
				map.put("modifySuccess1","修改企业成功");
				System.out.println("修改企业成功");
			}
		}
		System.out.println("service实现类map:"+map);
		return map;
	}
}
