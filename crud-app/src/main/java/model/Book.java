package model;

import javax.persistence.*;

@Entity
public class Book {

    public Book() {
    }

    public Book(long id, String title, String description, String isbn, int printYear, boolean readAlready) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.isbn = isbn;
        this.printYear = printYear;
        this.readAlready = readAlready;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    public String title;

    public String description;

    public String isbn;

    @Column(name = "print_year")
    public int printYear;

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

    public int getPrintYear() {
        return printYear;
    }

    public void setPrintYear(int printYear) {
        this.printYear = printYear;
    }

    public boolean isReadAlready() {
        return readAlready;
    }

    public void setReadAlready(boolean readAlready) {
        this.readAlready = readAlready;
    }
}

