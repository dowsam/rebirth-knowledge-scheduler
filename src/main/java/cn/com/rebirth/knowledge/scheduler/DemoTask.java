/*
 * Copyright (c) 2005-2012 www.china-cti.com All rights reserved
 * Info:rebirth-knowledge-scheduler DemoTask.java 2012-8-1 11:49:36 l.xue.nong$$
 */
package cn.com.rebirth.knowledge.scheduler;

import cn.com.rebirth.core.schedule.AbstractAppTask;

/**
 * The Class DemoTask.
 *
 * @author l.xue.nong
 */
public class DemoTask extends AbstractAppTask {

	/* (non-Javadoc)
	 * @see cn.com.rebirth.core.schedule.AbstractAppTask#doTask()
	 */
	@Override
	public void doTask() {
		System.out.println(this.getTaskName() + ":获取将被执行的时间:" + this.getNextFireTime() + ":获取上一次被执行的时间:"
				+ this.getPreviousFireTime());
		System.out.println("do task...");
	}

}
