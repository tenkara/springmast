package tenkara.springbootrestapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import tenkara.springbootrestapi.bean.Student;

@RestController
// @RequestMapping("/student")
public class StudentController {

    // http://localhost:8080/student
    @GetMapping("/student")
    public ResponseEntity<Student> getStudent() {
        Student student = new Student(1, "John", 20);
        return ResponseEntity.ok(student);
    }

    // http://localhost:8080/get-students
    @GetMapping("/get-students")
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> students = new ArrayList<>();
         students.add(new Student(1, "John", 20));
            students.add(new Student(2, "Mary", 21));
            students.add(new Student(3, "Peter", 22));
        return ResponseEntity.ok(students);
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
    // @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        System.out.println(student.getId());
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    // HTTP PUT Request for students
    @PutMapping("/update-student/{id}")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable int id) {
        System.out.println(student.getId());
        System.out.println(student.getName());
        System.out.println(student.getAge());
        return ResponseEntity.ok(student);
    }

    // HTTP DELETE Request for students
    @DeleteMapping("/delete-student/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id) {
        System.out.println(id);
        return ResponseEntity.ok("Student deleted successfully");
    }
}
