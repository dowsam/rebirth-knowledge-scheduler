/*
 * Copyright (c) 2005-2012 www.china-cti.com All rights reserved
 * Info:rebirth-knowledge-scheduler InitContainer.java 2012-8-6 9:26:27 l.xue.nong$$
 */
package cn.com.rebirth.knowledge.scheduler;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.com.rebirth.commons.StopWatch;
import cn.com.rebirth.commons.component.LifecycleListener;
import cn.com.rebirth.commons.exception.RebirthException;
import cn.com.rebirth.commons.exception.RebirthIllegalArgumentException;
import cn.com.rebirth.commons.settings.Settings;
import cn.com.rebirth.commons.utils.SpringContextHolder;
import cn.com.rebirth.core.schedule.TaskSchedulerService;
import cn.com.rebirth.knowledge.scheduler.dao.QuartzDao;
import cn.com.rebirth.knowledge.scheduler.impl.TaskServiceImpl;

/**
 * The Class InitContainer.
 *
 * @author l.xue.nong
 */
public class InitContainer implements LifecycleListener {

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(getClass());

	/** The listener. */
	private LifecycleListener listener;

	/**
	 * The Class TimeConsumingInitContainer.
	 *
	 * @author l.xue.nong
	 */
	public static class TimeConsumingInitContainer implements LifecycleListener {

		/** The application context. */
		private ClassPathXmlApplicationContext applicationContext;

		/* (non-Javadoc)
		 * @see cn.com.rebirth.commons.component.LifecycleListener#beforebirth()
		 */
		@Override
		public void beforebirth() {
			applicationContext = new ClassPathXmlApplicationContext(new String[] { "/applicationContext.xml",
					"/applicationContext-showcases.xml" });
		}

		/* (non-Javadoc)
		 * @see cn.com.rebirth.commons.component.LifecycleListener#afterStart()
		 */
		@Override
		public void afterStart() {
			TaskSchedulerService schedulerService = (TaskSchedulerService) applicationContext
					.getBean("taskSchedulerService");
			schedulerService.start();
			DataSource dataSource = (DataSource) applicationContext.getBean("quartzDataSource");
			ConextHolder.create(new Conext(schedulerService, new QuartzDao((dataSource))));
			//测试
			final TaskServiceImpl impl = SpringContextHolder.getBean(TaskServiceImpl.class);
			for (int i = 0; i < 2; i++) {
				impl.schedule(DemoTask.class, "DemoTask-" + i, "DemoTask-" + i, "0 0/5 * * * ?");
			}
		}

		/* (non-Javadoc)
		 * @see cn.com.rebirth.commons.component.LifecycleListener#beforeStop()
		 */
		@Override
		public void beforeStop() {
			ConextHolder.getInstance().getConext().getTaskSchedulerService().shutdown();
			applicationContext.stop();
		}

		/* (non-Javadoc)
		 * @see cn.com.rebirth.commons.component.LifecycleListener#afterStop()
		 */
		@Override
		public void afterStop() {

		}

		/* (non-Javadoc)
		 * @see cn.com.rebirth.commons.component.LifecycleListener#beforeClose()
		 */
		@Override
		public void beforeClose() {
			applicationContext.close();
		}

		/* (non-Javadoc)
		 * @see cn.com.rebirth.commons.component.LifecycleListener#afterClose()
		 */
		@Override
		public void afterClose() {

		}

	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws SecurityException the security exception
	 * @throws NoSuchMethodException the no such method exception
	 */
	public static void main(String[] args) throws SecurityException, NoSuchMethodException {
		Constructor<?>[] constructors = InitContainer.class.getDeclaredConstructors();
		for (Constructor<?> constructor : constructors) {
			System.out.println(constructor);
		}
		System.out.println(InitContainer.class.getDeclaredConstructor(Settings.class));
	}

	/**
	 * Instantiates a new inits the container.
	 *
	 * @param settings the settings
	 */
	public InitContainer(Settings settings) {
		Class<? extends LifecycleListener> timeConsuming = settings.getAsClass("container.time.consuming.className",
				null);
		if (timeConsuming == null) {
			throw new RebirthIllegalArgumentException("Not Set Continer Time Consuming");
		}
		Constructor<? extends LifecycleListener> constructor = null;
		try {
			constructor = timeConsuming.getDeclaredConstructor(Settings.class);
			listener = constructor.newInstance(settings);
		} catch (Exception e) {
			try {
				constructor = timeConsuming.getDeclaredConstructor();
				listener = constructor.newInstance();
			} catch (Exception e2) {
				throw new RebirthException(e2.getMessage(), e2);
			}
		}
		if (listener == null) {
			throw new RebirthIllegalArgumentException("Set Continer Time Consuming find not Constructor");
		}
	}

	/* (non-Javadoc)
	 * @see cn.com.rebirth.commons.component.LifecycleListener#beforebirth()
	 */
	@Override
	public void beforebirth() {
		timeInvoke("beforebirth");
	}

	/**
	 * Time invoke.
	 *
	 * @param methodName the method name
	 */
	protected void timeInvoke(String methodName) {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		invoke(methodName);
		stopWatch.stop();
		logger.info("Method Name:" + methodName + "Time-consuming:" + stopWatch.totalTime());
	}

	/**
	 * Invoke.
	 *
	 * @param methodName the method name
	 */
	protected void invoke(String methodName) {
		try {
			invoke(LifecycleListener.class.getDeclaredMethod(methodName));
		} catch (Exception e) {
			throw new RebirthException(e.getMessage(), e);
		}
	}

	/**
	 * Invoke.
	 *
	 * @param method the method
	 * @param args the args
	 */
	protected void invoke(Method method, Object... args) {
		try {
			method.invoke(listener, args);
		} catch (Exception e) {
			throw new RebirthException(e.getMessage(), e);
		}
	}

	/* (non-Javadoc)
	 * @see cn.com.rebirth.commons.component.LifecycleListener#afterStart()
	 */
	@Override
	public void afterStart() {
		timeInvoke("afterStart");
	}

	/* (non-Javadoc)
	 * @see cn.com.rebirth.commons.component.LifecycleListener#beforeStop()
	 */
	@Override
	public void beforeStop() {
		timeInvoke("beforeStop");
	}

	/* (non-Javadoc)
	 * @see cn.com.rebirth.commons.component.LifecycleListener#afterStop()
	 */
	@Override
	public void afterStop() {
		timeInvoke("afterStop");
	}

	/* (non-Javadoc)
	 * @see cn.com.rebirth.commons.component.LifecycleListener#beforeClose()
	 */
	@Override
	public void beforeClose() {
		timeInvoke("beforeClose");
	}

	/* (non-Javadoc)
	 * @see cn.com.rebirth.commons.component.LifecycleListener#afterClose()
	 */
	@Override
	public void afterClose() {
		timeInvoke("afterClose");
	}

}
