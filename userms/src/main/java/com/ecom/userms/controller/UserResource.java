package com.ecom.userms.controller;

import com.ecom.userms.model.User;
import com.ecom.userms.repo.UserRepo;
import com.ecom.userms.service.Service;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping(path = "users")
public class UserResource {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private Service service;

    @Autowired
    private RestTemplate restTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserResource.class);

    @GetMapping("/getAll")
    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    @GetMapping("/findUserByFirstName")
    public List<User> byFirstName(@RequestParam String firstname){
        return  userRepo.findByFirstName(firstname);
    }

    @GetMapping("/findUserByLastName")
    public List<User> byLastName(@RequestParam String lastname){
        return  userRepo.findByLastName(lastname);
    }

    @PostMapping("/registerUser")
    public User createUser(@RequestBody User createdUser){
        User created = userRepo.save(createdUser);
        return createdUser;
    }

    @PostMapping("/updateUser")
    public User updateUser(@RequestParam int id,@RequestBody User updatedUser){
        User updated = service.updateUser(id,updatedUser);
        return updated;
    }

    @GetMapping("/isRegistered")
    @HystrixCommand(fallbackMethod = "isRegisteredFallBack")
    public boolean isRegistered(@RequestParam String userName){
        LOGGER.info("Calling is registered rest api from REGISTERMS Micro");
        return Boolean.TRUE.equals(restTemplate.getForObject("http://registerms/register/isregistered?userName={username}", Boolean.class, userName));
    }

    private boolean isRegisteredFallBack(String userName){
        LOGGER.info("***** Hitting Fallback Method *****");
        return false;
    }
}
