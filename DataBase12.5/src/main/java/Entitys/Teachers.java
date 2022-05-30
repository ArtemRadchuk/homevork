package Entitys;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Teachers")
public class Teachers {
    public Teachers() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String name;

    private Integer salary;

    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
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
        Teachers teachers = (Teachers) o;
        return id.equals(teachers.id) && name.equals(teachers.name) && salary.equals(teachers.salary) && age.equals(teachers.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, salary, age);
    }
}
