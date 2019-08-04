package com.project.dao.impl;

import com.project.bean.RoleBean;
import com.project.dao.IRoleDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author: 周鑫
 * Date: 2018-10-11 15:58
 * Description: <描述>
 */
@Repository
public class RoleDaoImpl implements IRoleDao {

    @Autowired
    private SqlSessionFactory fa;

    @Override
    public List<RoleBean> selectAll() {
        System.out.println(fa);
        SqlSession session=fa.openSession();
        List<RoleBean> roleBeans=session.selectList("com.project.dao.IRoleDao.selectAll");
        return roleBeans;
    }
}
