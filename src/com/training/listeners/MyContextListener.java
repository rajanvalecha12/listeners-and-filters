package com.training.listeners;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class MyContextListener
 *
 */
public class MyContextListener implements ServletContextListener,ServletContextAttributeListener {

    @Override
	public void attributeAdded(ServletContextAttributeEvent event) {
    	String userName=event.getServletContext().getInitParameter("userName");
    	String passWord=event.getServletContext().getInitParameter("passWord");
    	String className=event.getServletContext().getInitParameter("className");
    	String url=event.getServletContext().getInitParameter("url");
    	try {
			Class.forName(className);
			Connection con = DriverManager.getConnection(url, userName, passWord);
			event.getServletContext().setAttribute("dbConn", con);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
    	
System.out.println("attribute added"+event.getServletContext().getAttributeNames());

    }
	

	@Override
	public void attributeRemoved(ServletContextAttributeEvent event) {
		System.out.println("attribute removed"+event.getServletContext().getAttributeNames());
		
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		return "MyContextListener [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	/**
     * Default constructor. 
     */
    public MyContextListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent event)  {
    	// TODO Auto-generated method stub
    	System.out.println("Context - destroyed =======");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent event)  { 
         // TODO Auto-generated method stub
    	System.out.println("Context - initialized *******");
    }
	
}
