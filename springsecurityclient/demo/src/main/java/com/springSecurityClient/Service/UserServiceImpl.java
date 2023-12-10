package com.springSecurityClient.Service;

import com.springSecurityClient.Entity.User2;
import com.springSecurityClient.Model.Usermodel;
import com.springSecurityClient.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    public User2 registerUser(Usermodel umodel){
        User2 u = new User2();
        u.setEmail(umodel.getEmail());
        u.setName(umodel.getName());
        u.setRole(umodel.getRole());
        u.setEnabled(false);
        u.setPassword(passwordEncoder.encode(umodel.getPassword()));
        userRepository.save(u);
        return u;
    }

}
