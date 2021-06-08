package com.tav.auditechdemo.repositories;

import com.tav.auditechdemo.model.PullRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PullRequestRepository extends JpaRepository<PullRequestEntity, Long> {
}
