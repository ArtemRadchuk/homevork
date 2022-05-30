package Entitys;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Student")
public class Students {
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

    //localedaetime
    @Column(name = "registration_date", nullable = false)
    private Instant registrationDate;

    @OneToMany(mappedBy = "student")
    private Set<Subscriptions> subscriptions = new LinkedHashSet<>();

    public Set<Subscriptions> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(Set<Subscriptions> subscriptions) {
        this.subscriptions = subscriptions;
    }

    public Instant getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Instant registrationDate) {
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
