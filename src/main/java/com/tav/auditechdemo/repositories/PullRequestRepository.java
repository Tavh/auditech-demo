package com.tav.auditechdemo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PullRequestRepository extends MongoRepository {
}
