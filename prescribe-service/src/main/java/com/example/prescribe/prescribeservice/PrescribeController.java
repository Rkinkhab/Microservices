package com.example.prescribe.prescribeservice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("prescribe")
class PrescribeController {

	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@Autowired
	PrescribeRepository prescribeRepository;

	@GetMapping("/all")
	public List<Prescribe> getAll() {
		return prescribeRepository.findAll();
	}

	@GetMapping("/findByExpirationDate/{data}")
	public ResponseEntity<List<Prescribe>> findByExpirationDate(@PathVariable("data") String expirationDate) {
		try {
			List<Prescribe> prescribers = prescribeRepository.findByExpirationDateBefore(sdf.parse(expirationDate));
			if (prescribers.size() <= 0) {
				throw new PrescriberDataNotFoundException();
			}
			return new ResponseEntity<List<Prescribe>>(prescribers, HttpStatus.OK);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

}
