package com.rob.service;

import java.util.List;

import com.rob.model.CandidateEducation;

public interface CandidateEducationService {

	boolean updateCandidateEducations(String candidateId, List<CandidateEducation> candidateEducations);

}
