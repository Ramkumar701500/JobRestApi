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
import com.api.model.JobCategory;


@RestController
public class JobCategoryController
{
	
	private List<JobCategory> JobCategoryList = new ArrayList<JobCategory>();
	
	
	//creating post mapping that post the job category detail
	@PostMapping("/save-jobcategory")
	private ResponseEntity<?> saveJobCategory(@RequestBody JobCategory jobCategory) 
	{
		JobCategoryList.add(jobCategory);
		
		System.out.println(jobCategory);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	
	//creating a get mapping that retrieves the detail of an specific job category
	@GetMapping("/show-jobcategory/{id}")
	private ResponseEntity<JobCategory> getJobCategory(@PathVariable("id") int jobCategoryId) 
	{	
		JobCategory foundJobCategory = null;
		
		for(JobCategory jc : JobCategoryList) 
		{ 
			if(jc.getId() == jobCategoryId) 
			{ 
				foundJobCategory = jc;
				break;
			}
		}
		
		if(foundJobCategory != null)
		{
			System.out.println(foundJobCategory);
			
			return ResponseEntity.ok(foundJobCategory);		// return 200, with json body
	    }
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);		// return 404, with null body	
	}
	
	
	//creating a get mapping that retrieves the detail of all the job categories
	@GetMapping("/show-jobcategories")
	private ResponseEntity<List<JobCategory>> getAllJobCategory() 
	{	
		if(JobCategoryList.size() != 0)
		{
			System.out.println(JobCategoryList);
			
			return ResponseEntity.ok(JobCategoryList);
		}
		
		else
		{
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null); // return 402, with null body
		}		
	}
	
	
	//creating a delete mapping that deletes an specified job category
	@DeleteMapping("/delete-jobcategory/{id}")
	private ResponseEntity<?> deleteJobCategory(@PathVariable("id") int jobCategoryId) 
	{
		JobCategory foundJobCategory = null;
		
		for(JobCategory jc : JobCategoryList) 
		{ 
			if(jc.getId() == jobCategoryId) 
			{ 
				foundJobCategory = jc;
				break;
			}
		}
		
		if(foundJobCategory == null)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		JobCategoryList.remove(foundJobCategory);
		
		System.out.println("JobCategory With ID "+jobCategoryId+" Is Deleted"); 
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	//creating put mapping that updates the job category detail
	@PutMapping("/update-jobcategory/{id}")
	private ResponseEntity<?> updateJobCategory(@PathVariable("id") int jobCategoryId, @RequestBody JobCategory jobCategoryNew) 
	{	
		int index=0;
		
		for(JobCategory jc : JobCategoryList) 
		{ 
			if(jc.getId() == jobCategoryId) 
			{ 
				index = JobCategoryList.indexOf(jc);
				break;
			}
		}
		
		if(index == 0)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		JobCategoryList.set(index, jobCategoryNew);
	
		System.out.println(jobCategoryNew);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	//creating get mapping that shows the welcome page of job category
	@GetMapping("/category")
	public String welcomePage() 
	{
		return "Hello and Welcome to the Job Category Rest Api application";
	}

}
