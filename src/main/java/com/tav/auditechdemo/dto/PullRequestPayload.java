package com.tav.auditechdemo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PullRequestPayload {
    private String title;
    private String url;
    private long id;
    private long number;
    @JsonProperty("commits_url")
    private String commitsUrl;
}
