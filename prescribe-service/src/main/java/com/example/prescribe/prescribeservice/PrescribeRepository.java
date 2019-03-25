package com.example.prescribe.prescribeservice;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

interface PrescribeRepository extends MongoRepository<Prescribe, Long> {

	public List<Prescribe> findByExpirationDateBefore(Date expirationDate);
}
