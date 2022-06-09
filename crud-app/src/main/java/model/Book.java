package model;

import javax.persistence.*;

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
    public int printYear;

    @Column(name = "read_already")
    public boolean readAlready;


}

