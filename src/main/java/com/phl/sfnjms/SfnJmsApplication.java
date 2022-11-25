package com.phl.sfnjms;

//import org.apache.activemq.artemis.core.config.impl.ConfigurationImpl;
//import org.apache.activemq.artemis.core.server.ActiveMQServer;
//import org.apache.activemq.artemis.core.server.ActiveMQServers;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SfnJmsApplication {

	public static void main(String[] args) throws Exception {

//		createActiveMQServer().start();

		SpringApplication.run(SfnJmsApplication.class, args);
	}

//	private static ActiveMQServer createActiveMQServer() throws Exception {
//		return ActiveMQServers.newActiveMQServer(buildActiveMQServerConfig());
//	}
//
//	private static ConfigurationImpl buildActiveMQServerConfig() throws Exception {
//		return new ConfigurationImpl()
//			.setPersistenceEnabled(false)
//			.setJournalDirectory("target/data/journal")
//			.setSecurityEnabled(false)
//			.addAcceptorConfiguration("invm", "vm://0");
//	}
}
