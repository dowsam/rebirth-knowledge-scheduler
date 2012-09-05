/*
 * Copyright (c) 2005-2012 www.china-cti.com All rights reserved
 * Info:rebirth-knowledge-scheduler RebrithKnowledgeShedulerVersion.java 2012-8-1 9:36:27 l.xue.nong$$
 */
package cn.com.rebirth.knowledge.scheduler;

import cn.com.rebirth.commons.AbstractVersion;
import cn.com.rebirth.commons.Version;

/**
 * The Class RebrithKnowledgeShedulerVersion.
 *
 * @author l.xue.nong
 */
public class RebrithKnowledgeShedulerVersion extends AbstractVersion implements Version {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8201673504292023293L;

	/* (non-Javadoc)
	 * @see cn.com.rebirth.commons.Version#getModuleName()
	 */
	@Override
	public String getModuleName() {
		return "Rebirth-Knowledge-Scheduler";
	}

}
