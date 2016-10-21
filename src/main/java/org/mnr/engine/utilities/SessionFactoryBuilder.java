package org.mnr.engine.utilities;

import java.text.MessageFormat;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/**
 * @author naveen.reddy
 * @version 1.0
 */
public class SessionFactoryBuilder {

	private static SessionFactory sessionFactory = null;

	// Method-1
	static {
		long startTime = System.nanoTime();
		Configuration config = new Configuration().configure();
		sessionFactory = config.buildSessionFactory();
		System.out.println(MessageFormat.format(
				"Configuration loaded in {0} seconds",
				(double) (System.nanoTime() - startTime) / 1000000000));
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	private SessionFactoryBuilder() {
		// restricts initialization
	}

	// Method-2
	/*
	 * public static synchronized SessionFactory getSessionFactory() {
	 * 
	 * if(sessionFactory == null) {//first way // long
	 * startTime=System.nanoTime(); Configuration config = new
	 * Configuration().configure
	 * ("F:\\Git\\Git-LunaWorkSpace\\ReportEngine\\hibernate.cfg.xml");
	 * //Configuration config = new Configuration().configure("hibernate.xml");
	 * sessionFactory=config.buildSessionFactory(); //
	 * System.out.println(MessageFormat
	 * .format("Configuration loaded in {0} seconds",
	 * (double)(System.nanoTime()-startTime)/1000000000)); return
	 * sessionFactory; } return sessionFactory; }
	 */

}
