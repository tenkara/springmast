package tenkara.springbootrestapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import tenkara.springbootrestapi.bean.Student;

@RestController
public class StudentController {
    
    // http://localhost:8080/student
    @GetMapping("/student")
    public Student getStudent() {
        return new Student(1, "John", 20);
    }

    // http://localhost:8080/get-students
    @GetMapping("/get-students")
    public List<Student> getStudents() {
        return List.of(
            new Student(1, "John", 20),
            new Student(2, "Mary", 21),
            new Student(3, "Peter", 22)
        );
    }

    // http://localhost:8080/student/1
    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable int id) {
        return new Student(id, "John", 20);
    }

}
