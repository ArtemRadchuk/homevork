package Entitys;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "subscription_key")

@IdClass(Subscriptions_Key.class)
public class SubscriptionsKey {

    @Id
    @Column(name="student_id")
    private Long studentId;

    @Id
    @Column(name="course_id")
    private Long courseId;
}
@Getter
@Setter
@EqualsAndHashCode
class Subscriptions_Key implements Serializable {
    private Long studentId;
    private Long courseId;
}