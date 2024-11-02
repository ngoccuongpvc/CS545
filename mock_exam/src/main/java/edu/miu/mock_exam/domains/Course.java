package edu.miu.mock_exam.domains;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Course {
    @Id
    private long id;
    private String name;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "course")
    private CourseDetails courseDetails;

    @ManyToMany
    @JoinTable()
    private List<Student> students;
}
