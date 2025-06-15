package com.example.demo.service;

import com.example.demo.beans.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

     public Student save(Student student){
         Student resultStudent= studentRepository.save(student);
         return resultStudent;

      }
    public List<Student> findByAll(){
        List<Student>resultStudent= (List<Student>) studentRepository.findAll();
        return resultStudent;

    }



}
