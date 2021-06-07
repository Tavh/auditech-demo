package com.tav.auditechdemo.controllers;

import com.tav.auditechdemo.services.PullRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PullRequestController {
    private final PullRequestService pullRequestService;
}
