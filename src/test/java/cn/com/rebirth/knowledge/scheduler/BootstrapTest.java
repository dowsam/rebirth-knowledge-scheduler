package cn.com.rebirth.knowledge.scheduler;

import java.io.IOException;
import java.sql.SQLException;

import cn.com.rebirth.service.middleware.server.Bootstrap;

public class BootstrapTest {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws IOException, SQLException {
		System.setProperty("zk.zkConnect", "192.168.2.179:2181");
		System.setProperty("rebirth.service.middleware.container.className",
				"cn.com.rebirth.knowledge.scheduler.InitContainer");
		System.setProperty("rebirth.service.middleware.container.time.consuming.className",
				"cn.com.rebirth.knowledge.scheduler.InitContainer$TimeConsumingInitContainer");
		System.setProperty("rebirth.service.middleware.development.model", "true");
		Bootstrap.main(args);
		if (System.in.read() != 0) {
			Bootstrap.close(args);
			System.exit(0);
		}
	}
}
