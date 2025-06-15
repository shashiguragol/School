package com.example.demo.controller;

import com.example.demo.beans.Person;
import com.example.demo.beans.Roles;
import com.example.demo.beans.RolesConstant;
import com.example.demo.repository.RolesRepository;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonService personService;

    @PostMapping("/save")
    public boolean savePerson(Person person){

        return personService.createNewPerson(person);
   }
    @GetMapping("/getAll")
    public List<Person> getAllPerson(){
        return personService.getAllPerson();
    }

}
