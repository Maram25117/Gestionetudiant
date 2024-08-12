package com.arjuncodes.studentsystem.controller;

import com.arjuncodes.studentsystem.model.Student;
import com.arjuncodes.studentsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public String add(@RequestBody Student student) {
        studentService.saveStudent(student);
        return "New student is added";
    }

    @GetMapping("/getAll")
    public List<Student> list() {
        return studentService.getAllStudents();
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        studentService.deleteStudentById(id);
        return "Student with id " + id + " is deleted";
    }

    @GetMapping("/name/{firstName}/{lastName}")
    public List<Student> getStudentsByName(@PathVariable String firstName, @PathVariable String lastName) {
        return studentService.getStudentsByFirstNameAndLastName(firstName, lastName);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student studentDetails) {
        Optional<Student> optionalStudent = studentService.getStudentById(id);

        if (!optionalStudent.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Student student = optionalStudent.get();
        student.setFirstName(studentDetails.getFirstName());
        student.setLastName(studentDetails.getLastName());
        student.setAddress(studentDetails.getAddress());
        student.setPhone(studentDetails.getPhone());
        student.setEmail(studentDetails.getEmail());
        student.setCin(studentDetails.getCin());
        student.setClasse(studentDetails.getClasse());

        studentService.saveStudent(student);
        return ResponseEntity.ok(student);
    }

    @GetMapping("/classe/{classe}")
    public List<Student> getStudentsByClasse(@PathVariable String classe) {
        return studentService.findStudentsByClasse(classe);
    }
}
