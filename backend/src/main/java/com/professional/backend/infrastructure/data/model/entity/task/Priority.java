package com.professional.backend.infrastructure.data.model.entity.task;

import org.hibernate.annotations.SortComparator;
import org.hibernate.annotations.SortNatural;
import org.springframework.data.web.SortDefault;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OrderBy;
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