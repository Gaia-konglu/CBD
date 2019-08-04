package com.project.service.impl;

import com.project.bean.BackStageBean;
import com.project.dao.IBackStageDao;
import com.project.dao.impl.BackStageDaoImpl;
import com.project.service.IBackStageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author: 周鑫
 * Date: 2018-10-16 11:21
 * Description: <描述>
 */
@Service
public class BackStageServiceImpl implements IBackStageService {

    @Autowired
    private BackStageDaoImpl backStageDao;

    @Override
    public BackStageBean findByNum(String num) {
        return backStageDao.selectByNum(num);
    }
}
