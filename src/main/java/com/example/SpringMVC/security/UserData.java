package com.example.SpringMVC.security;

import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Data
public class UserData {
    private String password;
    private String role;
    private UserEntity userEntity;
    private UserRepository repository;

    private BCryptPasswordEncoder encoder;

    public UserData(String name){
        userEntity = repository.findByName(name);
        this.password =  encoder.encode(userEntity.getPassword());
        this.role = userEntity.getRole();
    }

}
