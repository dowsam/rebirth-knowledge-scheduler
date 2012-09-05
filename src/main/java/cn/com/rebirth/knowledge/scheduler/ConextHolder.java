/*
 * Copyright (c) 2005-2012 www.china-cti.com All rights reserved
 * Info:rebirth-knowledge-scheduler ConextHolder.java 2012-8-1 11:45:11 l.xue.nong$$
 */
package cn.com.rebirth.knowledge.scheduler;

/**
 * The Class ConextHolder.
 *
 * @author l.xue.nong
 */
public class ConextHolder {

	/** The singleton. */
	private static volatile ConextHolder singleton;

	/** The conext. */
	private static volatile Conext conext;

	/**
	 * Instantiates a new conext holder.
	 *
	 * @param conext the conext
	 */
	private ConextHolder(Conext conext) {
		super();
		ConextHolder.conext = conext;
	}

	/**
	 * Creates the.
	 *
	 * @param conext the conext
	 * @return the conext holder
	 */
	public static ConextHolder create(Conext conext) {
		if (singleton != null) {
			return singleton;
		}
		synchronized (ConextHolder.class) {
			if (singleton == null) {
				singleton = new ConextHolder(conext);
			}
			return singleton;
		}
	}

	/**
	 * Gets the single instance of ConextHolder.
	 *
	 * @return single instance of ConextHolder
	 */
	public static ConextHolder getInstance() {
		return create(conext);
	}

	/**
	 * Gets the conext.
	 *
	 * @return the conext
	 */
	public Conext getConext() {
		return conext;
	}

}
