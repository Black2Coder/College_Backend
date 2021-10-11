package com.collage.dto;

import org.springframework.data.jpa.repository.JpaRepository;

import com.collage.entity.PostEntity;

public interface PostRepo extends JpaRepository<PostEntity, Integer>{

}
