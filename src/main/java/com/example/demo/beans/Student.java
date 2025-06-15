package com.example.demo.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


import java.time.LocalDate;

@Data
@Entity
public class Student {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
   private int id;

    String name;
    int age;

    int standard;
    String section;
    String blooo_Group;




}
