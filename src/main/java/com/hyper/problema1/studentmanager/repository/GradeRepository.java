package com.hyper.problema1.studentmanager.repository;

import com.hyper.problema1.studentmanager.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {
}
