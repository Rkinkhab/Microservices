package com.example.pharmacy.pharmacyservice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pharmacy")
class PharmacyController {

	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@Autowired
	PharmacyRepository pharmacyRepo;

	@GetMapping("/all")
	public Collection<Pharmacy> getAll() {
		return pharmacyRepo.findAll();
	}

	@GetMapping("/findByExpirationDate/{data}")
	public ResponseEntity<List<Pharmacy>> getByExpirationDate(@PathVariable("data") String expirationDate) {
		try {
			List<Pharmacy> pharmacies = pharmacyRepo.findByExpirationDateBefore(sdf.parse(expirationDate));
			if (pharmacies.size() <= 0) {
				throw new PharmacyDataNotFoundException();
			}
			return new ResponseEntity<List<Pharmacy>>(pharmacies, HttpStatus.OK);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

}
