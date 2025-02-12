package com.professional.backend.infrastructure.data.model.entity;

import java.util.Set;
import com.professional.backend.infrastructure.data.model.entity.book.Book;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "readers")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private Long telegramId;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private Set<Book> books;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private Set<Task> tasks;

}
