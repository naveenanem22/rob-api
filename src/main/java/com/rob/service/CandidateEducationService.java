package com.rob.service;

import java.time.LocalDate;
import java.util.List;

import com.rob.model.CandidateEducation;

public interface CandidateEducationService {

	boolean updateCandidateEducations(String candidateId, List<CandidateEducation> candidateEducations);

	boolean createCandidateEducations(String candidateId, List<CandidateEducation> candidateEducations);

	boolean removeCandidateEducationByStartDate(String candidateId, LocalDate qualStartDate);
	
	List<CandidateEducation> getCandidateEducaitonsByCandidateId(String candidateId);

}
