package com.professional.bot.data.entity;

import java.util.HashSet;
import java.util.Set;

import com.professional.bot.data.dto.UserDto;

import edu.umd.cs.findbugs.annotations.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class ReaderCache {
    
    @Id
    @NonNull
    private Long userId;
    
    @NonNull
    @Column(name = "dialog_status", nullable = false, updatable = true)
    private short dialogStatus = 0;

    @Column(nullable = true)
    private String lastCommand;

    @Column(nullable = true)
    private Long lastOpenedBookId;

    @Column
    private Set<Long> books = new HashSet<>();
    
    public ReaderCache(UserDto userDto) {
        
    }
}
