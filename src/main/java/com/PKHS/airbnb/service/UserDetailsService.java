package com.PKHS.airbnb.service;

import com.PKHS.airbnb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserDetailsService{
    UserDetails loadWebByUsername(String username);
}
