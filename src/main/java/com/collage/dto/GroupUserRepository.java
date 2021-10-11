package com.collage.dto;

import com.collage.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GroupUserRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findByContact(String contact);
}
