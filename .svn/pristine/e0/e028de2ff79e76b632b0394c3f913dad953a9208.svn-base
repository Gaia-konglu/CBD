package com.project.realm;



import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.bean.BackStageBean;
import com.project.service.IBackService;

public class MyRealm extends AuthorizingRealm {

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		super.setName("myrealm");
	}
	
	@Autowired
	private IBackService service;
	
	/**
	 * 用于认证
	 */
	
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
	 	// TODO Auto-generated method stub
		
	
		String username=   (String) token.getPrincipal();
		System.out.println(username+"进入realm2"+this.getName());
		//通过username到数据库查询密码
		BackStageBean bsb=service.getBackByAccount(username);
		
		//如果查询不到返回空
	
		if(bsb==null){
		 throw new UnknownAccountException(); //如果用户名错误
	 }
		
		
		SimpleAuthenticationInfo AuthenticationInfo=new SimpleAuthenticationInfo(	
				bsb,bsb.getPass(),this.getName()
				);
		
		
		return AuthenticationInfo;
	}
	/**
	 * 用于授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		System.out.println("进入realm1");
		
		//获取主身份信息，是认证时传入的
		BackStageBean tub=(BackStageBean) arg0.getPrimaryPrincipal();
		
		//获取权限信息
		//将权限信息单独封装为一个list
		List<String> permissions=tub.getPlist();
		System.out.println(permissions.toString());
		

		SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
		authorizationInfo.addStringPermissions(permissions);
		
		
		
		return authorizationInfo;
	}

}
