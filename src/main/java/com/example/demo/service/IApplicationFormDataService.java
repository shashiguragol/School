package com.example.demo.service;

import com.example.demo.beans.ApplicationFormData;

public interface IApplicationFormDataService {
    public void create(ApplicationFormData applicationFormData);
    public  ApplicationFormData fetchApplicationData(String addharId);
    public boolean  update(ApplicationFormData applicationFormData);
    public boolean delete(int id  );
}
