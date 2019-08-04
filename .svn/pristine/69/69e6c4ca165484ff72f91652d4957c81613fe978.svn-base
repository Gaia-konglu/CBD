package com.project.dao.impl;

import com.project.bean.LoginLogBean;
import com.project.dao.ILoginLogDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Author: 周鑫
 * Date: 2018-10-17 16:07
 * Description: <描述>
 */
@Repository
public class LoginLogDaoImpl implements ILoginLogDao {

    @Autowired
    private SqlSessionFactory fa;

    @Override
    public void insert(LoginLogBean loginLogBean) {
        SqlSession session=fa.openSession();
        session.insert("com.project.dao.ILoginLogDao.insert",loginLogBean);
        session.close();
    }
}
