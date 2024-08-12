package com.arjuncodes.studentsystem.repository;

import com.arjuncodes.studentsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

//<User(classe qi contient la base de données), Long(type de l'id)>
