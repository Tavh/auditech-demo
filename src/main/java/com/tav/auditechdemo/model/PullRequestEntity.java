package com.tav.auditechdemo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pull_requests")
@With
public class PullRequestEntity {
    @Id
    @GeneratedValue
    private long id;

    @Column(name="title", nullable=false)
    private String title;
    @Column(name="github_id", nullable=false, unique=true)
    private String githubId;
    @Column(name="url", nullable=false)
    private String url;
    @Column(name="number", nullable=false)
    private String number;
    @Column(name="action", nullable=false)
    private String action;
    @OneToMany(cascade=CascadeType.ALL)
    @Column(name="commits", nullable=false)
    private List<CommitEntity> commits;
}
