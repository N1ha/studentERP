package dev.erp.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.erp.student.model.Student;

@Repository

public interface StudentRepository extends JpaRepository<Student ,Integer>{

}
