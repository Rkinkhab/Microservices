package com.example.pharmacy.pharmacyservice;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
interface PharmacyRepository extends MongoRepository<Pharmacy, Long> {

	public List<Pharmacy> findByExpirationDateBefore(Date expirationDate);

}