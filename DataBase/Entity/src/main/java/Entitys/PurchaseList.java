package Entitys;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "PurchaseList")
public class PurchaseList {
    public PurchaseList() {
    }

    @Column(name = "student_name", length = 500)
    private String studentName;

    @Column(name = "course_name", length = 500)
    private String courseName;

    @Column(name = "price")
    private Integer price;

    @Column(name = "subscription_date")
    private Instant subscriptionDate;

    public Instant getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Instant subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
