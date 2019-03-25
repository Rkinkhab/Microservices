package com.example.prescribe.prescribeservice;

import java.text.SimpleDateFormat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class PrescribeServiceApplication {

	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	/*
	 * @Bean CommandLineRunner commandLineRunner(PrescribeRepository
	 * prescribeRepository) { return strings -> { Stream.of(new Prescribe("1",
	 * sdf.parse("2019-02-15"), sdf.parse("2020-02-15")), new Prescribe("2",
	 * sdf.parse("2019-02-15"), sdf.parse("2020-02-15")), new Prescribe("3",
	 * sdf.parse("2019-02-15"), sdf.parse("2020-02-15")), new Prescribe("4",
	 * sdf.parse("2019-02-15"), sdf.parse("2020-02-15")), new Prescribe("5",
	 * sdf.parse("2019-02-15"), sdf.parse("2020-02-15")), new Prescribe("6",
	 * sdf.parse("2019-02-19"), sdf.parse("2020-02-19"))) .forEach(member ->
	 * prescribeRepository.save(member)); }; }
	 */

	public static void main(String[] args) {
		SpringApplication.run(PrescribeServiceApplication.class, args);
	}

}
