package com.demo.micro.repository;

import com.demo.micro.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    // below not required if extend from JPA repository
   // Student save(Student student);
}
