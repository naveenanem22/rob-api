package com.rob.service;

import java.util.List;

import com.rob.model.CandidateEducation;

public interface CandidateEducationService {

	List<CandidateEducation> getCandidateEducaitonsByCandidateId(int candidateId);

	boolean updateCandidateEducations(int candidateId, List<CandidateEducation> candidateEducations);

	boolean createCandidateEducations(int candidateId, List<CandidateEducation> candidateEducations);

	boolean removeCandidateEducationsByCandidateId(int candidateId, List<Integer> candidateEducationIds);

}
