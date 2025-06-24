package com.example.demo.controller;

import com.example.demo.beans.ApplicationFormData;
import com.example.demo.constants.ApplicationFormConstant;
import com.example.demo.dto.ResponseDtop;
import com.example.demo.service.impl.ApplicationFormDataService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api/v1/application")
public class ApplicationFormDataController {

    @Autowired
    ApplicationFormDataService applicationFormDataService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDtop> createApplication(@RequestBody ApplicationFormData applicationFormData) {

        applicationFormDataService.create(applicationFormData);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDtop(ApplicationFormConstant.STATUS_201, ApplicationFormConstant.MESSAGE_201));
    }

    @GetMapping("/fetch")
    public ResponseEntity<ApplicationFormData> fetchApplication(@RequestParam String addharId) {

        ApplicationFormData applicationFormData =  applicationFormDataService.fetchApplicationData(addharId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(applicationFormData);
    }
    @PutMapping("/update")
    public ResponseEntity<ResponseDtop> fetchApplication(@RequestBody ApplicationFormData applicationFormData) {

        boolean status= applicationFormDataService.update(applicationFormData);
        if(status) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDtop(ApplicationFormConstant.STATUS_200,ApplicationFormConstant.MESSAGE_200));
        }else {
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDtop(ApplicationFormConstant.STATUS_417,ApplicationFormConstant.MESSAGE_417_UPDATE));
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDtop> delete(@RequestParam int id) {

        boolean status= applicationFormDataService.delete(id);
        if(status) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDtop(ApplicationFormConstant.STATUS_200,ApplicationFormConstant.MESSAGE_200));
        }else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDtop(ApplicationFormConstant.STATUS_500,ApplicationFormConstant.MESSAGE_500));
        }
    }
}
