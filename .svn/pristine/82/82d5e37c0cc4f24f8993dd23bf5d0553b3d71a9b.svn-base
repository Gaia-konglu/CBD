package com.project.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.bean.BackStageBean;
import com.project.dao.impl.BackDaoImpl;
import com.project.service.IBackService;
import com.project.util.RegularUtil;

@Service
public class BackServiceImpl implements IBackService{

	@Autowired
   // @Qualifier("backDaoImpl")
   //private IBackDao dao;
	private BackDaoImpl dao;

	@Override
	//后台管理人员修改登录密码和电话号码
	public Map<String,Object> ChangeInfo(BackStageBean bsb) {
		// TODO Auto-generated method stub
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("pass", "");
		map.put("phone", "");
		map.put("Success", "");
		
		
		if(!(bsb.getPass()).matches("^\\d{6,15}$")){
			map.put("pass","密码格式不对，请输入6~15位数字的密码;");
			System.out.println("密码格式不对，请输入6~15位数字的密码");
		}
		if((bsb.getPass()).length()==0){
			map.put("pass","密码不能为空;");
			System.out.println("密码不能为空");
		}
		
		//判断联系电话是否正确
		if(!(bsb.getPhone()).matches(RegularUtil.TEL)){
			map.put("phone","请输11位有效的手机号;");
			System.out.println("请输11位有效的手机号");
		}
		//判断联系电话是否为空
		
		if((bsb.getPhone()).length()==0){
			map.put("phone","电话号码不能为空;");
			System.out.println("电话号码不能为空");
		}
		
		if(map.get("pass").equals("") &&
		   map.get("phone").equals("")	){
			boolean bow = dao.update(bsb);
			if(bow == true){
				map.put("Success","修改信息成功");
				System.out.println("修改信息成功");
			}
		}		
		
		return map;
	}

	@Override
	public List<BackStageBean> selectAll() {
		// TODO Auto-generated method stub
		List<BackStageBean> list=dao.selectAll();
		return list;
	}

	@Override
	public BackStageBean selectById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BackStageBean selectByName(Short name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer selectByObj(BackStageBean backstage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BackStageBean getBackByAccount(String account) {
		BackStageBean bb=dao.getBackByAccount(account);
		return bb;
	}

}
