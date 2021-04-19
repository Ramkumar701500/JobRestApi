package com.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.api.model.JobSeeker;


@RestController
public class JobSeekerController
{
	
	private List<JobSeeker> JobSeekerList = new ArrayList<JobSeeker>();
	
	
	//creating post mapping that post the job seeker detail
	@PostMapping("/save-jobseeker")
	private ResponseEntity<?> saveJobSeeker(@RequestBody JobSeeker jobSeeker) 
	{
		JobSeekerList.add(jobSeeker);
		
		System.out.println(jobSeeker);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	
	//creating a get mapping that retrieves the detail of an specific job seeker
	@GetMapping("/show-jobseeker/{id}")
	private ResponseEntity<JobSeeker> getJobSeeker(@PathVariable("id") int jobSeekerId) 
	{	
		JobSeeker foundJobSeeker = null;
		
		for(JobSeeker js : JobSeekerList) 
		{ 
			if(js.getId() == jobSeekerId) 
			{ 
				foundJobSeeker = js;
				break;
			}
		}
		
		if(foundJobSeeker != null)
		{
			System.out.println(foundJobSeeker);
			
			return ResponseEntity.ok(foundJobSeeker);		// return 200, with json body
	    }
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);		// return 404, with null body	
	}
	
	
	//creating a get mapping that retrieves the detail of all the job seekers
	@GetMapping("/show-jobseekers")
	private ResponseEntity<List<JobSeeker>> getAllJobSeeker() 
	{	
		if(JobSeekerList.size() != 0)
		{
			System.out.println(JobSeekerList);
			
			return ResponseEntity.ok(JobSeekerList);
		}
		
		else
		{
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null); // return 402, with null body
		}		
	}
	
	
	//creating a delete mapping that deletes an specified job seeker
	@DeleteMapping("/delete-jobseeker/{id}")
	private ResponseEntity<?> deleteJobSeeker(@PathVariable("id") int jobSeekerId) 
	{
		JobSeeker foundJobSeeker = null;
		
		for(JobSeeker js : JobSeekerList) 
		{ 
			if(js.getId() == jobSeekerId) 
			{ 
				foundJobSeeker = js;
				break;
			}
		}
		
		if(foundJobSeeker == null)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		JobSeekerList.remove(foundJobSeeker);
		
		System.out.println("JobSeeker With ID "+jobSeekerId+" Is Deleted"); 
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	//creating put mapping that updates the job seeker detail
	@PutMapping("/update-jobseeker/{id}")
	private ResponseEntity<?> updateJobSeeker(@PathVariable("id") int jobSeekerId, @RequestBody JobSeeker jobSeekerNew) 
	{	
		int index=-1;
		
		for(JobSeeker js : JobSeekerList) 
		{ 
			if(js.getId() == jobSeekerId) 
			{ 
				index = JobSeekerList.indexOf(js);
				break;
			}
		}
		
		if(index == -1)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		JobSeekerList.set(index, jobSeekerNew);
	
		System.out.println(jobSeekerNew);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	//creating get mapping that shows the welcome page of job seeker
	@GetMapping("/")
	public String welcomePage() 
	{
		return "Hello and Welcome to the Job Seeker Rest Api application";
	}

}
