package com.professional.backend.infrastructure.data.model.entity.book;

import java.util.Set;

import com.professional.backend.infrastructure.data.model.entity.User;
import com.professional.backend.infrastructure.data.model.entity.Task;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/*
 * TODO: Finish relationship between task and book entity. Now it's not working and causes runtime crash
 * TODO: Finish relationship between user and book entity. 
 */
@Getter
@Setter
@Entity(name = "books")
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "file_id", referencedColumnName = "id")
    private BookFile file;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany(mappedBy = "books")
    private Set<Task> tasks;
}
