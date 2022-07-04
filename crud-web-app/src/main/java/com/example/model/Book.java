package com.example.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    public String title;

    public String description;

    public String isbn;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    public Author author;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "genre_id")
    public Genre genre;

    @Column(name = "print_year")
    public Integer printYear;

    @Column(name = "read_already")
    public boolean readAlready;

    public String getAuthorName() {
        return author.getName();
    }

    public String getGenreName() {
        return genre.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id && printYear == book.printYear && readAlready == book.readAlready && Objects.equals(title, book.title) && Objects.equals(description, book.description) && Objects.equals(isbn, book.isbn) && Objects.equals(author, book.author) && Objects.equals(genre, book.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, isbn, author, genre, printYear, readAlready);
    }
}

