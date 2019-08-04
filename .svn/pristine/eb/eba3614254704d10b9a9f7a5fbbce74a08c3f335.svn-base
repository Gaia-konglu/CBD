package com.project.realm;

import com.project.bean.BackStageBean;
import com.project.bean.PersonBean;
import com.project.service.IPersonService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

/**
 * Author: 周鑫
 * Date: 2018-10-15 22:30
 * Description: <包租婆抢租客Realm>
 */
public class PersonRealm extends AuthorizingRealm {

    @Autowired
    private IPersonService personService;

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		return null;
    	
    	
    
    			
    			
      
    }

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String name= (String) authenticationToken.getPrincipal();
        PersonBean personBean=personService.findByName(name);
        System.out.println("包租婆/抢租客登陆"+personBean);
        System.out.println("包租婆/抢租客realm名字"+getName());
        if (personBean==null){
            throw new UnknownAccountException();
        }
        return new SimpleAuthenticationInfo(
                personBean,//用户信息
                personBean.getPassword(),//数据库密码
                ByteSource.Util.bytes(personBean.getName()),//盐值
                getName()
        );
    }
}
