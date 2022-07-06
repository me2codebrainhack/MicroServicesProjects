package com.ecom.userms.service;

import com.ecom.userms.model.User;
import com.ecom.userms.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private UserRepo userRepo;

    public User updateUser(int id, User changed){
        User present = userRepo.findById(id);
        if(!present.getAddress().equalsIgnoreCase(changed.getAddress())){
            present.setAddress(changed.getAddress());
        }else if(present.getAge()!=changed.getAge()&&changed.getAge()!=0){
            present.setAge(changed.getAge());
        }else if(present.getMobileNumber()!=changed.getMobileNumber()&&changed.getMobileNumber()!=0){
            present.setMobileNumber(changed.getMobileNumber());
        }
        userRepo.save(present);
        return present;
    }


}
