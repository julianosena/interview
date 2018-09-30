package com.musictips.thermometer;

import com.musictips.thermometer.gateway.database.model.SugestorMusicTrackTemperatureConfig;
import com.musictips.thermometer.gateway.database.repository.SugestorMusicTrackTemperatureConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

import javax.annotation.PostConstruct;

@SpringBootApplication(scanBasePackages = "com.musictips")
@EnableAutoConfiguration
@EnableDiscoveryClient
@EnableHystrixDashboard
@EnableCircuitBreaker
public class ThermometerMusicTipsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThermometerMusicTipsServiceApplication.class, args);
	}

	@Autowired
	SugestorMusicTrackTemperatureConfigRepository repository;

	@PostConstruct
	public void init(){
		repository.deleteAll();

		SugestorMusicTrackTemperatureConfig party = SugestorMusicTrackTemperatureConfig.temperature()
				.range().start(30.0).end(99.0)
				.genre("Techno").build();

		SugestorMusicTrackTemperatureConfig pop = SugestorMusicTrackTemperatureConfig.temperature()
				.range().start(15.0).end(30.0)
				.genre("pop").build();

		SugestorMusicTrackTemperatureConfig rock = SugestorMusicTrackTemperatureConfig.temperature()
				.range().start(10.0).end(14.0)
				.genre("rock").build();

		SugestorMusicTrackTemperatureConfig classical = SugestorMusicTrackTemperatureConfig.temperature()
				.range().start(-99.0).end(10.0)
				.genre("classical").build();

		repository.save(party);
		repository.save(pop);
		repository.save(rock);
		repository.save(classical);
	}
}