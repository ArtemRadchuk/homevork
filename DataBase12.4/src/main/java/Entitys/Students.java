package Entitys;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Student")
public class Students {
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "SUBSCRIPTIONS1_STUDENT_ID", referencedColumnName = "STUDENT_ID"),
            @JoinColumn(name = "SUBSCRIPTIONS1_COURSE_ID", referencedColumnName = "COURSE_ID")
    })
    private Subscriptions subscriptions1;

    public Students() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "registration_date", nullable = false)
    private LocalDateTime registrationDate;

    @OneToMany(mappedBy = "student")
    private Set<Subscriptions> subscriptions = new LinkedHashSet<>();

    public Subscriptions getSubscriptions1() {
        return subscriptions1;
    }

    public void setSubscriptions1(Subscriptions subscriptions1) {
        this.subscriptions1 = subscriptions1;
    }

    public Set<Subscriptions> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(Set<Subscriptions> subscriptions) {
        this.subscriptions = subscriptions;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Students students = (Students) o;
        return id.equals(students.id) && name.equals(students.name) && age.equals(students.age) && registrationDate.equals(students.registrationDate) && subscriptions.equals(students.subscriptions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, registrationDate, subscriptions);
    }
}
