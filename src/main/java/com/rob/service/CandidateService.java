package com.rob.service;

import com.rob.model.Candidate;

public interface CandidateService {
	
	Candidate getCandidateById(int candidateId);
	boolean createCandidate(Candidate candidate);
	boolean updateCandidate(Candidate candidate);
	boolean deleteCandidateById(int candidateId);

}
