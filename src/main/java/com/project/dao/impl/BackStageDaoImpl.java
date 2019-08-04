package com.project.dao.impl;

import com.project.bean.BackStageBean;
import com.project.dao.IBackStageDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Author: 周鑫
 * Date: 2018-10-16 11:23
 * Description: <描述>
 */
@Repository
public class BackStageDaoImpl implements IBackStageDao {

    @Autowired
    private SqlSessionFactory fa;

    @Override
    public BackStageBean selectByNum(String num) {
        SqlSession session=fa.openSession();
        BackStageBean backStageBean=session.selectOne("com.project.dao.IBackStageDao.selectByNum",num);
        session.close();
        return backStageBean;
    }
}
