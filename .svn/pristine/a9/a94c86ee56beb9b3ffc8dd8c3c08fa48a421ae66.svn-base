package com.project.realm;

import com.project.bean.BackStageBean;
import com.project.service.IBackStageService;

import java.util.List;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Author: 周鑫
 * Date: 2018-10-16 11:17
 * Description: <后台管理员Realm>
 */
public class BackStageRealm extends AuthorizingRealm {

    @Autowired
    private IBackStageService backStageService;

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        
System.out.println("进入realm1");
		
		//获取主身份信息，是认证时传入的
		BackStageBean tub=(BackStageBean) principalCollection.getPrimaryPrincipal();
		
		//获取权限信息
		//将权限信息单独封装为一个list
		List<String> permissions=tub.getPlist();
		System.out.println(permissions.toString());
		

		SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
		authorizationInfo.addStringPermissions(permissions);
		
		
		
		return authorizationInfo;
    }

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String num= (String) authenticationToken.getPrincipal();
        BackStageBean backStageBean=backStageService.findByNum(num);
        System.out.println("后台登陆"+backStageBean.getNum()+" "+backStageBean.getPass()+" "+num);
        System.out.println("后台realm名字"+getName());
        if (backStageBean==null){
            throw new UnknownAccountException();
        }
        return new SimpleAuthenticationInfo(
                backStageBean,
                backStageBean.getPass(),
                ByteSource.Util.bytes(backStageBean.getNum()),
                getName()
        );
    }
}
