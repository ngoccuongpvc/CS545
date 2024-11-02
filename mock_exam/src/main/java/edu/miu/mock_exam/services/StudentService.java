package edu.miu.mock_exam.services;

import edu.miu.mock_exam.domains.Student;
import edu.miu.mock_exam.domains.dtos.CourseDto;
import edu.miu.mock_exam.repositories.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public StudentService(StudentRepository studentRepository, ModelMapper modelMapper) {
        this.studentRepository = studentRepository;
        this.modelMapper = modelMapper;
    }

    public List<CourseDto> getStudentCourses(long studentId) {
        Student student = studentRepository.findById(studentId).orElse(null);
        if (student == null) {
            throw new EntityNotFoundException("Student with id " + studentId + " not found");
        }
        return student.getCourses().stream().map(course -> modelMapper.map(course, CourseDto.class)).collect(Collectors.toList());
    }
}
