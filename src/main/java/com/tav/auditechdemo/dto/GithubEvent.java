package com.tav.auditechdemo.dto;

import com.tav.auditechdemo.dto.payload.Payload;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GithubEvent {
    private String id;
    private String type;
    private Actor actor;
    private Repo repo;
    private Payload payload;
}
