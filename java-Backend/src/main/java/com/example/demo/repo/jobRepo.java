package com.example.demo.repo;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.jobPost;

 @Repository
public interface jobRepo extends JpaRepository<jobPost, Integer> {
	 
	 //List<jobPost> findBypostProfileContainingorpostDescContaining(String postProfile,String postDesc);
	 List<jobPost> findByPostProfileContainingOrPostDescContaining(String postProfile, String postDesc);

 }
     



