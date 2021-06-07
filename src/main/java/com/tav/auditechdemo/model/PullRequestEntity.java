package com.tav.auditechdemo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pull_requests")
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
}
