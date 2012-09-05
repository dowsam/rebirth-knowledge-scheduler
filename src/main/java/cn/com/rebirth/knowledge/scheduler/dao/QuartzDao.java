/*
 * Copyright (c) 2005-2012 www.china-cti.com All rights reserved
 * Info:rebirth-knowledge-scheduler QuartzDao.java 2012-8-6 9:26:12 l.xue.nong$$
 */
package cn.com.rebirth.knowledge.scheduler.dao;

import java.util.Collection;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.rebirth.core.jdbc.JdbcDao;
import cn.com.rebirth.knowledge.commons.scheduler.QrtzTriggersJobDetails;

/**
 * The Class QuartzDao.
 *
 * @author l.xue.nong
 */
public class QuartzDao extends JdbcDao {

	/** The logger. */
	protected final Logger logger = LoggerFactory.getLogger(getClass());

	/** The query quartz sql. */
	protected static String QUERY_QUARTZ_SQL = "SELECT t.*,(SELECT t2.DESCRIPTION FROM QRTZ_JOB_DETAILS t2 WHERE t2.JOB_NAME=t.JOB_NAME AND t2.JOB_GROUP=t.JOB_GROUP) AS JOB_DETAILS_DESCRIPTION,(SELECT t3.JOB_CLASS_NAME FROM QRTZ_JOB_DETAILS t3 WHERE t3.JOB_NAME=t.JOB_NAME AND t3.JOB_GROUP=t.JOB_GROUP) AS JOB_DETAILS_JOB_CLASS_NAME,(select rr.CRON_EXPRESSION from QRTZ_CRON_TRIGGERS rr where rr.TRIGGER_NAME=t.TRIGGER_NAME) as cronExpression FROM QRTZ_TRIGGERS t ORDER BY t.START_TIME";

	/**
	 * Instantiates a new quartz dao.
	 *
	 * @param dataSource the data source
	 */
	public QuartzDao(DataSource dataSource) {
		super(dataSource);
	}

	/**
	 * Gets the qrtz triggers.
	 *
	 * @param pageRequest the page request
	 * @return the qrtz triggers
	 */
	public Collection<QrtzTriggersJobDetails> getQrtzTriggers() {
		return find(QUERY_QUARTZ_SQL, QrtzTriggersJobDetails.class);
	}

}
