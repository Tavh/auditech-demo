package com.tav.auditechdemo.services;

import com.tav.auditechdemo.dto.GithubEvent;
import com.tav.auditechdemo.repositories.PullRequestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class GithubEventService {
    private final PullRequestRepository pullRequestRepository;

    public void createPullRequest(GithubEvent githubEvent) {
        log.debug("Extracting pull request data from: {}", githubEvent);
        return;
    }
}
