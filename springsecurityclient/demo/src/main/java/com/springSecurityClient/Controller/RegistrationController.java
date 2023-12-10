package com.springSecurityClient.Controller;

import com.springSecurityClient.Entity.User2;
import com.springSecurityClient.Model.Usermodel;
import com.springSecurityClient.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public String get(){
        return "welcome";
    }

    @GetMapping("/admin")
    public String adminApi(){
        return "this is admin";
    }
    @GetMapping("/user")
    public String userApi()
    {
        return "this is user";
    }

    @PostMapping("/save")
    public String saveUser(@RequestBody Usermodel userModel){

        User2 u = userService.registerUser(userModel);

        return "success";

    }
}
