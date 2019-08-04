package com.project.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.bean.PersonBean;
import com.project.dao.IPersonDao;
@Repository
public class PersonDaoImpl implements IPersonDao{
	@Autowired
	private SqlSessionFactory fa=null;

	@Override
	public void updateCreditById(PersonBean perb) {
		SqlSession session = fa.openSession();
		session.update("mapperPerson.updateCreditById", perb);
		
		session.commit();
		session.close();
		
	}

	@Override
	public boolean ChangeInfo(PersonBean personBean) {
		// TODO Auto-generated method stub
		SqlSession session = fa.openSession();
		int row=session.update("mapperPerson.changeInfo",personBean);
		session.close();
		if(row>0){return true;}
		return false;
	}

	@Override
	public List<PersonBean> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonBean selectById(Integer id) {
		// TODO Auto-generated method stub
		SqlSession session = fa.openSession();
		PersonBean pb=session.selectOne("mapperPerson.getPersonById",id);
		session.close();
		return pb;
	}

	

	@Override
	public Integer selectByObj(PersonBean rents) {
		// TODO Auto-generated method stub
		return null;
	}

	

	
	 @Override
	    public PersonBean selectByName(String name) {
	        SqlSession session=fa.openSession();
	        PersonBean person=session.selectOne("com.project.dao.IPersonDao.selectByName",name);
	        session.close();
	        return person;
	    }

	    @Override
	    public void insert(PersonBean personBean) {
	        SqlSession session=fa.openSession();
	        
	        System.out.println(personBean);
	        session.insert("com.project.dao.IPersonDao.insert",personBean);
	        session.close();
	    }
	
}
