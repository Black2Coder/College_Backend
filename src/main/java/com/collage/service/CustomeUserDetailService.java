package com.collage.service;

import com.collage.dto.UserRepo;

import com.collage.entity.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class CustomeUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String contact) throws UsernameNotFoundException {
        Users user = repo.findByContact(contact);
        return new org.springframework.security.core.userdetails.User(user.getContact(), user.getPassword(), new ArrayList<>());
    }
}
