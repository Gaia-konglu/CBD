package com.project.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.project.bean.BookInforBean;
import com.project.bean.PartingSpaceBean;
import com.project.bean.PersonBean;
import com.project.bean.RentInforBean;
import com.project.dao.ILandLadyDao;
import com.project.bean.OrderBean;
import com.project.service.ILandLadyService;
import com.project.service.ITenantService;
import com.project.util.RandomUtil;

public class Test_kong {
	
	/*
	 * 包租婆类业务测试
	 */
	//测试登录信息
	@Test
	public void testFindLandLady(){
		ApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");
		ILandLadyService service = context.getBean("landLadyServiceImpl",ILandLadyService.class);
		PersonBean bean = service.login("被投诉方", "12345", 1);
		System.out.println(bean);
	}
	
	//测试添加个人车位信息
	@Test
	public void testAddPartingSpace(){
		ApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");
		ILandLadyService service = context.getBean("landLadyServiceImpl",ILandLadyService.class);
		PersonBean bean =new PersonBean();
		bean.setId(1);
		
		PartingSpaceBean part = new PartingSpaceBean();
		part.setAddr("成都市武侯区");
		part.setCarNum("12121212");
		part.setPropertyNum("1234456");
		part.setPerson(bean);
		
		service.addPartingSpace(part);
		
	}
	//测试通过ID查个人车位信息
		@Test
		public void testFindById2(){
			ApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");
			ILandLadyService service = context.getBean("landLadyServiceImpl",ILandLadyService.class);
			PersonBean bean = new PersonBean();
			bean.setId(4);
			List<PartingSpaceBean> part = service.findMyPartInfor(bean,1);
			for (PartingSpaceBean partingSpaceBean : part) {
				System.out.println(partingSpaceBean);
			}
		
		}
	
		//测试查询包租婆招租信息
		@Test
		public void testFindRentInfor(){
			ApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");
			ILandLadyService service = context.getBean("landLadyServiceImpl",ILandLadyService.class);
			PersonBean bean = new PersonBean();
			bean.setId(4);
			List<RentInforBean> part = service.findMyRentInfor(bean,1);
			for (RentInforBean rentInforBean : part) {
				System.out.println(rentInforBean);
			}
			
		}
	//测试添加招租车位信息
	@Test
	public void testAddRentInfor(){
		ApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");
		ILandLadyService service = context.getBean("landLadyServiceImpl",ILandLadyService.class);
		PartingSpaceBean part = new PartingSpaceBean();
		part.setId(1);
		
		RentInforBean rent = new RentInforBean();
		rent.setStartTime("2018-09-12");
		rent.setEndTime("2018-09-23");
		rent.setPrice(123.45);
		rent.setPersonCarSpaceInfor(part);
		service.addRentInfor(rent);
		
	}
	//查询所有预定车位信息
	@Test
	public void testFindAllBookInfor(){
		ApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");
		ILandLadyService service = context.getBean("landLadyServiceImpl",ILandLadyService.class);
		PersonBean landLady = new PersonBean();
		landLady.setId(4);
		List<BookInforBean> list = service.checkBookInfor(landLady,1);
		for (BookInforBean bookInforBean : list) {
			System.out.println(bookInforBean);
		}
		
	}
	//查询预定信息总页数
	@Test
	public void testBookInforTotal(){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");
		ILandLadyService service = context.getBean("landLadyServiceImpl",ILandLadyService.class);
		PersonBean landLady = new PersonBean();
		landLady.setId(4);
		System.out.println(service.findBookInforTotalPage(landLady));
	}
	//更新预定信息状态
	@Test
	public void testUpdateStatus(){
		ApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");
		ILandLadyService service = context.getBean("landLadyServiceImpl",ILandLadyService.class);
		BookInforBean book = new BookInforBean();
		book.setId(13);
		book.setOrder(RandomUtil.getRandom());
		service.updateStatus(book);
	}
	//查询历史交易信息
	@Test
	public void testTradeInfor(){
		ApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");
		ILandLadyService service = context.getBean("landLadyServiceImpl",ILandLadyService.class);
		PersonBean bean =new PersonBean();
		bean.setId(4);
		
		List<OrderBean> order = service.checkTradeInfor(bean,1);
		for (OrderBean orderBean : order) {
			System.out.println(orderBean);
		}
	}
		//查询交易记录总数
		@Test
		public void testTradeInforTotal(){
			
			ApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");
			ILandLadyService service = context.getBean("landLadyServiceImpl",ILandLadyService.class);
			PersonBean landLady = new PersonBean();
			landLady.setId(4);
			System.out.println(service.findTradeInforTotalPage(landLady));
		}
	//测试删除停车位信息
	@Test
	public void testDeletePart(){
		ApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");
		ILandLadyService service = context.getBean("landLadyServiceImpl",ILandLadyService.class);
	 service.deletePart(16);
		
	}
	
	/*
	 * 抢租客类业务测试
	 */
	//查询所有招租信息
	@Test
	public void testFindAllRentInfor(){
		ApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");
		ITenantService service = context.getBean("tenantServiceImpl",ITenantService.class);
		RentInforBean rent=new RentInforBean();
		rent.setStartTime("");
		rent.setEndTime("");
		List<RentInforBean> list = service.checkAllRentInfor(rent,2);
		for (RentInforBean rentInforBean : list) {
			System.out.println(rentInforBean);
		}
		
	}
	//查找总页数
			@Test
			public void testFindTotalPage(){
				ApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");
				ITenantService service = context.getBean("tenantServiceImpl",ITenantService.class);
				RentInforBean rent=new RentInforBean();
				rent.setStartTime("");
				rent.setEndTime("");
				System.out.println(service.findTotalPages(rent));
			}

		//查询招租婆ID
		@Test
		public void testFindLandLadyId(){
			ApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");
			ITenantService service = context.getBean("tenantServiceImpl",ITenantService.class);
			int id = service.findLandLadyId(8);
			System.out.println(id);
			
		}
		//添加预定信息
		@Test
		public void testAddBookInfor(){
			ApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");
			ITenantService service = context.getBean("tenantServiceImpl",ITenantService.class);
			RentInforBean rentInfor = new RentInforBean();
			rentInfor.setId(12);
			PersonBean landLady = new PersonBean();
			landLady.setId(4);
			PersonBean tenant = new PersonBean();
			tenant.setId(3);
			String message = "车位位置太远";
			service.addBookInfor(rentInfor, tenant,landLady, message);
			
		}
	//查询可支付预定信息
		@Test
		public void testCheckPayBookInfor(){
			ApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");
			ITenantService service = context.getBean("tenantServiceImpl",ITenantService.class);
			List<BookInforBean>list = service.checkPayBookInfor(7);
			for (BookInforBean bookInforBean : list) {
				System.out.println(bookInforBean);
			}
		}
		
		//测试页面查询
		@Test
		public void testFindByPage(){
			ApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");
			ITenantService service = context.getBean("tenantServiceImpl",ITenantService.class);
			RentInforBean rent = new RentInforBean();
			rent.setStartTime("");
			rent.setEndTime("");
			List<RentInforBean> list = service.checkAllRentInfor(rent,3);
			for (RentInforBean rentInforBean : list) {
				System.out.println(rentInforBean);
			}
		}
		//获取随机数
		@Test
		public void testGetRandom(){
			System.out.println(RandomUtil.getRandom());
			
		}
		//添加交易信息
		@Test
		public void testAddTrade(){
			ApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");
			ITenantService service = context.getBean("tenantServiceImpl",ITenantService.class);
			OrderBean order = new OrderBean();
			order.setId("13");
			order.setLid(3);
			order.setRid(4);
			order.setTid(3);
			order.setTradeTime("2018-12-12");
			service.addTradeInfor(order);
		}
		//查询历史交易信息
		@Test
		public void testTenantTradeInfor(){
			ApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");
			ILandLadyService service = context.getBean("landLadyServiceImpl",ILandLadyService.class);
			PersonBean bean =new PersonBean();
			bean.setId(7);
			
			List<OrderBean> order = service.checkTradeInfor(bean,1);
			for (OrderBean orderBean : order) {
				System.out.println(orderBean);
			}
		}
			//查询交易记录总数
			@Test
			public void testTenantTradeInforTotal(){
				
				ApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");
				ILandLadyService service = context.getBean("landLadyServiceImpl",ILandLadyService.class);
				PersonBean landLady = new PersonBean();
				landLady.setId(4);
				System.out.println(service.findTradeInforTotalPage(landLady));
			}
}
