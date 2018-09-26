package com.rob.service;

import org.springframework.stereotype.Service;

import com.rob.model.Candidate;

@Service(value = "candidateServiceImpl")
public class CandidateServiceImpl implements CandidateService {

	@Override
	public Candidate getCandidate(String candidateId) {				
		return null;
	}

}
