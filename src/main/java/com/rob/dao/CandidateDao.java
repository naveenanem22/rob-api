package com.rob.dao;

import com.rob.model.Candidate;

public interface CandidateDao {
	
	Candidate getCandidateById(String candidateId);
	boolean createCandidate(Candidate candidate);

}
