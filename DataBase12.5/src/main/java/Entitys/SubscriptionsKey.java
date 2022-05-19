package Entitys;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "subscription_key")

@IdClass(SubscriptionsKey.class)
@Getter
@Setter
@EqualsAndHashCode
public class SubscriptionsKey implements Serializable {

    @Id
    @Column(name="student_id")
    private Long studentId;

    @Id
    @Column(name="course_id")
    private Long courseId;
}

