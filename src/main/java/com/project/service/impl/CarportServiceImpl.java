package com.project.service.impl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.bean.CarportBean;
import com.project.bean.PagesBean;
import com.project.bean.ThirdParkContractBean;
import com.project.dao.ICarportDao;
import com.project.dao.impl.CarPortDaoImpl;
import com.project.service.ICarportService;
@Service
public class CarportServiceImpl implements ICarportService {

	@Autowired
	private CarPortDaoImpl dao;
	
	
	@Override
	public List<CarportBean> findAllCarport(PagesBean pb) {
		
	
		
		  
		List<CarportBean> list=dao.findAllCarport(pb.getStartPos(),pb.getPageSize());
		
		
		
		return list;
	}

	@Override
	public String addCarport(CarportBean cpb) {
		
		if(cpb.getAdress().equals("")){
			return "地址不能为空";
		}
		if(cpb.getCarNum().equals("")){
			return "车位编号不能为空";
		}
			
		dao.insertCarport(cpb);
		return "添加成功";
	}

	@Override
	public String addManyCarport(CarportBean cb,String areaId,Integer caportId,Integer carportNum) {
		//数据合法性验证
		if(cb.getAdress().equals("")){
			return "地址不能为空";
		}
		
		if(areaId.equals("")){
			return "车位区域编号不能为空";
		}
		
		if(caportId==null){
			return "车位起始编号错误";
		}
		if(carportNum==null){
			return "车位数量错误";
		}
		
		//用于存储车位的实体类
		List<CarportBean> cblist=new ArrayList<CarportBean>();
		//格式化车位的编号
		  DecimalFormat format = new DecimalFormat("000");
		for(int i=caportId;i<caportId+carportNum;i++){
			CarportBean bean=new CarportBean();
			bean.setAdress(cb.getAdress());
			bean.setCarNum(areaId+format.format(i));
			bean.setTpc(cb.getTpc());
			cblist.add(bean);
		}
		
		dao.insertMany(cblist);
		
		return "添加成功";
	}

	@Override
	public int coutPages() {
		int taotal= dao.countCarport();
		
		return taotal;
	}

	@Override
	public List<CarportBean> findCarportByCondition(PagesBean pb,CarportBean cb) {
		
		 List<CarportBean> cblist=	dao.findByCondition(pb.getStartPos(),pb.getPageSize(),cb);
		
		return cblist;
	}

	@Override
	public int coutPages2(CarportBean cb) {
int taotal= dao.countCarport2(cb);
		
		return taotal;
		
	}

	@Override
	public void updateCarport(CarportBean cpb) {
		dao.updateCarport(cpb);
		
	}

	@Override
	public void deletecarport(int[] carportId) {
		dao.deletecarport(carportId);
		
	}

}
