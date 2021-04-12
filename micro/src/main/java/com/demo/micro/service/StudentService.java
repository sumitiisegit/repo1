package com.demo.micro.service;

import com.demo.micro.model.Student;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


public interface StudentService {

    Student save(Student student);
    public Student fetchStudentById(int id);
}
