package domain;

import javax.persistence.*;

@Entity
@Table (name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    private int duration;

    @Column(name = "type")
    private char type;

    @Column(name = "description")
    private String description;

    @Column(name = "teacher_id")
    private Integer teacherId;

    @Column(name = "students_count")
    private int studentCount;

    @Column(name = "price")
    private int price;

    @Column(name = "price_per_hour")
    private float pricePerHour;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getTeacher_id() {
        return teacherId;
    }

    public void setTeacher_id(Integer teacher_id) {
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

    public float getPrice_per_hour() {
        return pricePerHour;
    }

    public void setPrice_per_hour(float pricePerHour) {
        this.pricePerHour = pricePerHour;
    }
}

