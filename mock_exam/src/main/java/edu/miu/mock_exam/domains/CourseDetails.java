package edu.miu.mock_exam.domains;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class CourseDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    private int credit;
    private String program;
    private int last_updated;

    @OneToOne
    private Course course;
}
