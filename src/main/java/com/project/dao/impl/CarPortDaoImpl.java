package com.project.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.bean.CarportBean;
import com.project.bean.PagesBean;
import com.project.dao.ICarportDao; 

@Repository
public class CarPortDaoImpl implements ICarportDao {
	
	@Autowired
	private SqlSessionFactory fa;

	@Override
	public CarportBean findById(int carId) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 查询所有的CBD车位信息
	 */
	@Override
	public List<CarportBean> findAllCarport(int startPos,int pageSize) {
		
		  SqlSession session=fa.openSession();
		  
		  ICarportDao dao= session.getMapper(ICarportDao.class);
		
		  List<CarportBean> cblist=dao.findAllCarport(startPos, pageSize);
		   session.close();
		    return cblist;
	}

	/**
	 * 添加CBD车位信息
	 */
	@Override
	public void insertCarport(CarportBean cpb) {
	 SqlSession session=fa.openSession();
	 ICarportDao dao=  session.getMapper(ICarportDao.class);
	 dao.insertCarport(cpb);
	 session.commit();
	 session.close();
	}

	@Override
	public void insertMany(List<CarportBean> cblist) {
		SqlSession session=fa.openSession();
		ICarportDao dao=session.getMapper(ICarportDao.class);
		dao.insertMany(cblist);
		session.commit();
           session.close();
	}

	@Override
	public int countCarport() {
		SqlSession session=fa.openSession();
		 ICarportDao dao= session.getMapper(ICarportDao.class);
		 
		 int totalPage= dao.countCarport();
		
		session.close();
	
		return totalPage;
	}

	

	public List<CarportBean> findByCondition(int startPos, int pageSize, CarportBean cb) {

		  SqlSession session=fa.openSession();
		  
		  ICarportDao dao= session.getMapper(ICarportDao.class);
		  Map<String, Object> map=new HashMap<String, Object>();
		  map.put("0", startPos);
		  map.put("1", pageSize);
		  map.put("cb", cb);
		
		  List<CarportBean> cblist=dao.findByCondition(map);
		   session.close();
		    return cblist;
		
	}

	@Override
	public List<CarportBean> findByCondition(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	public int countCarport2(CarportBean cb) {
		SqlSession session=fa.openSession();
		 ICarportDao dao= session.getMapper(ICarportDao.class);
		 int totalPage=0;
		 
		  totalPage= dao.countCarport2(cb);
		
		 
		 
		session.close();
	
		return totalPage;
		
	}

	public void updateCarport(CarportBean cpb) {
		// TODO Auto-generated method stub
		SqlSession session=fa.openSession();
		 ICarportDao dao=  session.getMapper(ICarportDao.class);
		 dao.updateCarport(cpb);
		// System.out.println("更新车位信息");
		 session.commit();
		 session.close();
	}

	public void deletecarport(int[] carportId) {
		SqlSession session=fa.openSession();
		 ICarportDao dao=  session.getMapper(ICarportDao.class);
		 dao.deletecarport(carportId);
		
		 session.commit();
		 session.close();
		
	}

}
