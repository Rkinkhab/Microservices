package com.example.member.memberservice;

import java.util.Date;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
interface MemberRepository extends MongoRepository<Members, Long> {

	public List<Members> findByExpirationDateBefore(Date expirationDate);

}