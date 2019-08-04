package com.project.dao;

import com.project.bean.UserBean;

public interface IUserDao {
	
	public UserBean findByAccount(String account);

}
