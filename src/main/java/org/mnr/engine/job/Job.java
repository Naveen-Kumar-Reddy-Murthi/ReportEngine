package org.mnr.engine.job;

import java.text.ParseException;
import org.apache.commons.mail.EmailException;
import org.mnr.engine.utilities.ApplicationContextProvider;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

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

	public void task() throws InterruptedException {

		JobService service = new JobService();

		try {
			service.executeService();
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;

	}

}
