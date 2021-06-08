package com.tav.auditechdemo.mapper;

import com.tav.auditechdemo.dto.Commit;
import com.tav.auditechdemo.dto.PullRequestEvent;
import com.tav.auditechdemo.model.CommitEntity;
import com.tav.auditechdemo.model.PullRequestEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GithubMapper {

    @Mapping(target="title", source="pullRequestPayload.title")
    @Mapping(target="action", source="pullRequestPayload.action")
    @Mapping(target="url", source="pullRequestPayload.url")
    @Mapping(target="githubId", source="pullRequestPayload.id")
    @Mapping(target="number", source="pullRequestPayload.number")
    PullRequestEntity pullRequestPayloadToPullRequestEntity(PullRequestEvent pullRequestEvent);

    CommitEntity commitToCommitEntity(Commit commit);
}
