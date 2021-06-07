package com.tav.auditechdemo.controllers;

import com.tav.auditechdemo.dto.GithubEvent;
import com.tav.auditechdemo.services.GithubEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("github-event")
public class GithubEventController {
    private final GithubEventService githubEventService;

    @PostMapping("pull-request")
    public void createPullRequest(@RequestBody GithubEvent githubEvent) {
        githubEventService.createPullRequest(githubEvent);
    }
}
