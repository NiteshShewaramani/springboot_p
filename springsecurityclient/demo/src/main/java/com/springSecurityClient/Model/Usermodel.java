package com.springSecurityClient.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usermodel {

    private String name;
    private String email;
    private String password;
    private String role;
    private boolean enabled;
}
