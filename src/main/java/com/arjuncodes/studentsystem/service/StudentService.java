package com.arjuncodes.studentsystem.service;

import com.arjuncodes.studentsystem.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    Student saveStudent(Student student);
    List<Student> getAllStudents();
    void deleteStudentById(int id);
    List<Student> getStudentsByFirstNameAndLastName(String firstName, String lastName);
    Optional<Student> getStudentById(int id);
    List<Student> findStudentsByClasse(String classe);
}


