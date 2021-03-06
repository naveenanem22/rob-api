package com.rob.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rob.model.JobPost;
import com.rob.service.JobPostService;

@RestController(value = "jobPostController")
@RequestMapping(path = "/v0/jobposts")
public class JobPostController {

	@Autowired
	@Qualifier(value = "jobPostServiceImpl")
	private JobPostService jobPostService;

	@GetMapping(path = "/{id}")
	public ResponseEntity<JobPost> getJobPostsById(@PathVariable("id") int jobPostId) {

		return new ResponseEntity<JobPost>(jobPostService.getJobPostsById(jobPostId), HttpStatus.ACCEPTED);

	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Integer>> createJobPost(@Valid @RequestBody JobPost jobPost) {
		Map<String, Integer> result = new HashMap<String, Integer>();
		result.put("jobPostId", Integer.valueOf(jobPostService.createJobPost(jobPost)));

		return new ResponseEntity<Map<String, Integer>>(result, HttpStatus.OK);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Object> removeJobPost(@PathVariable("id") int jobPostId) {
		jobPostService.removeJobPostById(jobPostId);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, path = "/{id}")
	public ResponseEntity<Object> updateJobPost(@PathVariable("id") int jobPostId,
			@Valid @RequestBody JobPost jobPost) {
		jobPost.setId(jobPostId);
		jobPostService.updateJobPost(jobPost);
		return ResponseEntity.noContent().build();
	}

}
