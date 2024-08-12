package com.arjuncodes.studentsystem.repository;

import com.arjuncodes.studentsystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByFirstNameAndLastName(String firstName, String lastName); //methode abstraite
    List<Student> findByClasse(String classe);  //methode abstraite
}
//<Student(classe qui contient la base de données), Integer(type de l'id)>