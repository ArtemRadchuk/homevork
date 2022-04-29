package Entitys;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Teachers")
public class Teachers {
    public Teachers() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Column(name = "salary")
    private Integer salary;

    @Column(name = "age")
    private Integer age;

    @OneToMany(mappedBy = "teacher")
    private Set<Courses> courses = new LinkedHashSet<>();

    public Set<Courses> getCourses() {
        return courses;
    }

    public void setCourses(Set<Courses> courses) {
        this.courses = courses;
    }

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
        return id.equals(teachers.id) && name.equals(teachers.name) && salary.equals(teachers.salary) && age.equals(teachers.age) && courses.equals(teachers.courses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, salary, age, courses);
    }
}
