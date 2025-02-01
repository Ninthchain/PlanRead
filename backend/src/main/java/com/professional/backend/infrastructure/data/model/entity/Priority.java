package com.professional.backend.infrastructure.data.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
public class Priority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Short id;

    @Column(name = "index")
    private Integer index;
}