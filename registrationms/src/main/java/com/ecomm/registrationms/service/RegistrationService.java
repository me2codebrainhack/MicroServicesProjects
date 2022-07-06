package com.ecomm.registrationms.service;

import com.ecomm.registrationms.model.Registration;
import com.ecomm.registrationms.repo.RegistrationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepo registrationRepo;

    public boolean isRegistered(String userName){
        boolean isRegistered = false;
        List<Registration> register = registrationRepo.findAll();
        for(int i=0;i<register.size();i++){
            if(userName.equalsIgnoreCase(register.get(i).getUserName())){
                isRegistered = true;
                break;
            }
        }
        return isRegistered;
    }
}
