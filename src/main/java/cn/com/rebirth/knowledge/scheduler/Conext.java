/*
 * Copyright (c) 2005-2012 www.china-cti.com All rights reserved
 * Info:rebirth-knowledge-scheduler Conext.java 2012-8-1 15:02:44 l.xue.nong$$
 */
package cn.com.rebirth.knowledge.scheduler;

import cn.com.rebirth.core.schedule.TaskSchedulerService;
import cn.com.rebirth.knowledge.scheduler.dao.QuartzDao;

/**
 * The Class Conext.
 *
 * @author l.xue.nong
 */
public final class Conext {

	/** The task scheduler service. */
	private final TaskSchedulerService taskSchedulerService;

	/** The quartz dao. */
	private final QuartzDao quartzDao;

	/**
	 * Instantiates a new conext.
	 *
	 * @param taskSchedulerService the task scheduler service
	 * @param quartzDao the quartz dao
	 */
	public Conext(TaskSchedulerService taskSchedulerService, QuartzDao quartzDao) {
		super();
		this.taskSchedulerService = taskSchedulerService;
		this.quartzDao = quartzDao;
	}

	/**
	 * Gets the task scheduler service.
	 *
	 * @return the task scheduler service
	 */
	public TaskSchedulerService getTaskSchedulerService() {
		return taskSchedulerService;
	}

	/**
	 * Gets the quartz dao.
	 *
	 * @return the quartz dao
	 */
	public QuartzDao getQuartzDao() {
		return quartzDao;
	}

}
