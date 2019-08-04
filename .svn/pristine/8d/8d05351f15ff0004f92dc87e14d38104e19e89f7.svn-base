package com.project.listener;



import java.util.List;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class peopleListener implements HttpSessionListener{
	 public static int userNumber = 0;
//	private List<HttpSession> list;
	    public void sessionCreated(HttpSessionEvent arg0) {
	        userNumber++;
	        System.out.println(userNumber);
//	    	list.add(arg0.getSession());
//	        arg0.getSession().setAttribute("userNumber", userNumber);
//	    	 arg0.getSession().setAttribute("sessions", list);
//	    	 System.out.println(list.size());
	        System.out.println(userNumber);
	    }
	    public void sessionDestroyed(HttpSessionEvent arg0) {
	        if(userNumber>0){userNumber--;}
	        System.out.println(userNumber);
//	    	list.remove(arg0.getSession());
//	        arg0.getSession().setAttribute("userNumber", userNumber);
//	    	 arg0.getSession().setAttribute("sessions", list);
	    }

}
