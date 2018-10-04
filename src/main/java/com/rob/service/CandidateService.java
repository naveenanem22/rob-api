package com.rob.service;

import com.rob.model.Candidate;

public interface CandidateService {
	
	Candidate getCandidateById(String candidateId);
	boolean createCandidate(Candidate candidate);
	boolean updateCandidate(Candidate candidate);
	boolean deleteCandidateById(String candidateId);

}
