package com.project.dao;

import java.util.List;
import java.util.Map;

import com.project.bean.TimeBean;

public interface timedao {
	public void inserttime(Map<String, Object> map);
	public List<TimeBean> selectAll();
}
