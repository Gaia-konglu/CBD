package com.project.service;

import com.project.bean.BackStageBean;

/**
 * Author: 周鑫
 * Date: 2018-10-16 11:19
 * Description: <描述>
 */
public interface IBackStageService {
    /**
     * 根据登陆名查找管理员信息
     * @param num
     * @return
     */
    BackStageBean findByNum(String num);
}
