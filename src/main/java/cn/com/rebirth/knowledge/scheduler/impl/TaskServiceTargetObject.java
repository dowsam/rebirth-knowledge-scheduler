/*
 * Copyright (c) 2005-2012 www.china-cti.com All rights reserved
 * Info:rebirth-knowledge-scheduler TaskServiceTargetObject.java 2012-8-1 14:13:03 l.xue.nong$$
 */
package cn.com.rebirth.knowledge.scheduler.impl;

import cn.com.rebirth.commons.utils.SpringContextHolder;
import cn.com.rebirth.service.middleware.server.support.TargetObjectContainer;

/**
 * The Class TaskServiceTargetObject.
 *
 * @author l.xue.nong
 */
public class TaskServiceTargetObject implements TargetObjectContainer<TaskServiceImpl> {

	/* (non-Javadoc)
	 * @see cn.com.rebirth.service.middleware.server.support.TargetObjectContainer#find(java.lang.Class)
	 */
	@Override
	public TaskServiceImpl find(Class<?> targetObjectClass) {
		return (TaskServiceImpl) SpringContextHolder.getBean(targetObjectClass);
	}

}
