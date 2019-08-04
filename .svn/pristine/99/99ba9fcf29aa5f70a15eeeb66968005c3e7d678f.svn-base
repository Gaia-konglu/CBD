package com.project.service.impl;

import com.project.vo.PasswordVo;
import org.apache.shiro.authc.credential.PasswordService;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Author: 周鑫
 * Date: 2018-10-15 19:07
 * Description: <描述>
 */
@Service
public class PasswordServiceImpl implements PasswordService {

    @Value("${algorithmName}")
    private String algorithmName;
    @Value("${hashIterations}")
    private Integer hashIterations;

    @Override
    public String encryptPassword(Object o) throws IllegalArgumentException {
        PasswordVo passwordVo=(PasswordVo)o;
        return new SimpleHash(algorithmName,passwordVo.getPassword(),passwordVo.getSalt(),hashIterations).toBase64();
    }
    @Override
    public boolean passwordsMatch(Object o, String s) {
        return false;
    }
}
