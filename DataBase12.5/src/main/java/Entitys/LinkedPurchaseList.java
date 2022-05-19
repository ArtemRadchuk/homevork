package Entitys;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "LinkedPurchaseList")
public class LinkedPurchaseList implements Serializable {

    public LinkedPurchaseList() {
    }

    @EmbeddedId
    private Linked_key id;

    @Column(name = "student_id", nullable = false)
    private Integer student_id;

    @Column(name = "course_id", nullable = false)
    private Integer course_id;

    @ManyToOne
    @JoinColumn(name = "courses_id")
    private Courses courses;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Students student;

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
        LinkedPurchaseList that = (LinkedPurchaseList) o;
        return id.equals(that.id) && student_id.equals(that.student_id) && course_id.equals(that.course_id) && Objects.equals(student, that.student) && Objects.equals(courses, that.courses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, student_id, course_id, student, courses);
    }
}
