package com.rob.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rob.model.JobPost;
import com.rob.service.JobPostService;

@RestController(value = "jobPostController")
@RequestMapping(path = "/jobposts")
public class JobPostController {

	@Autowired
	@Qualifier(value = "jobPostServiceImpl")
	private JobPostService jobPostService;

	@GetMapping(path = "/{id}")
	public ResponseEntity<List<JobPost>> getJobPostsById(@PathVariable("id") String jobPostId) {

		return new ResponseEntity<List<JobPost>>(jobPostService.getJobPostsById(jobPostId), HttpStatus.ACCEPTED);

	}

}
