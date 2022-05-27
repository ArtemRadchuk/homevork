package domain;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Entity
@Table (name = "courses")
public class Courses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    private int duration;

    @Column(name = "type")
    private String type;

    @Column(name = "description")
    private String description;

    @Column(name = "teacher_id")
    private long teacherId;

    @Column(name = "student_count")
    private int studentCount;

    @Column(name = "price")
    private int price;

    @Column(name = "price_per_hour")
    private int pricePerHour;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getTeacher_id() {
        return teacherId;
    }

    public void setTeacher_id(long teacher_id) {
        this.teacherId = teacher_id;
    }

    public int getStudent_count() {
        return studentCount;
    }

    public void setStudent_count(int student_count) {
        this.studentCount = student_count;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice_per_hour() {
        return pricePerHour;
    }

    public void setPrice_per_hour(int pricePerHour) {
        this.pricePerHour = pricePerHour;
    }
}

