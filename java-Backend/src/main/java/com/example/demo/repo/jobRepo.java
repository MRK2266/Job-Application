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
     
//	  List <jobPost> jobs=new ArrayList<>();
//	  
//	  public jobRepo() {
//
//			jobs.add(new jobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
//					List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")));
//			
//			jobs.add(
//					new jobPost(2, "Frontend Developer", "Experience in building responsive web applications using React",
//							3, List.of("HTML", "CSS", "JavaScript", "React")));
//
//			jobs.add(new jobPost(3, "Data Scientist", "Strong background in machine learning and data analysis", 4,
//					List.of("Python", "Machine Learning", "Data Analysis")));
//
//			jobs.add(new jobPost(4, "Network Engineer",
//					"Design and implement computer networks for efficient data communication", 5,
//					List.of("Networking", "Cisco", "Routing", "Switching")));
//
//			jobs.add(new jobPost(5, "Mobile App Developer", "Experience in mobile app development for iOS and Android",
//							3, List.of("iOS Development", "Android Development", "Mobile App")));
//
//
//	  }
//	  
//
//	
//	public List<jobPost> getAlljobs(){
//		return jobs;
//	}
//
//
//
//	public void addjob(jobPost jobpost) {
//		
//         jobs.add(jobpost);
//		
//	}
//
//
//
//	public jobPost getJob(int postId) {
//	  
//		for( jobPost job:jobs) {
//			if(postId==job.getPostId()) {
//				return job;
//			}	
//		}
//		return null;
//	}
//
//
//
//	public void updateJob(jobPost job) {
//		for(jobPost jobb: jobs) {
//			if(job.getPostId()==jobb.getPostId()) {
//				jobb.setPostProfile(job.getPostProfile());
//				jobb.setPostDesc(job.getPostDesc());
//				jobb.setReqExperience(job.getReqExperience());
//				jobb.setPostTechStack(job.getPostTechStack());
//			}
//		}
//		
//	}
//
//
//
//	public void removeJob(int postId) {
//		for(jobPost job:jobs) {
//			if(postId==job.getPostId()) {
//				jobs.remove(job);
//			}
//		}
//		
//	}


