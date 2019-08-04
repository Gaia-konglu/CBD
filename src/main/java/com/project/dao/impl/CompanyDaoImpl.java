package com.project.dao.impl;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import com.project.bean.CarportBean;
import com.project.bean.CompanyBean;
import com.project.bean.PersonBean;
import com.project.dao.ICompanyDao;

@Repository
public class CompanyDaoImpl implements ICompanyDao{
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory = null;
	
	@Override
	public List<CompanyBean> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CompanyBean selectById(Integer id) {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		CompanyBean cb=session.selectOne("com.project.dao.ICompanyDao.getCompanyById",id);
		return cb;
	}

	
	@Override
	public Integer selectByObj(CompanyBean company) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CompanyBean getConpanyUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(CompanyBean cb) {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		int row=session.update("com.project.dao.ICompanyDao.changeCompanyInfo",cb);
		if(row>0){return true;}
		return false;
	}
	
	//根据企业登录名查询企业名称
	@Override
	public CompanyBean findCompanyNameByAdmin(String admin) {
		System.out.println("dao实现类admin:"+admin);
		SqlSession session = sqlSessionFactory.openSession();
		CompanyBean bean = null;
		/*bean = session.selectOne("mapper1.findCompanyNameByAdmin",admin);*/
		ICompanyDao dao = session.getMapper(ICompanyDao.class);
		System.out.println("dao层根据登录名查询CompanyBean之前");
		bean = dao.findCompanyNameByAdmin(admin);
		System.out.println("dao层根据登录名查询到的CompanyBean:"+bean);
		
		/*System.out.println("(bean.getName()):"+(bean.getName()));
		System.out.println("(bean.getName()).length():"+(bean.getName()).length());*/
		
		session.close();
		return bean;
	}
	//企业已租赁车位模糊查询
	@Override
	public List<CarportBean> findCompanyAlreadyRentedFuzzyQuery(int index, String name, String addr, String p_number,
			String b_number, String start_time, String end_time) {
		System.out.println("进入到dao实现类findCompanyAlreadyRentedFuzzyQuery方法中");
		SqlSession session = sqlSessionFactory.openSession();
		ICompanyDao dao = session.getMapper(ICompanyDao.class);
		List<CarportBean> list = dao.findCompanyAlreadyRentedFuzzyQuery(index,name,addr,p_number,b_number,start_time,end_time);
		System.out.println("list.size():"+list.size());
		session.close();
		return list;
	}
	//企业已租赁车位模糊查询总数量（分页）
	@Override
	public Integer findCompanyAlreadyRentedFuzzyQueryTotalNum(String name, String addr, String p_number,
			String b_number, String start_time, String end_time) {
		System.out.println("进入到dao实现类findCompanyAlreadyRentedFuzzyQueryTotalNum方法中");
		SqlSession session = sqlSessionFactory.openSession();
		ICompanyDao dao = session.getMapper(ICompanyDao.class);
		int num = dao.findCompanyAlreadyRentedFuzzyQueryTotalNum(name,addr,p_number,b_number,start_time,end_time);
		session.close();
		return num;
	}
	//CBD平台未租赁车位模糊查询
	@Override
	public List<CarportBean> findCompanyNotRentedFuzzyQuery(int index, String addr, String p_number, String end_time) {
		System.out.println("进入dao实现类，index:"+index);
		SqlSession session = sqlSessionFactory.openSession();
		List<CarportBean> list = null;
		/*list = session.selectList("mapper1.findCompanyNotRentedParkingSpaceByCompanyName",name);*/
		ICompanyDao dao = session.getMapper(ICompanyDao.class);
		list = dao.findCompanyNotRentedFuzzyQuery(index,addr,p_number,end_time);
		System.out.println("dao层CDB车位管理平台系统的未租赁的空闲车位list.size():"+list.size());
		session.close();
		return list;
	}
	//CBD平台未租赁车位模糊查询总数量（分页）
	@Override
	public Integer findCompanyNotRentedFuzzyQueryTotalNum(String addr, String p_number, String end_time) {
		SqlSession session = sqlSessionFactory.openSession();
		ICompanyDao dao = session.getMapper(ICompanyDao.class);
		int num = dao.findCompanyNotRentedFuzzyQueryTotalNum(addr,p_number,end_time);
		session.close();
		return num;
	}
	//根据输入企业名称、楼层位置、联系人以及联系电话的模糊查找功能
	@Override
	public List<CompanyBean> findCompany(CompanyBean companyBean,int index) {
		SqlSession session = sqlSessionFactory.openSession();
		List<CompanyBean> list = null;
		ICompanyDao dao = session.getMapper(ICompanyDao.class);
		list = dao.findCompany(companyBean,index);
		System.out.println("dao层模糊查找功能企业list:"+list);
		session.close();
		return list;
	}
	//查询模糊查询企业总数量（分页）
	@Override
	public Integer findCompanyTotalNum(CompanyBean companyBean) {
		SqlSession session = sqlSessionFactory.openSession();
		ICompanyDao dao = session.getMapper(ICompanyDao.class);
		Integer index = dao.findCompanyTotalNum(companyBean);
		session.close();
		return index;
	}
	//根据输入企业信息进行新增企业
	@Override
	public boolean addCompany(CompanyBean companyBean) {
		SqlSession session = sqlSessionFactory.openSession();
		/*ICompanyDao dao = session.getMapper(ICompanyDao.class);*/
		int row = session.insert("com.project.dao.ICompanyDao.addCompany",companyBean);
		session.close();
		if(row == 1){
			return true;
		}else{
			return false;
		}
	}
	//删除企业（软删除）
	@Override
	public boolean deleteCompany(int id) {
		SqlSession session = sqlSessionFactory.openSession();
		int row = session.update("com.project.dao.ICompanyDao.deleteCompany",id);
		session.close();
		if(row == 1){
			return true;
		}else{
			return false;
		}
	}
	//后台进行企业信息的修改
	@Override
	public boolean companyBackstageModify(CompanyBean companyBean) {
		SqlSession session = sqlSessionFactory.openSession();
		int row = session.update("com.project.dao.ICompanyDao.companyBackstageModify",companyBean);
		session.close();
		if(row == 1){
			return true;
		}else{
			return false;
		}
	}
	//查询企业是否已存在
	//通过id来查询
	@Override
    public CompanyBean selectIsExistByCompanyId(Integer id) {
        SqlSession session=sqlSessionFactory.openSession();
        CompanyBean companyBean=session.selectOne("com.project.dao.ICompanyDao.selectIsExistByCompanyId",id);
        session.close();
        return companyBean;
    }
	//通过name来查询
	@Override
    public CompanyBean selectIsExistByCompanyName(String name) {
        SqlSession session=sqlSessionFactory.openSession();
        CompanyBean companyBean=session.selectOne("com.project.dao.ICompanyDao.selectIsExistByCompanyName",name);
        session.close();
        System.out.println("现在在dao实现类selectIsExistByCompanyName，马上返回");
        System.out.println("dao层bean:"+companyBean);
        return companyBean;
    }
	 @Override
	    public CompanyBean selectByName(String admin) {
	        SqlSession session=sqlSessionFactory.openSession();
	        CompanyBean companyBean=session.selectOne("com.project.dao.ICompanyDao.selectByName",admin);
	        session.close();
	        return companyBean;
	    }
}
