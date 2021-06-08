package com.tav.auditechdemo.services;

import com.tav.auditechdemo.dto.CommitWrapper;
import com.tav.auditechdemo.dto.PullRequestEvent;
import com.tav.auditechdemo.errors.exceptions.ApplicationException;
import com.tav.auditechdemo.errors.exceptions.NoCommitsFoundException;
import com.tav.auditechdemo.mapper.GithubMapper;
import com.tav.auditechdemo.model.PullRequestEntity;
import com.tav.auditechdemo.repositories.PullRequestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PullRequestService {
    private final PullRequestRepository pullRequestRepository;
    private final GithubMapper githubMapper;
    private final RestTemplate restTemplate;

    public void createPullRequest(PullRequestEvent pullRequestEvent) {
        ResponseEntity<CommitWrapper[]> response = restTemplate.getForEntity(
                URI.create(pullRequestEvent.getPullRequestPayload().getCommitsUrl()),
                CommitWrapper[].class
        );
        PullRequestEntity pullRequestEntity = githubMapper.pullRequestPayloadToPullRequestEntity(pullRequestEvent).withCommits(new ArrayList<>());
        Optional.ofNullable(response.getBody()).ifPresentOrElse(commitWrappers -> Arrays.stream(commitWrappers).forEach(commitWrapper ->
                    pullRequestEntity.getCommits().add(githubMapper.commitToCommitEntity(commitWrapper.getCommit())
                )
        ), () -> { throw new NoCommitsFoundException(pullRequestEntity.getNumber()); });
        pullRequestRepository.save(pullRequestEntity);
    }

    public List<PullRequestEntity> getAllPullRequests() {
        return pullRequestRepository.findAll();
    }
}
