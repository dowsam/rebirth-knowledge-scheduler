/*
 * Copyright (c) 2005-2012 www.china-cti.com All rights reserved
 * Info:rebirth-knowledge-scheduler SettingsBuffer.java 2012-8-28 11:31:36 l.xue.nong$$
 */
package cn.com.rebirth.knowledge.scheduler;

import cn.com.rebirth.commons.settings.Settings;
import cn.com.rebirth.core.inject.AbstractBusiness;
import cn.com.rebirth.core.inject.Business;
import cn.com.rebirth.core.inject.Injector;
import cn.com.rebirth.core.inject.ModulesBuilder;
import cn.com.rebirth.core.settings.SettingsModule;
import cn.com.rebirth.knowledge.commons.InitiativeSettings;
import cn.com.rebirth.service.middleware.client.ConsumerProxyFactory;

/**
 * The Class SettingsBuffer.
 *
 * @author l.xue.nong
 */
public class SettingsBuffer extends AbstractBusiness implements Business {

	/* (non-Javadoc)
	 * @see cn.com.rebirth.core.inject.AbstractBusiness#toAfterConfigure(cn.com.rebirth.core.inject.Injector)
	 */
	@Override
	protected void toAfterConfigure(Injector injector) {
	}

	/* (non-Javadoc)
	 * @see cn.com.rebirth.core.inject.Business#toModules(cn.com.rebirth.core.inject.ModulesBuilder)
	 */
	@Override
	public void toModules(ModulesBuilder modulesBuilder) {
		InitiativeSettings initiativeSettings = ConsumerProxyFactory.getInstance().proxy(InitiativeSettings.class);
		Settings settings = initiativeSettings.initiative();
		settings.getAsMap().put("waySql", SchedulerDbWaySql.class.getName());
		modulesBuilder.add(new SettingsModule(settings));
	}

}
