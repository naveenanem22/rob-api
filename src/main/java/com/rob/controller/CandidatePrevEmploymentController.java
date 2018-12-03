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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rob.model.CandidatePrevEmployment;
import com.rob.service.CandidatePrevEmploymentService;

@RestController(value = "candidatePrevEmploymentController")
@RequestMapping(path = "/v0/candidate-management/candidates/{candidateId}/prevemployments")
@Validated
public class CandidatePrevEmploymentController {

	@Autowired
	@Qualifier(value = "candidatePrevEmploymentServiceImpl")
	private CandidatePrevEmploymentService candidatePrevEmploymentService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CandidatePrevEmployment>> listPrevEmployments(
			@PathVariable("candidateId") int candidateId) {
		List<CandidatePrevEmployment> candidatePrevEmployments = candidatePrevEmploymentService
				.listPrevEmploymentRecords(candidateId);

		return new ResponseEntity<List<CandidatePrevEmployment>>(candidatePrevEmployments, HttpStatus.OK);

	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> createPrevEmployments(@PathVariable("candidateId") int candidateId,
			@Valid @RequestBody List<CandidatePrevEmployment> candidatePrevEmployments) {
		candidatePrevEmploymentService.createPrevEmploymentRecords(candidateId, candidatePrevEmployments);
		return ResponseEntity.noContent().build();

	}

	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> updatePrevEmployments(@PathVariable("candidateId") int candidateId,
			@Valid @RequestBody List<CandidatePrevEmployment> candidatePrevEmployments) {

		candidatePrevEmploymentService.updatePrevEmploymentRecords(candidateId, candidatePrevEmployments);
		return ResponseEntity.noContent().build();

	}

	@DeleteMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> removePrevEmployments(@PathVariable("candidateId") int candidateId,
			@Valid @RequestBody List<Integer> candidatePrevEmploymentIds) {
		candidatePrevEmploymentService.removePrevEmploymentRecords(candidateId, candidatePrevEmploymentIds);
		return ResponseEntity.noContent().build();
	}

}
