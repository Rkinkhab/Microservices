package com.example.drug.drugservice;

import java.text.SimpleDateFormat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class DrugServiceApplication {

	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	/*
	 * @Bean CommandLineRunner commandLineRunner(DrugRepository drugRepository) {
	 * return strings -> { Stream.of(new Drug("1", "Hydrocodone",
	 * sdf.parse("2019-02-15"), sdf.parse("2020-02-15")), new Drug("2",
	 * "Generic Zocor", sdf.parse("2019-02-15"), sdf.parse("2020-02-15")), new
	 * Drug("3", "Azithromycin", sdf.parse("2019-02-15"), sdf.parse("2020-02-15")),
	 * new Drug("4", "Amoxicillin", sdf.parse("2019-02-15"),
	 * sdf.parse("2020-02-15")), new Drug("5", "Hydrochlorothiazide",
	 * sdf.parse("2019-02-15"), sdf.parse("2020-02-15")), new Drug("6", "Tylenol",
	 * sdf.parse("2019-02-19"), sdf.parse("2020-02-19"))) .forEach(member ->
	 * drugRepository.save(member)); }; }
	 */

	public static void main(String[] args) {
		SpringApplication.run(DrugServiceApplication.class, args);
	}

}
