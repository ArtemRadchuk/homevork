package com.example;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class BookInfo {

    public long id;

    public String title;

    public String description;

    public String isbn;

    public String author;

    public String author2;

    public String genre;

    public String genre2;

    public Integer printYear;

    public boolean readAlready;


}
