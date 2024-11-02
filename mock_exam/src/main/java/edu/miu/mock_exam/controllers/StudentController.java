package edu.miu.mock_exam.controllers;

import edu.miu.mock_exam.domains.dtos.CourseDto;
import edu.miu.mock_exam.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/v1/students")
@RestController
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{id}/courses")
    public List<CourseDto> getStudentCourse(@PathVariable long id) {
        return studentService.getStudentCourses(id);
    }
}
