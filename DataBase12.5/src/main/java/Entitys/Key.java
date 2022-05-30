package Entitys;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Key implements Serializable {

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName =("id"))
    private Students studentы;

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = ("id"))
    private Courses courses;

}