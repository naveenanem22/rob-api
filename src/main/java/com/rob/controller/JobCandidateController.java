package com.rob.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rob.model.JobCandidate;
import com.rob.service.JobCandidateService;

@RestController(value = "jobCandidateController")
@RequestMapping(path = "/jobcandidatelist")
@Validated
public class JobCandidateController {

	@Autowired
	@Qualifier(value = "jobCandidateServiceImpl")
	private JobCandidateService jobCandidateService;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> createJobCandidateRecords(@Valid @RequestBody List<JobCandidate> jobCandidates) {
		jobCandidateService.createJobCandidateRecords(jobCandidates);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> updateJobCandidateRecords(@Valid @RequestBody List<JobCandidate> jobCandidates) {
		jobCandidateService.updateJobCandidateRecords(jobCandidates);
		return ResponseEntity.noContent().build();
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<JobCandidate>> listJobCandidateRecordsByJobPostId(
			@RequestParam("jobPostId") int jobPostId) {
		List<JobCandidate> jobCandidates = jobCandidateService.listJobCandidateRecordsByJobPostId(jobPostId);

		return new ResponseEntity<List<JobCandidate>>(jobCandidates, HttpStatus.ACCEPTED);
	}

	@DeleteMapping
	public ResponseEntity<Object> removeJobCandidateRecordsById(@Valid @RequestBody List<Integer> jobCandidateIds) {
		jobCandidateService.removeJobCandidateRecords(jobCandidateIds);
		return ResponseEntity.noContent().build();
	}

}
