package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.jobPost;
import com.example.demo.server.jobServer;

@RestController 
@CrossOrigin(origins = "http://localhost:3000")
public class  homeController {
       
	@Autowired
	 private jobServer server;
	 
	 @GetMapping("jobPosts") 
	public List<jobPost> getalljobs(){
		return server.getAllJobs();
	}
	
	@GetMapping("jobPost/{postId}")
	public jobPost getJob(@PathVariable int postId) {
		return server.getJob(postId);
	}
	
	@PostMapping("jobPost") 
	public void addJob(@RequestBody jobPost job) {
		server.addJob(job);
	}
	
	@PutMapping("jobPost")
	public void updateJob(@RequestBody jobPost job) {
		server.updateJob(job);
	}
	
	@DeleteMapping("jobPost/{postId}")
	public void removeJob( @PathVariable int postId) {
		server.removeJob(postId);
		
	}
	
	@GetMapping("load")
	public String load() {
	  return server.load();
	}
	 
	@GetMapping("jobPosts/Keyword/{keyword}")
	public List<jobPost> search(@PathVariable("keyword") String keyword){
		
		return server.search(keyword);
	}
}
