/*
 * Copyright (c) 2005-2012 www.china-cti.com All rights reserved
 * Info:rebirth-knowledge-scheduler SchedulerDbWaySql.java 2012-8-28 12:06:17 l.xue.nong$$
 */
package cn.com.rebirth.knowledge.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.rebirth.commons.settings.Settings;
import cn.com.rebirth.core.logsql.DbWaySql;
import cn.com.rebirth.core.logsql.LogSqlEntity;
import cn.com.rebirth.knowledge.commons.entity.system.SysLogEntity;
import cn.com.rebirth.knowledge.commons.service.LogService;
import cn.com.rebirth.service.middleware.client.ConsumerProxyFactory;

/**
 * The Class SchedulerDbWaySql.
 *
 * @author l.xue.nong
 */
public class SchedulerDbWaySql extends DbWaySql {
	private Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * Instantiates a new scheduler db way sql.
	 *
	 * @param settings the settings
	 */
	public SchedulerDbWaySql(Settings settings) {
		super(settings);
	}

	/* (non-Javadoc)
	 * @see cn.com.rebirth.core.logsql.DbWaySql#execute(cn.com.rebirth.core.logsql.LogSqlEntity)
	 */
	@Override
	public void execute(LogSqlEntity entity) {
		String methodName = entity.getMethodName();
		if (methodName.length() > 1000) {
			methodName = methodName.substring(0, 1000);
		}
		if (methodName.indexOf("(") != -1) {
			methodName = methodName.substring(0, methodName.indexOf("("));
		}
		entity.setMethodName(methodName);
		SysLogEntity sysLogEntity = new SysLogEntity();
		sysLogEntity.setLogContext(getLogMessage(entity).getBytes());
		logger.debug("Log Info:" + sysLogEntity.getAppIp() + "," + sysLogEntity.getAppName() + ","
				+ sysLogEntity.getCreateTime());
		LogService logService = ConsumerProxyFactory.getInstance().proxy(LogService.class);
		logService.addLog(sysLogEntity);
	}

}
