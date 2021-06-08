package com.tav.auditechdemo.controllers;

import com.tav.auditechdemo.dto.PullRequestEvent;
import com.tav.auditechdemo.model.PullRequestEntity;
import com.tav.auditechdemo.services.PullRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(value = "*", allowCredentials = "true", allowedHeaders = "*",
                methods = { RequestMethod.GET, RequestMethod.POST })
@RestController
@RequiredArgsConstructor
@RequestMapping("pull-request")
public class PullRequestController {
    private final PullRequestService pullRequestService;

    @PostMapping
    public void createPullRequest(@RequestBody PullRequestEvent pullRequestEvent) {
        pullRequestService.createPullRequest(pullRequestEvent);
    }

    @GetMapping("all")
    public List<PullRequestEntity> getAllPullRequests() {
        return pullRequestService.getAllPullRequests();
    }
}
