package com.ecomm.registrationms.controller;

import com.ecomm.registrationms.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/register")
public class RegistrationController {

    @Autowired
    private RegistrationService registerService;

    @GetMapping("/isregistered")
    public boolean registerUser(String userName){
        return registerService.isRegistered(userName);
    }

}
