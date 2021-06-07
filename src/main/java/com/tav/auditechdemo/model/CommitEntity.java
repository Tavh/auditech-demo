package com.tav.auditechdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "commits")
public class CommitEntity {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    private PullRequestEntity pullRequest;

    @Column(name = "message", nullable = false)
    private String message;
}
