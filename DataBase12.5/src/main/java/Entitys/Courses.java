package Entitys;
import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Courses")
public class Courses {
    public Courses() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @JoinTable(name = "linked_key", joinColumns = {@JoinColumn(name = "courseId")},
            inverseJoinColumns = {@JoinColumn(name = "studentId")})
    private Integer id;

    @OneToMany
    @JoinTable(name = "subscription_key", joinColumns = {@JoinColumn(name = "courseId")},
            inverseJoinColumns = {@JoinColumn(name = "studentId")})
    private List courses;

    @Column(name = "name", length = 500)
    private String name;

    @Column(name = "duration")
    private Integer duration;

    @Lob
    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "description", length = 500)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    private Teachers teacher;

    @Column(name = "students_count")
    private Integer studentsCount;

    @Column(name = "price")
    private Integer price;

    @Column(name = "price_per_hour")
    private Double pricePerHour;

    @OneToMany(mappedBy = "course")
    private Set<Subscriptions> subscriptions = new LinkedHashSet<>();

    public Set<Subscriptions> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(Set<Subscriptions> subscriptions) {
        this.subscriptions = subscriptions;
    }

    public Double getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(Double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStudentsCount() {
        return studentsCount;
    }

    public void setStudentsCount(Integer studentsCount) {
        this.studentsCount = studentsCount;
    }

    public Teachers getTeacher() {
        return teacher;
    }

    public void setTeacher(Teachers teacher) {
        this.teacher = teacher;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
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
        Courses courses = (Courses) o;
        return id.equals(courses.id) && name.equals(courses.name) && duration.equals(courses.duration) && type.equals(courses.type) && description.equals(courses.description) && teacher.equals(courses.teacher) && studentsCount.equals(courses.studentsCount) && price.equals(courses.price) && pricePerHour.equals(courses.pricePerHour) && subscriptions.equals(courses.subscriptions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, duration, type, description, teacher, studentsCount, price, pricePerHour, subscriptions);
    }
}
