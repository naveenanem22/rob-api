package com.rob.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rob.model.CandidateEducation;
import com.rob.service.CandidateEducationService;

@RestController(value = "candidateEducationController")
@RequestMapping("/candidates/{id}/qualifications")
public class CandidateEducationController {

	@Autowired
	@Qualifier(value = "candidateEducationServiceImpl")
	private CandidateEducationService candidateEducationService;

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void updateCandidateEducations(@PathVariable("id") String candidateId,
			@Valid @RequestBody List<CandidateEducation> candidateEducations) {

		candidateEducationService.updateCandidateEducations(candidateId, candidateEducations);

	}

}
