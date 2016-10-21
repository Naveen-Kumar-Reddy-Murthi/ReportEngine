package org.mnr.engine.utilities;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
/**
 * @author naveen.reddy
 * @version 1.0
 */
public class ApplicationContextProvider implements ApplicationContextAware {

	private ApplicationContext applicationContext = null;

	public ApplicationContextProvider() {
		System.out.println("ApplicationContextProvider initialized");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}

	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

}
