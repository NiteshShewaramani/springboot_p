package com.springSecurityClient.Service;

import com.springSecurityClient.Entity.User2;
import com.springSecurityClient.Model.Usermodel;
import org.springframework.stereotype.Component;

@Component
public interface UserService {

    public User2 registerUser(Usermodel umodel);
}
