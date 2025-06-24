package com.example.demo.repository;

import com.example.demo.beans.ApplicationFormData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApplicationFormDataRepository extends JpaRepository<ApplicationFormData,Integer> {

    Optional<ApplicationFormData>  findByaddharId(String addharId);
}
