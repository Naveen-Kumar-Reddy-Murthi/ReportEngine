package org.mnr.engine.job;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.mail.EmailException;
import org.hibernate.SessionFactory;
import org.mnr.engine.utilities.ApplicationContextProvider;
import org.quartz.JobExecutionContext;
import org.quartz.SchedulerContext;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;

/**
 * @author naveen.reddy
 * @version 1.0
 */
public class Job implements ApplicationContextAware {
	@Autowired
	private ApplicationContextProvider appContext;
	@Autowired
	private ApplicationContext applicationContext;
	
	public void setAppContext(ApplicationContextProvider appContext) {
		this.appContext = appContext;
	}


	public void task() throws InterruptedException{
//		SimpleDateFormat sdf	=	new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
//		System.out.println("Job started at "+sdf.format(System.currentTimeMillis()));
//		SchedulerContext schedulerContext = JobExecutionContext.getScheduler().getContext();
//		ApplicationContext applicationContext = (ApplicationContext)schedulerContext.get("applicationContext");
		
//		test();
		
//		SessionFactory sessionFactory	=	(SessionFactory) applicationContext.getBean("sessionFactory",AnnotationSessionFactoryBean.class);
//		
//		System.out.println(sessionFactory.openSession().createSQLQuery("select * from employee").list());
		
		JobService	service	=	new JobService();	
		
		//service.generateReport("select * from employee");
//		System.out.println("Job Method");
//		JobService service = new JobService();
		try {
			service.executeService();
//			System.out.println("after execute service");
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		System.out.println("Job  Ended    at "+sdf.format(System.currentTimeMillis()));
		
	}
	
	public void test(){
//		ApplicationContext appC	=	appContext.getApplicationContext();
		SessionFactory sessionFactory	=	(SessionFactory) applicationContext.getBean("sessionFactory");
		System.out.println(sessionFactory.hashCode());
		System.out.println(sessionFactory.openSession().createQuery("select * from report_schedule").list().toString());
	}


	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext=applicationContext;
		
	}

}
