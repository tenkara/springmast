package tenkara.springbootrestapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
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
                new Student(3, "Peter", 22));
    }

    // http://localhost:8080/student/1
    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable int id) {
        return new Student(id, "John", 20);
    }

    // http://localhost:8080/students/query?id=1&name=John&age=20
    @GetMapping("/students/query")
    public Student getStudentByQuery(int id, String name, int age) {
        return new Student(id, name, age);
    }

    // HTTP POST Request for students
    @PostMapping("/create-student")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student) {
        System.out.println(student.getId());
        return student;
    }

    // HTTP PUT Request for students
    @PutMapping("/update-student/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Student updateStudent(@RequestBody Student student, @PathVariable int id) {
        System.out.println(student.getId());
        System.out.println(student.getName());
        System.out.println(student.getAge());
        return student;
    }

    // HTTP DELETE Request for students
    @DeleteMapping("/delete-student/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteStudent(@PathVariable int id) {
        System.out.println(id);
        return "Student deleted successfully";
    }
}
