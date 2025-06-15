package com.example.demo.controller;


import com.example.demo.beans.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/create")
    Student save(Student student){
       return studentService.save(student);

    }
    @GetMapping("/getAll")
    List<Student> get(){
        return (List<Student>) studentService.findByAll();

    }



}
