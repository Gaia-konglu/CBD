package com.project.dao;

import com.project.bean.BackStageBean;

/**
 * Author: 周鑫
 * Date: 2018-10-16 11:08
 * Description: <描述>
 */
public interface IBackStageDao {
    /**
     * 根据用户名查找用户
     * @param num
     * @return
     */
    BackStageBean selectByNum(String num);
}
