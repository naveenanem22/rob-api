package com.rob.dao;

import com.rob.model.Candidate;

public interface CandidateDao {

	Candidate getCandidateById(int candidateId);

	boolean createCandidate(Candidate candidate);

	boolean updateCandidate(Candidate candidate);

	boolean deleteCandidateById(int candidateId);

}
