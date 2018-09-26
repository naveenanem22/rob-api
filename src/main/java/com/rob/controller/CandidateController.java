package com.rob.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rob.model.Candidate;
import com.rob.service.CandidateService;
import com.rob.service.CandidateServiceImpl;

@RestController(value = "candidateController")
@RequestMapping("/candidates")
public class CandidateController {

	@Autowired
	@Qualifier("candidateServiceImpl")
	CandidateService candidateService;

	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Candidate getCandidate(@PathVariable("id") String candidateId) {

		return candidateService.getCandidate(candidateId);
	}

}
