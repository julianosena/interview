package com.musictips.pcm.pcmdiscoveryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class PcmDiscoveryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PcmDiscoveryServiceApplication.class, args);
	}
}
