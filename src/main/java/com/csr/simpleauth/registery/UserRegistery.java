package com.csr.simpleauth.registery;

import com.csr.simpleauth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRegistery extends JpaRepository<User, Long> {
    public User findByEmail(String email);
}
