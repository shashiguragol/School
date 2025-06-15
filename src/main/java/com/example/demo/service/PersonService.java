package com.example.demo.service;

import com.example.demo.beans.Person;
import com.example.demo.beans.Roles;
import com.example.demo.beans.RolesConstant;
import com.example.demo.repository.PersonRepository;
import com.example.demo.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {


   @Autowired
    PersonRepository personRepository;

   @Autowired
   RolesRepository rolesRepository;

   public boolean createNewPerson(Person person){
       Roles roles= rolesRepository.getByRoleName(RolesConstant.STUDENT_ROLE);
       person.setRoles(roles);
       Person person1= personRepository.save(person);
       if(person1!=null){
           return true;
       }
       return false;
   }

   public List<Person>  getAllPerson(){
        return (List<Person>) personRepository.findAll();
   }
}
