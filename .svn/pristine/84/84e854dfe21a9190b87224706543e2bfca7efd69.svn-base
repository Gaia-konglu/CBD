package com.project.realm;

import com.project.bean.CompanyBean;
import com.project.service.ICompanyService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Author: 周鑫
 * Date: 2018-10-17 0:23
 * Description: <描述>
 */
public class CompanyRealm extends AuthorizingRealm {

    @Autowired
    private ICompanyService companyService;

    /**
     * 授权
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    /**
     * 认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String admin= (String) token.getPrincipal();
        CompanyBean companyBean=companyService.findByName(admin);
        System.out.println("企业用户登陆"+companyBean);
        System.out.println("企业用户realm名字"+getName());
        if (companyBean==null){
            throw new UnknownAccountException();
        }
        return new SimpleAuthenticationInfo(
                companyBean,
                companyBean.getPass(),
                ByteSource.Util.bytes(companyBean.getAdmin()),
                getName()
        );
    }
}
