package com.project.vo;

import java.io.Serializable;

/**
 * Author: 周鑫
 * Date: 2018-10-15 17:11
 * Description: <描述>
 */
public class PersonVo implements Serializable {
    private String name;
    private String password;
    private String realName;
    private String addr;
    private String phone;
    private String idCard;
    private String job;
    private String email;
    private Integer roleId;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "PersonVo{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", realName='" + realName + '\'' +
                ", addr='" + addr + '\'' +
                ", phone='" + phone + '\'' +
                ", idCard='" + idCard + '\'' +
                ", job='" + job + '\'' +
                ", email='" + email + '\'' +
                ", roleId=" + roleId +
                '}';
    }
}
