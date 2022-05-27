package Entitys;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "subscriptions")
@IdClass(Subscriptions.SubscriptionKey.class)
public class Subscriptions {

    @EmbeddedId
    private SubscriptionKey subscriptionKey;

    @ManyToOne
    @JoinTable(name = "students", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "student_id", insertable = false, updatable = false)
    private int studentId;

    @ManyToOne
    @JoinTable(name = "courses", joinColumns = @JoinColumn(name = "course_id"))
    @Column(name = "course_id", insertable = false, updatable = false)
    private int courseId;

    @Column(name = "subscription_date", nullable = false)
    private LocalDateTime subscriptionDate;


    public LocalDateTime getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(LocalDateTime subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscriptions that = (Subscriptions) o;
        return Objects.equals(subscriptionKey, that.subscriptionKey) && Objects.equals(subscriptionDate, that.subscriptionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subscriptionKey, subscriptionDate);
    }

    @Embeddable
    public class SubscriptionKey implements Serializable {
        @Column(name = "student_id")
        private int studentId;

        @Column(name = "course_id")
        private int courseId;

        public int getStudent() {
            return studentId;
        }

        public void setStudent(int studentId) {
            this.studentId = studentId;
        }

        public int getCourse() {
            return courseId;
        }

        public void setCourse(int courseId) {
            this.courseId = courseId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            SubscriptionKey that = (SubscriptionKey) o;
            return studentId == that.studentId && courseId == that.courseId;
        }

        @Override
        public int hashCode() {
            return Objects.hash(studentId, courseId);
        }
    }

}


