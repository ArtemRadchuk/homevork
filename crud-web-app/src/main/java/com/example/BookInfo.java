package com.example;

import com.example.model.Author;
import com.example.model.Genre;

public class BookInfo {

    public long id;

    public String title;

    public String description;

    public String isbn;

    public long author;

    public long genre;

    public Integer printYear;

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

    public long getAuthor() {
        return author;
    }

    public void setAuthor(long author) {
        this.author = author;
    }

    public long getGenre() {
        return genre;
    }

    public void setGenre(long genre) {
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
}
