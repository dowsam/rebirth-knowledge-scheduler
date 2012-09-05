/*
 * Copyright (c) 2005-2012 www.china-cti.com All rights reserved
 * Info:rebirth-knowledge-scheduler SchedulerPassiveSettingsImpl.java 2012-8-28 14:21:48 l.xue.nong$$
 */
package cn.com.rebirth.knowledge.scheduler;

import cn.com.rebirth.commons.settings.Settings;
import cn.com.rebirth.core.inject.InjectInitialization;
import cn.com.rebirth.knowledge.commons.AbstractSettingsShare;
import cn.com.rebirth.knowledge.commons.SchedulerPassiveSettings;

/**
 * The Class SchedulerPassiveSettingsImpl.
 *
 * @author l.xue.nong
 */
public class SchedulerPassiveSettingsImpl extends AbstractSettingsShare implements SchedulerPassiveSettings {

	/* (non-Javadoc)
	 * @see cn.com.rebirth.knowledge.commons.AbstractSettingsShare#passive(cn.com.rebirth.commons.settings.Settings)
	 */
	@Override
	public void passive(Settings settings) {
		System.out.println(settings.getAsBoolean("switchSql", null));
		settings.getAsMap().put("waySql", SchedulerDbWaySql.class.getName());
		InjectInitialization.injector().getInstance(Settings.class).getAsMap().putAll(settings.getAsMap());
	}

}
