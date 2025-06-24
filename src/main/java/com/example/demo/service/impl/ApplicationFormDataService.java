package com.example.demo.service.impl;


import com.example.demo.beans.ApplicationFormData;
import com.example.demo.exception.CustomerAlreadyExitsException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ApplicationFormDataRepository;
import com.example.demo.service.IApplicationFormDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApplicationFormDataService implements IApplicationFormDataService {

    @Autowired
    ApplicationFormDataRepository applicationFormDataRepository;



    public void create(ApplicationFormData applicationFormData){
       Optional<ApplicationFormData>  optionalApplication=applicationFormDataRepository.findByaddharId(applicationFormData.getAddharId());

       if(optionalApplication.isPresent()){
           throw new CustomerAlreadyExitsException("Apllication for this student is already exits " + applicationFormData.getAddharId());
       }
        applicationFormDataRepository.save(applicationFormData);

    }

    @Override
    public ApplicationFormData fetchApplicationData(String addharId) {
        ApplicationFormData optionalApplication = applicationFormDataRepository.findByaddharId(addharId).orElseThrow(() -> new ResourceNotFoundException("student", "addharID", addharId));

        return optionalApplication;
    }

    @Override
    public boolean update(ApplicationFormData applicationFormData) {
        boolean updateStatus=false;
        applicationFormDataRepository.findByaddharId(applicationFormData.getAddharId()).orElseThrow(() -> new ResourceNotFoundException("student", "addharID", applicationFormData.getAddharId()));

            applicationFormDataRepository.save(applicationFormData);

            updateStatus = true;

        return updateStatus;
    }

    @Override
    public boolean delete(int id) {
        boolean deleteStatus=false;
        ApplicationFormData applicationFormData=applicationFormDataRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("student", "addharID","123"));
        applicationFormDataRepository.deleteById(id);;
        deleteStatus= true;

        return deleteStatus;
    }

}
