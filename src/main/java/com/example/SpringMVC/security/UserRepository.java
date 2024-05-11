package com.example.SpringMVC.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface UserRepository extends JpaRepository<UserEntity,String> {
    UserEntity findByName(String name);
}
