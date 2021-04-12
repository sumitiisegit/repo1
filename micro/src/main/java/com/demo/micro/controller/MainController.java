package com.demo.micro.controller;

import com.demo.micro.model.Student;
import com.demo.micro.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

public class MainController {

    @Autowired
    StudentService studentService;

    @RequestMapping(value="/hello", method = RequestMethod.GET)
    public String greetings(){
        return "Hello spring boot micro service. from Get";
    }
    @RequestMapping(value="/hello", method = RequestMethod.POST)
    public String greetings2(){
        return "Hello spring boot micro service. from POST";
    }


    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public Student save(@RequestBody Student student){
        return studentService.save(student);
    }

    @RequestMapping(value = "/student", method= RequestMethod.GET)
    public ResponseEntity<Student> fetchStudent(@RequestParam int id){
        Student student = studentService.fetchStudentById(id);
        if(null == student){
            return ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.ok().body(student);
        }
    }
}
