package Entitys;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Key implements Serializable {

    public Key() {
    }

    public Key(int student_id, int course_id) {
        this.studentId = student_id;
        this.courseId = course_id;
    }

    @Column(name = "student_id")
    private int studentId;

    @Column(name = "course_id")
    private int courseId;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Key linked_key = (Key) o;
        return studentId == linked_key.studentId && courseId == linked_key.courseId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, courseId);
    }
}
