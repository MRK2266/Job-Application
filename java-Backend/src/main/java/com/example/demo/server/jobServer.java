package com.example.demo.server;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.jobPost;
import com.example.demo.repo.jobRepo;

@Service
public class jobServer {
    
	@Autowired
	private jobRepo repo;
	
	public void addJob(jobPost jobpost) {
		
		repo.save(jobpost);
	}
	
	public List<jobPost> getAllJobs(){
		
		return repo.findAll();
	}

	public jobPost getJob(int postId) {
		
		return repo.findById(postId).orElse(new jobPost());
	}

	public void updateJob(jobPost job) {
		repo.save(job);
		
	}

	public void removeJob(int postId) {
		repo.deleteById(postId);
		
	}
	
	public String load() {
  
	 List <jobPost> jobs=new ArrayList<>();
	 
	 jobs.add(new jobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
				List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")));
		
		jobs.add(
				new jobPost(2, "Frontend Developer", "Experience in building responsive web applications using React",
						3, List.of("HTML", "CSS", "JavaScript", "React")));

		jobs.add(new jobPost(3, "Data Scientist", "Strong background in machine learning and data analysis", 4,
				List.of("Python", "Machine Learning", "Data Analysis")));

		jobs.add(new jobPost(4, "Network Engineer",
				"Design and implement computer networks for efficient data communication", 5,
				List.of("Networking", "Cisco", "Routing", "Switching")));

		jobs.add(new jobPost(5, "Mobile App Developer", "Experience in mobile app development for iOS and Android",
						3, List.of("iOS Development", "Android Development", "Mobile App")));
		
		
		repo.saveAll(jobs);
		
		return "success";
	}

	public List<jobPost> search(String keyword) {
		//there is no inbuilt method for search by keyword have to write it in repo class
		return repo.findByPostProfileContainingOrPostDescContaining(keyword, keyword);
		//return repo.findBypostProfileContaining(keyword);
	}

	
}
