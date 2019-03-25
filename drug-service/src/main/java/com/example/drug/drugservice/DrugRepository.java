package com.example.drug.drugservice;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
interface DrugRepository extends MongoRepository<Drug, Long> {

	public List<Drug> findByExpirationDateBefore(Date expirationDate);
}
