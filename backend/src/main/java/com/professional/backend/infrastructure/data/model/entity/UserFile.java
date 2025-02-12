package com.professional.backend.infrastructure.data.model.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "files")
@RequiredArgsConstructor
public class UserFile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Lob @Basic(fetch = FetchType.LAZY)
    @Column
    private byte[] content;

    @Column 
    private String extensionName;

    @Column
    private String name;
    
    @Column
    private String checksum;
}
