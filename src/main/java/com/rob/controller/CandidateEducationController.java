package com.rob.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rob.model.CandidateEducation;
import com.rob.service.CandidateEducationService;

@RestController(value = "candidateEducationController")
@RequestMapping("/v0/candidate-management/candidates/{id}/qualifications")

@Validated
public class CandidateEducationController {

	@Autowired
	@Qualifier(value = "candidateEducationServiceImpl")
	private CandidateEducationService candidateEducationService;

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void updateCandidateEducations(@Valid @RequestBody List<CandidateEducation> candidateEducations,
			@PathVariable("id") int candidateId) {

		candidateEducationService.updateCandidateEducations(candidateId, candidateEducations);

	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> createCandidateEducations(
			@Valid @RequestBody List<CandidateEducation> candidateEducations, @PathVariable("id") int candidateId) {

		candidateEducationService.createCandidateEducations(candidateId, candidateEducations);
		return ResponseEntity.noContent().build();

	}

	@DeleteMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteCandidateEducationByQualStartDate(@PathVariable("id") int candidateId,
			@Valid @RequestBody List<Integer> candidateEducationIds) {

		candidateEducationService.removeCandidateEducationsByCandidateId(candidateId, candidateEducationIds);
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CandidateEducation> getCandidateEducations(@PathVariable("id") int candidateId) {
		return candidateEducationService.getCandidateEducaitonsByCandidateId(candidateId);
	}

}
