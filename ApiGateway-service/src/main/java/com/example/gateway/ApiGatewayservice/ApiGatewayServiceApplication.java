package com.example.gateway.ApiGatewayservice;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@EnableZuulProxy
@SpringBootApplication
public class ApiGatewayServiceApplication {

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayServiceApplication.class, args);
	}

}

@RestController
@RequestMapping("service")
class GateWayController {
	private static final Logger LOG = Logger.getLogger(GateWayController.class);

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/result/{date}")
	public Result getResult(@PathVariable("date") String date) {
		Result finalResult = new Result();

		Thread t = new Thread(() -> {
			try {
				ResponseEntity<Collection<Member>> entity = this.restTemplate.exchange(
						"http://member-service/member/findByExpirationDate/{date}", HttpMethod.GET, null,
						new ParameterizedTypeReference<Collection<Member>>() {
						}, date);
				LOG.info("http://member-service/member/findByExpirationDate/" + date + " GET "
						+ "member/findByExpirationDate/{date} " + entity.getStatusCode().toString());
				finalResult.setMembers(entity.getBody());
			} catch (Exception e) {
				LOG.info("http://member-service/member/findByExpirationDate/" + date + "\tresponse :: "
						+ e.getMessage());
			}
		});

		Thread t2 = new Thread(() -> {
			try {
				ResponseEntity<Collection<Pharmacy>> entity = this.restTemplate.exchange(
						"http://pharmacy-service/pharmacy/findByExpirationDate/{date}", HttpMethod.GET, null,
						new ParameterizedTypeReference<Collection<Pharmacy>>() {
						}, date);
				LOG.info("http://pharmacy-service/pharmacy/findByExpirationDate/" + date + " GET "
						+ "pharmacy/findByExpirationDate/{date} " + entity.getStatusCode().toString());
				finalResult.setPharmacy(entity.getBody());
			} catch (Exception e) {
				LOG.info("http://pharmacy-service/pharmacy/findByExpirationDate/" + date + "\tresponse :: "
						+ e.getMessage());
			}
		});
		Thread t3 = new Thread(() -> {
			try {
				ResponseEntity<Collection<Drug>> entity = this.restTemplate.exchange(
						"http://drug-service/drug/findByExpirationDate/{date}", HttpMethod.GET, null,
						new ParameterizedTypeReference<Collection<Drug>>() {
						}, date);
				LOG.info("http://drug-service/drug/findByExpirationDate/" + date + " GET "
						+ "drug/findByExpirationDate/{date} " + entity.getStatusCode().toString());
				finalResult.setDrug(entity.getBody());
			} catch (Exception e) {
				LOG.info("http://drug-service/drug/findByExpirationDate/" + date + "\tresponse :: " + e.getMessage());
			}
		});

		Thread t4 = new Thread(() -> {
			try {
				ResponseEntity<Collection<Prescribe>> entity = this.restTemplate.exchange(
						"http://prescribe-service/prescribe/findByExpirationDate/{date}", HttpMethod.GET, null,
						new ParameterizedTypeReference<Collection<Prescribe>>() {
						}, date);
				LOG.info("http://prescribe-service/prescribe/findByExpirationDate/" + date + " GET "
						+ "prescribe/findByExpirationDate/{date} " + entity.getStatusCode().toString());
				finalResult.setPrescribe(entity.getBody());
			} catch (Exception e) {
				LOG.info("http://prescribe-service/prescribe/findByExpirationDate/" + date + "\tresponse :: "
						+ e.getMessage());
			}

		});
		t.start();
		t2.start();
		t3.start();
		t4.start();
		try {
			t.join();
			t2.join();
			t3.join();
			t4.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return finalResult;
	}
}

class Result {

	private Collection<Member> members;
	private Collection<Pharmacy> pharmacy;
	private Collection<Prescribe> prescribe;
	private Collection<Drug> drug;

	public Result() {
		super();
	}

	public Collection<Member> getMembers() {
		return members;
	}

	public void setMembers(Collection<Member> members) {
		this.members = members;
	}

	public Collection<Pharmacy> getPharmacy() {
		return pharmacy;
	}

	public void setPharmacy(Collection<Pharmacy> pharmacy) {
		this.pharmacy = pharmacy;
	}

	public Collection<Prescribe> getPrescribe() {
		return prescribe;
	}

	public void setPrescribe(Collection<Prescribe> prescribe) {
		this.prescribe = prescribe;
	}

	public Collection<Drug> getDrug() {
		return drug;
	}

	public void setDrug(Collection<Drug> drug) {
		this.drug = drug;
	}

}
