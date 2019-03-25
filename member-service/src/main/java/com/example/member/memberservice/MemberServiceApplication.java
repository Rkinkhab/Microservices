package com.example.member.memberservice;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MemberServiceApplication {

	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	/*
	 * @Bean CommandLineRunner commandLineRunner(MemberRepository memberRepository)
	 * { return strings -> { Stream.of(new Members("1", "James",
	 * sdf.parse("2019-02-15"), sdf.parse("2020-02-15")), new Members("2",
	 * "Michael", sdf.parse("2019-02-15"), sdf.parse("2020-02-15")), new
	 * Members("3", "Robert", sdf.parse("2019-02-15"), sdf.parse("2020-02-15")), new
	 * Members("4", "Maria", sdf.parse("2019-02-15"), sdf.parse("2020-02-15")), new
	 * Members("5", "Mary", sdf.parse("2019-02-15"), sdf.parse("2020-02-15")), new
	 * Members("6", "David", sdf.parse("2019-02-19"), sdf.parse("2020-02-19")))
	 * .forEach(member -> memberRepository.save(member)); }; }
	 */
	public static void main(String[] args) throws ParseException {
		SpringApplication.run(MemberServiceApplication.class, args);
	}

}
