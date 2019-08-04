package com.project.service.impl;

import com.project.bean.BackStageBean;
import com.project.bean.CompanyBean;
import com.project.bean.LoginLogBean;
import com.project.bean.PersonBean;
import com.project.dao.ILoginLogDao;
import com.project.dao.impl.LoginLogDaoImpl;
import com.project.service.ICompanyService;
import com.project.service.ILoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Author: 周鑫
 * Date: 2018-10-17 16:13
 * Description: <描述>
 */
@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
public class LoginLogServiceImpl implements ILoginLogService {

    @Autowired
    private LoginLogDaoImpl loginLogDao;

    @Override
    public void add(Object obj,String browser,String ip) {
        LoginLogBean loginLogBean=new LoginLogBean();
        loginLogBean.setBrowser(browser);
        loginLogBean.setAddr(ip);
        if (obj instanceof BackStageBean){
            BackStageBean backStageBean=(BackStageBean)obj;
            loginLogBean.setLoginName(backStageBean.getNum());
            loginLogBean.setRealName(backStageBean.getName());
        }
        if (obj instanceof PersonBean){
            PersonBean personBean=(PersonBean) obj;
            loginLogBean.setLoginName(personBean.getName());
            loginLogBean.setRealName(personBean.getRealName());
        }
        if (obj instanceof CompanyBean){
            CompanyBean companyBean=(CompanyBean) obj;
            loginLogBean.setLoginName(companyBean.getAdmin());
            loginLogBean.setRealName(companyBean.getName());
        }
        loginLogDao.insert(loginLogBean);
    }
}
