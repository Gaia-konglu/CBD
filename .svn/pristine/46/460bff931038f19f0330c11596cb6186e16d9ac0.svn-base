package com.project.util;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * Author: 周鑫
 * Date: 2018-10-16 22:35
 * Description: <自定义token>
 */
public class UsernamePasswordByUserTypeToken extends UsernamePasswordToken {
    private static final long serialVersionUID = -7638434498222500528L;

    /*
     * 用户类型
     * 1:包租婆/抢租客用户(前台) 1
     * 2:企业用户(前台)        2
     * 3:管理员(后台)         3
     */
    private String userType;

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public UsernamePasswordByUserTypeToken(String username, String password, String userType) {
        super(username, password);
        this.userType = userType;
    }

}
