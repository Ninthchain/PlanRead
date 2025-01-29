package com.professional.backend.infrastructure.data.model.entity.task;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Priority {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Short id;

    
    @Column(name = "index")
    private Integer index;
}