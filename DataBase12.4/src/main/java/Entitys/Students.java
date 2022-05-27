package Entitys;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Student")
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OneToMany
    @JoinTable(name = "subscriptions")
    @JoinColumn(name = "student_id")
    private Integer id;

    private String name;

    private Integer age;

    @Column(name = "registration_date", nullable = false)
    private LocalDateTime registrationDate;

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
        return id.equals(students.id) && name.equals(students.name) && age.equals(students.age) && registrationDate.equals(students.registrationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, registrationDate);
    }
}
