package com.example.SpringMVC.security;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name="users")
@Data
public class UserEntity {
    @Id
    private String id;
    private String name;
    private String password;
    private String role;

}
