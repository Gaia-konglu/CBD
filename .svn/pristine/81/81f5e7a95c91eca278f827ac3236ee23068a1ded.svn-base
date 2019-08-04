package com.project.filter;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.project.dao.impl.timedaoImpl;





@WebFilter(filterName = "TimeFilter",urlPatterns = "/*")
public class TimeFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest) req;

        //请求时的系统时间
        LocalTime time1 = LocalTime.now();


        chain.doFilter(req, resp);

        //响应时的系统时间
        LocalTime time2 = LocalTime.now();
        //计算请求响应耗时
        Duration total = Duration.between(time1, time2);
        String page=request.getRequestURI();
        if(page.contains(".jsp")&&(page.contains("front")||page.contains("tenant")||page.contains("landLady")||page.contains("ccJsp")||page.contains("Infor"))){
        long time=total.toMillis();
        Map<String, Object> map=new HashMap<String, Object>();
        map.put("0", page);
		map.put("1", time);
		ApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");
		timedaoImpl dao=context.getBean(timedaoImpl.class);
		dao.inserttime(map);
		System.out.println(request.getRequestURI() + "耗时：" + total.toMillis());}
    }
	

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
}
