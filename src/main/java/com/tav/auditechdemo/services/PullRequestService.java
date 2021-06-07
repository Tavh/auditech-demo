package com.tav.auditechdemo.services;

import com.tav.auditechdemo.repositories.PullRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PullRequestService {
    private final PullRequestRepository pullRequestRepository;
}
