package com.rob.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rob.model.Candidate;
import com.rob.service.CandidateService;

@RestController(value = "candidateController")
@RequestMapping("/candidates")
public class CandidateController {

	@Autowired
	@Qualifier("candidateServiceImpl")
	CandidateService candidateService;

	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Resource<Candidate> getCandidate(@PathVariable("id") int candidateId) {
		Candidate candidate = candidateService.getCandidateById(candidateId);
		Resource<Candidate> resource = new Resource<Candidate>(candidate);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listCandidates());
		resource.add(linkTo.withRel("all-candidates"));
		return resource;
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> createCandidate(@Valid @RequestBody Candidate candidate) {

		candidateService.createCandidate(candidate);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(candidate.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Candidate> listCandidates() {
		return null;
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, path = "/{id}")
	public ResponseEntity<Object> updateCandidate(@Valid @RequestBody Candidate candidate,
			@PathVariable("id") int candidateId) {
		candidate.setId(candidateId);
		candidateService.updateCandidate(candidate);

		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(path = "/{id}")
	public void deleteCandidate(@PathVariable("id") int candidateId) {
		candidateService.deleteCandidateById(candidateId);
	}

}
