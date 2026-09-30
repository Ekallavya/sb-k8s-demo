package com.universe.opensky;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class SbK8sDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbK8sDemoApplication.class, args);
		log.info("SbK8sDemoApplication has been started");
	}

}
