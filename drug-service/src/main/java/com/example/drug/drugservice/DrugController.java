package com.example.drug.drugservice;

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
@RequestMapping("drug")
class DrugController {

	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@Autowired
	DrugRepository drugRepo;

	@GetMapping("/all")
	public Collection<Drug> getAll() {
		return drugRepo.findAll();
	}

	@GetMapping("/findByExpirationDate/{data}")
	public ResponseEntity<List<Drug>> getByExpirationDate(@PathVariable("data") String expirationDate) {
		try {
			List<Drug> drugs = drugRepo.findByExpirationDateBefore(sdf.parse(expirationDate));
			if (drugs.size() <= 0) {
				throw new DrugDataNotFoundException();
			}
			return new ResponseEntity<List<Drug>>(drugs, HttpStatus.OK);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

}
