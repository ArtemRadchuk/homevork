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
    private Key id;

    @Column(name = "student_id", nullable = false)
    private Integer studentId;

    @Column(name = "course_id", nullable = false)
    private Integer courseId;

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
        return id.equals(that.id) && studentId.equals(that.studentId) && courseId.equals(that.courseId) && Objects.equals(student, that.student) && Objects.equals(courses, that.courses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, studentId, courseId, student, courses);
    }
}
