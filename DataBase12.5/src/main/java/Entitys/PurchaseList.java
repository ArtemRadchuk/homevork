package Entitys;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "PurchaseList")
public class PurchaseList {
    public PurchaseList() {
    }
@DaTa
@Getter
@Setter
    @Column(name = "student_name", length = 500)
    private String studentName;

    @Column(name = "course_name", length = 500)
    private String courseName;

    @Column(name = "price")
    private Integer price;

    @Column(name = "subscription_date")
    private LocalDateTime subscriptionDate;

}
