package com.tav.auditechdemo.controllers;

import com.tav.auditechdemo.dto.PullRequestEvent;
import com.tav.auditechdemo.services.PullRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("pull-request")
public class PullRequestController {
    private final PullRequestService pullRequestService;

    @PostMapping
    public void createPullRequest(@RequestBody PullRequestEvent pullRequestEvent) {
        pullRequestService.createPullRequest(pullRequestEvent);
    }
}
