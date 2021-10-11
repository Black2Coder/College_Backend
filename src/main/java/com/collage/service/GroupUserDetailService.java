package com.collage.service;

import com.collage.dto.GroupUserRepository;
import com.collage.entity.Users;
import com.collage.model.GroupUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class GroupUserDetailService implements UserDetailsService {
    @Autowired
    private GroupUserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String contact) throws UsernameNotFoundException {
        Optional<Users> user = repo.findByContact(contact);
        return user.map(GroupUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException(contact+" doesn't exist"));
    }
}
