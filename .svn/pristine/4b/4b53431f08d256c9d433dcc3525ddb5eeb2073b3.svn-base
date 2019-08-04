package com.project.service.impl;

import com.project.bean.RoleBean;
import com.project.dao.IRoleDao;
import com.project.dao.impl.RoleDaoImpl;
import com.project.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: 周鑫
 * Date: 2018-10-11 16:02
 * Description: <描述>
 */
@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private RoleDaoImpl roleDao;

    @Override
    public List<RoleBean> findAll() {
        List<RoleBean> roleBeans=roleDao.selectAll();
        System.out.println(roleBeans.toString());
        return roleBeans;
    }
}
