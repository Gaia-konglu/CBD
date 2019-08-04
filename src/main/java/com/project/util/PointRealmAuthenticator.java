package com.project.util;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.realm.Realm;

import java.util.Map;

/**
 * Author: 周鑫
 * Date: 2018-10-16 22:41
 * Description: <自定义认证器>
 */
public class PointRealmAuthenticator extends ModularRealmAuthenticator {
    /**
     * 存放realm
     */
    private Map<String, Object> definedRealms;

    public void setDefinedRealms(Map<String, Object> definedRealms) {
        this.definedRealms = definedRealms;
    }

    /**
     * 根据用户类型判断使用哪个Realm
     */
    @Override
    protected AuthenticationInfo doAuthenticate(AuthenticationToken authenticationToken)
            throws AuthenticationException {
        super.assertRealmsConfigured();
        Realm realm = null;
        // 使用自定义Token
        UsernamePasswordByUserTypeToken token = (UsernamePasswordByUserTypeToken) authenticationToken;
        // 判断用户类型
        if ("1".equals(token.getUserType())) {
            realm = (Realm) this.definedRealms.get("personRealm");
        }
        else if ("2".equals(token.getUserType())) {
            realm = (Realm) this.definedRealms.get("companyRealm");
        }
        else if ("3".equals(token.getUserType())) {
            realm = (Realm) this.definedRealms.get("backStageRealm");
        }
        return this.doSingleRealmAuthentication(realm, authenticationToken);
    }
}
