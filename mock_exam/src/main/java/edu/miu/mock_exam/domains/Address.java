package edu.miu.mock_exam.domains;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String city;
    private String state;
    private long zipCode;

    @OneToMany(mappedBy = "address")
    private List<Student> students;
}
