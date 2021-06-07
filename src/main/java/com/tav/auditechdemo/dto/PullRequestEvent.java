package com.tav.auditechdemo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PullRequestEvent {
    @JsonProperty("pull_request")
    private PullRequestPayload pullRequestPayload;
    @JsonProperty("_links")
    private Links links;
}
