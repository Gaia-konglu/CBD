package com.project.service.impl;

import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.shiro.authc.credential.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.project.bean.PersonBean;
import com.project.bean.RoleBean;
import com.project.dao.IPersonDao;
import com.project.dao.impl.PersonDaoImpl;
import com.project.exception.AccountExistException;
import com.project.service.IPersonService;
import com.project.vo.PasswordVo;
import com.project.vo.PersonVo;
@Service
public class PersonServiceImpl implements IPersonService{
	@Autowired
	private PersonDaoImpl dao;
	
	@Autowired
    private PasswordService passwordService;
	@Override
	public List<PersonBean> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonBean selectById(Integer id) {
		// TODO Auto-generated method stub
		PersonBean pb=dao.selectById(id);
		return pb;
	}

	@Override
	public PersonBean selectByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer selectByObj(PersonBean rents) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(PersonBean rents) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED)
	public void updateCreditById(PersonBean perb) {
		dao.updateCreditById(perb);
		
	}

	@Override
	public boolean ChangeInfo(PersonBean npb,int id) {
		// TODO Auto-generated method stub
		PersonBean pb=dao.selectById(id);
		if(npb.getPassword()!=""){pb.setPassword(npb.getPassword());}
		if(npb.getAddr()!=""){pb.setAddr(npb.getAddr());}
		if(npb.getPhone()!=""){pb.setPhone(npb.getPhone());}
		if(npb.getJob()!=""){pb.setJob(npb.getJob());}
		if(npb.geteMail()!=""){pb.seteMail(npb.geteMail());}
		return dao.ChangeInfo(pb);
	}
	
	 

	 @Override
	    public void add(PersonVo personVo) throws AccountExistException {
	        PersonBean personBean=dao.selectByName(personVo.getName());
	        if (personBean!=null){
	            throw new AccountExistException("账号已存在");
	        }
	        RoleBean roleBean=new RoleBean();
	        roleBean.setId(personVo.getRoleId());

	        PasswordVo passwordVo=new PasswordVo();
	        passwordVo.setPassword(personVo.getPassword());
	        passwordVo.setSalt(personVo.getName());
	        String password=passwordService.encryptPassword(passwordVo);

	        PersonBean person=new PersonBean();
	        try {
	            PropertyUtils.copyProperties(person,personVo);
	            person.setPassword(password);
	            person.setRole(roleBean);
	            //插入数据库
	            dao.insert(person);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	    }

	    @Override
	    public PersonBean findByName(String name) {
	        return dao.selectByName(name);
	    }

}
