package com.professional.backend.infrastructure.model.dao.task;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "task_priorities")
public class UserTaskPriority {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Short id;

    @Column(name = "index")
    private Integer index;
}
