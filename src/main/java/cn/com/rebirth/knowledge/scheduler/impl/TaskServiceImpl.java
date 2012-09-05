/*
 * Copyright (c) 2005-2012 www.china-cti.com All rights reserved
 * Info:rebirth-knowledge-scheduler TaskServiceImpl.java 2012-8-1 13:55:17 l.xue.nong$$
 */
package cn.com.rebirth.knowledge.scheduler.impl;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.rebirth.core.schedule.AbstractAppTask;
import cn.com.rebirth.core.schedule.TaskSchedulerService;
import cn.com.rebirth.knowledge.commons.scheduler.QrtzTriggersJobDetails;
import cn.com.rebirth.knowledge.commons.scheduler.TaskService;
import cn.com.rebirth.knowledge.scheduler.ConextHolder;
import cn.com.rebirth.knowledge.scheduler.dao.QuartzDao;

/**
 * The Class TaskServiceImpl.
 *
 * @author l.xue.nong
 */
@Service
@Transactional
public class TaskServiceImpl implements TaskService {

	/**
	 * Gets the task scheduler service.
	 *
	 * @return the task scheduler service
	 */
	protected TaskSchedulerService getTaskSchedulerService() {
		return ConextHolder.getInstance().getConext().getTaskSchedulerService();
	}

	protected QuartzDao getQuartzDao() {
		return ConextHolder.getInstance().getConext().getQuartzDao();
	}

	/* (non-Javadoc)
	 * @see cn.com.rebirth.core.schedule.SchedulerService#pauseTask(java.lang.String)
	 */
	@Override
	public void pauseTask(String taskName) {
		getTaskSchedulerService().pauseTask(taskName);
	}

	/* (non-Javadoc)
	 * @see cn.com.rebirth.core.schedule.SchedulerService#deleteTask(java.lang.String)
	 */
	@Override
	public void deleteTask(String taskName) {
		getTaskSchedulerService().deleteTask(taskName);
	}

	/* (non-Javadoc)
	 * @see cn.com.rebirth.core.schedule.SchedulerService#resumeTask(java.lang.String)
	 */
	@Override
	public void resumeTask(String taskName) {
		getTaskSchedulerService().resumeTask(taskName);
	}

	/* (non-Javadoc)
	 * @see cn.com.rebirth.core.schedule.SchedulerService#schedule(java.lang.Class, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public <T extends AbstractAppTask> void schedule(Class<T> appTaskClass, String taskName, String description,
			String timeExpression) {
		getTaskSchedulerService().schedule(appTaskClass, taskName, description, timeExpression);
	}

	/* (non-Javadoc)
	 * @see cn.com.rebirth.core.schedule.SchedulerService#scheduleDialy(java.lang.Class, java.lang.String, java.lang.String, int, int)
	 */
	@Override
	public <T extends AbstractAppTask> void scheduleDialy(Class<T> appTaskClass, String taskName, String description,
			int hour, int minute) {
		getTaskSchedulerService().scheduleDialy(appTaskClass, taskName, description, hour, minute);
	}

	/* (non-Javadoc)
	 * @see cn.com.rebirth.core.schedule.SchedulerService#scheduleWeekly(java.lang.Class, java.lang.String, java.lang.String, int, int, int)
	 */
	@Override
	public <T extends AbstractAppTask> void scheduleWeekly(Class<T> appTaskClass, String taskName, String description,
			int dayOfWeek, int hour, int minute) {
		getTaskSchedulerService().scheduleWeekly(appTaskClass, taskName, description, dayOfWeek, hour, minute);
	}

	/* (non-Javadoc)
	 * @see cn.com.rebirth.core.schedule.SchedulerService#scheduleMonthly(java.lang.Class, java.lang.String, java.lang.String, int, int, int)
	 */
	@Override
	public <T extends AbstractAppTask> void scheduleMonthly(Class<T> appTaskClass, String taskName, String description,
			int dayOfMonth, int hour, int minute) {
		getTaskSchedulerService().scheduleMonthly(appTaskClass, taskName, description, dayOfMonth, hour, minute);
	}

	/* (non-Javadoc)
	 * @see cn.com.rebirth.core.schedule.SchedulerService#scheduleImmediate(java.lang.Class, java.lang.String, java.lang.String, int, long)
	 */
	@Override
	public <T extends AbstractAppTask> void scheduleImmediate(Class<T> appTaskClass, String taskName,
			String description, int repeatCount, long repeatInterval) {
		getTaskSchedulerService().scheduleImmediate(appTaskClass, taskName, description, repeatCount, repeatInterval);
	}

	/* (non-Javadoc)
	 * @see cn.com.rebirth.core.schedule.SchedulerService#scheduleHourly(java.lang.Class, java.lang.String, java.lang.String, int)
	 */
	@Override
	public <T extends AbstractAppTask> void scheduleHourly(Class<T> appTaskClass, String taskName, String description,
			int intervalInHours) {
		getTaskSchedulerService().scheduleHourly(appTaskClass, taskName, description, intervalInHours);
	}

	/* (non-Javadoc)
	 * @see cn.com.rebirth.core.schedule.SchedulerService#scheduleHourly(java.lang.Class, java.lang.String, java.lang.String, int, int)
	 */
	@Override
	public <T extends AbstractAppTask> void scheduleHourly(Class<T> appTaskClass, String taskName, String description,
			int intervalInHours, int repeatCount) {
		getTaskSchedulerService().scheduleHourly(appTaskClass, taskName, description, intervalInHours, repeatCount);
	}

	/* (non-Javadoc)
	 * @see cn.com.rebirth.core.schedule.SchedulerService#scheduleMinutely(java.lang.Class, java.lang.String, java.lang.String, int, int)
	 */
	@Override
	public <T extends AbstractAppTask> void scheduleMinutely(Class<T> appTaskClass, String taskName,
			String description, int intervalInMinutes, int repeatCount) {
		getTaskSchedulerService().scheduleMinutely(appTaskClass, taskName, description, intervalInMinutes, repeatCount);
	}

	/* (non-Javadoc)
	 * @see cn.com.rebirth.core.schedule.SchedulerService#scheduleMinutely(java.lang.Class, java.lang.String, java.lang.String, int)
	 */
	@Override
	public <T extends AbstractAppTask> void scheduleMinutely(Class<T> appTaskClass, String taskName,
			String description, int intervalInMinutes) {
		getTaskSchedulerService().scheduleMinutely(appTaskClass, taskName, description, intervalInMinutes);
	}

	/* (non-Javadoc)
	 * @see cn.com.rebirth.core.schedule.SchedulerService#scheduleSecondly(java.lang.Class, java.lang.String, java.lang.String, int, int)
	 */
	@Override
	public <T extends AbstractAppTask> void scheduleSecondly(Class<T> appTaskClass, String taskName,
			String description, int intervalInSeconds, int repeatCount) {
		getTaskSchedulerService().scheduleSecondly(appTaskClass, taskName, description, intervalInSeconds, repeatCount);
	}

	/* (non-Javadoc)
	 * @see cn.com.rebirth.core.schedule.SchedulerService#scheduleSecondly(java.lang.Class, java.lang.String, java.lang.String, int)
	 */
	@Override
	public <T extends AbstractAppTask> void scheduleSecondly(Class<T> appTaskClass, String taskName,
			String description, int intervalInSeconds) {
		getTaskSchedulerService().scheduleSecondly(appTaskClass, taskName, description, intervalInSeconds);
	}

	/* (non-Javadoc)
	 * @see cn.com.rebirth.core.schedule.SchedulerService#start()
	 */
	@Override
	public void start() {
		getTaskSchedulerService().start();
	}

	/* (non-Javadoc)
	 * @see cn.com.rebirth.core.schedule.SchedulerService#pauseAll()
	 */
	@Override
	public void pauseAll() {
		getTaskSchedulerService().pauseAll();
	}

	/* (non-Javadoc)
	 * @see cn.com.rebirth.core.schedule.SchedulerService#resumeAll()
	 */
	@Override
	public void resumeAll() {
		getTaskSchedulerService().resumeAll();
	}

	/* (non-Javadoc)
	 * @see cn.com.rebirth.core.schedule.SchedulerService#shutdown(boolean)
	 */
	@Override
	public void shutdown(boolean waitForJobsToComplete) {
		getTaskSchedulerService().shutdown(waitForJobsToComplete);
	}

	/* (non-Javadoc)
	 * @see cn.com.rebirth.core.schedule.SchedulerService#isShutdown()
	 */
	@Override
	public boolean isShutdown() {
		return getTaskSchedulerService().isShutdown();
	}

	/* (non-Javadoc)
	 * @see cn.com.rebirth.core.schedule.SchedulerService#shutdown()
	 */
	@Override
	public void shutdown() {
		getTaskSchedulerService().shutdown(true);
	}
	@Override
	@Transactional(readOnly = true)
	public Collection<QrtzTriggersJobDetails> getQrtzTriggers() {
		return getQuartzDao().getQrtzTriggers();
	}

}
