package Entitys;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Key implements Serializable {

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName =("id"))
    private Students student;

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = ("id"))
    private Courses courses;

    public Students getStudent() {
        return student;
    }

    public void setStudent(Students student) {
        this.student = student;
    }

    public Courses getCourses() {
        return courses;
    }

    public void setCourses(Courses courses) {
        this.courses = courses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Key key = (Key) o;
        return Objects.equals(student, key.student) && Objects.equals(courses, key.courses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(student, courses);
    }
}