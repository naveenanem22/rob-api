package com.rob.controller;

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

import com.rob.model.Interview;
import com.rob.service.InterviewService;

@RestController(value = "interviewController")
@RequestMapping(path = "/interviews")
public class InterviewController {

	@Autowired
	@Qualifier(value = "interviewServiceImpl")
	private InterviewService interviewService;

	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Interview> getInterviewById(@PathVariable("id") int interviewId) {
		Interview interview = interviewService.getInterviewById(interviewId);
		return new ResponseEntity<Interview>(interview, HttpStatus.ACCEPTED);

	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> createInterviewById(@RequestBody Interview interview) {
		interviewService.createInterview(interview);
		return new ResponseEntity<String>("Success", HttpStatus.CREATED);

	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, path = "/{id}")
	public ResponseEntity<Object> updateInterviewById(@RequestBody Interview interview,
			@PathVariable("id") int interviewId) {
		interview.setId(interviewId);
		interviewService.updateInterviewById(interview);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Object> removeInterviewById(@PathVariable("id") int interviewId) {
		interviewService.removeInterviewById(interviewId);
		return ResponseEntity.noContent().build();
	}

}
