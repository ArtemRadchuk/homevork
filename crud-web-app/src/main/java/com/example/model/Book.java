package com.example.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    public String title;

    public String description;

    public String isbn;

    @ManyToOne
    public Author author;

    @ManyToOne
    public Genre genre;

    @Column(name = "print_year")
    public Integer printYear;

    @Column(name = "read_already")
    public boolean readAlready;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Integer getPrintYear() {
        return printYear;
    }

    public void setPrintYear(Integer printYear) {
        this.printYear = printYear;
    }

    public boolean isReadAlready() {
        return readAlready;
    }

    public void setReadAlready(boolean readAlready) {
        this.readAlready = readAlready;
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

