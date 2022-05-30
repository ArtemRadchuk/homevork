package Entitys;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SubscriptionKey implements Serializable {

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName =("id"))
    private Students students;

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = ("id"))
    private Courses courses;

    public Students getStudents() {
        return students;
    }

    public void setStudents(Students students) {
        this.students = students;
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
        SubscriptionKey that = (SubscriptionKey) o;
        return Objects.equals(students, that.students) && Objects.equals(courses, that.courses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(students, courses);
    }
}
