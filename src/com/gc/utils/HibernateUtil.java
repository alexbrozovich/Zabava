package com.gc.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author 
 * This code is based on code from
 * Ref:http://docs.jboss.org/hibernate/core/3.3/reference/en/html/tutorial.html#tutorial-firstapp-helpers
 *
 * This is a singleton needed to prevent recreating connections that exceed the heroku postages DB connection limit
 */
public class HibernateUtil {

	
	private static SessionFactory factory = buildSessionFacotry();
	
	/**
	 * Private constructor
	 */
	private HibernateUtil() {
	}
	
	/*
	 * Build session factory
	 */
	private static SessionFactory buildSessionFacotry(){
		try {
			
		
			Configuration cfg = new Configuration().configure("hibernate.cfg.xml");	
			return cfg.configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}		
	}
	/*
	 * Method controlling access to session factory
	 */
	public static SessionFactory getSessionFactory(){		
		return factory;
	}
}

