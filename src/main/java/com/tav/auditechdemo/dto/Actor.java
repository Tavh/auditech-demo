package com.tav.auditechdemo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Actor {
    private String id;
    private String login;
    @JsonProperty("display_login")
    private String displayLogin;
    @JsonProperty("gravatar_id")
    private String gravatarId;
    private String url;
    @JsonProperty("avatar_url")
    private String avatarUrl;

}
