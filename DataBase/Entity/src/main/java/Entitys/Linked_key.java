package Entitys;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Linked_key implements Serializable {

    @Column(name = "student_id")
    private int student_id;

    @Column(name = "course_id")
    private int course_id;

    public int getStudentId() {
        return student_id;
    }

    public void setStudentId(int studentId) {
        this.student_id = studentId;
    }

    public int getCourseId() {
        return course_id;
    }

    public void setCourseId(int courseId) {
        this.course_id = courseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Linked_key linked_key = (Linked_key) o;
        return student_id == linked_key.student_id && course_id == linked_key.course_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(student_id, course_id);
    }
}
