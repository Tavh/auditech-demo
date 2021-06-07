package com.tav.auditechdemo.dto.payload;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PullRequestPayload extends Payload {
    private String action;
    private int number;
    private Object changes;
    @JsonProperty("pull_request")
    private Object pullRequest;
}
