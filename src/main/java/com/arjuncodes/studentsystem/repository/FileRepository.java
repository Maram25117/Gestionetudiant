package com.arjuncodes.studentsystem.repository;

import com.arjuncodes.studentsystem.model.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Long> {
}

