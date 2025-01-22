package com.professional.backend.infrastructure.model.dao.task;

import java.util.Set;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tasks")
public class UserTask {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "task_name")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "priority_id", referencedColumnName = "id")
    private UserTaskPriority priority;

    @ManyToMany
    private Set<Tag> tags;
}
