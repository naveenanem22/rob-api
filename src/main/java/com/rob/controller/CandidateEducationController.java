package com.rob.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
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
@RequestMapping("/candidates/{id}/qualifications")

@Validated
public class CandidateEducationController {

	@Autowired
	@Qualifier(value = "candidateEducationServiceImpl")
	private CandidateEducationService candidateEducationService;

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void updateCandidateEducations(@Valid @RequestBody List<CandidateEducation> candidateEducations,
			@PathVariable("id") String candidateId) {

		candidateEducationService.updateCandidateEducations(candidateId, candidateEducations);

	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> createCandidateEducations(
			@Valid @RequestBody List<CandidateEducation> candidateEducations, @PathVariable("id") String candidateId) {

		candidateEducationService.createCandidateEducations(candidateId, candidateEducations);
		return ResponseEntity.noContent().build();

	}

	@DeleteMapping(path = "/{qualStartDate}")
	public void deleteCandidateEducationByQualStartDate(@PathVariable("id") String candidateId,
			@PathVariable("qualStartDate") String strQualStartDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate qualStartDate = LocalDate.parse(strQualStartDate, formatter);
		candidateEducationService.removeCandidateEducationByStartDate(candidateId, qualStartDate);
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CandidateEducation> getCandidateEducations(@PathVariable("id") String candidateId) {
		return candidateEducationService.getCandidateEducaitonsByCandidateId(candidateId);
	}

}
