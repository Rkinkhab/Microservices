package com.example.pharmacy.pharmacyservice;

import java.text.SimpleDateFormat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class PharmacyServiceApplication {

	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	/*@Bean
	CommandLineRunner commandLineRunner(PharmacyRepository pharmacyRepository) {
		return strings -> {
			Stream.of(new Pharmacy("1", "CVS Corporation", sdf.parse("2019-02-15"), sdf.parse("2020-2-15")),
					new Pharmacy("2", "Fred's Inc.", sdf.parse("2019-02-15"), sdf.parse("2020-2-15")),
					new Pharmacy("3", "Omnicare", sdf.parse("2019-02-15"), sdf.parse("2020-2-15")),
					new Pharmacy("4", "Rite Aid corporation", sdf.parse("2019-02-15"), sdf.parse("2020-2-15")),
					new Pharmacy("5", "safeway", sdf.parse("2019-02-15"), sdf.parse("2020-2-15")),
					new Pharmacy("6", "Bi-Lo Inc.", sdf.parse("2019-02-15"), sdf.parse("2020-2-15")))
					.forEach(p -> pharmacyRepository.save(p));
		};
	}*/

	public static void main(String[] args) {
		SpringApplication.run(PharmacyServiceApplication.class, args);
	}

}
