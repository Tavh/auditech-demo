package com.tav.auditechdemo.services;

import com.tav.auditechdemo.dto.CommitWrapper;
import com.tav.auditechdemo.dto.PullRequestEvent;
import com.tav.auditechdemo.errors.exceptions.ApplicationException;
import com.tav.auditechdemo.errors.exceptions.NoCommitsFoundException;
import com.tav.auditechdemo.mapper.GithubMapper;
import com.tav.auditechdemo.model.PullRequestEntity;
import com.tav.auditechdemo.repositories.CommitRepository;
import com.tav.auditechdemo.repositories.PullRequestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Arrays;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PullRequestService {
    private final PullRequestRepository pullRequestRepository;
    private final CommitRepository commitRepository;
    private final GithubMapper githubMapper;
    private final RestTemplate restTemplate;

    public void createPullRequest(PullRequestEvent pullRequestEvent) {
        PullRequestEntity pullRequestEntity = githubMapper.pullRequestPayloadToPullRequestEntity(pullRequestEvent);
        pullRequestRepository.save(pullRequestEntity);
        ResponseEntity<CommitWrapper[]> response = restTemplate.getForEntity(
                URI.create(pullRequestEvent.getLinks().getCommitsUrl()),
                CommitWrapper[].class
        );

        Optional.ofNullable(response.getBody()).ifPresentOrElse(commitWrappers -> Arrays.stream(commitWrappers).forEach(commitWrapper ->
                    commitRepository.save(githubMapper.commitToCommitEntity(commitWrapper.getCommit(), pullRequestEntity)
                )
        ), () -> { throw new NoCommitsFoundException(pullRequestEntity.getNumber()); });
    }
}
