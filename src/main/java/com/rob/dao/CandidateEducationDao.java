package com.rob.dao;

import java.time.LocalDate;
import java.util.List;

import com.rob.model.CandidateEducation;

public interface CandidateEducationDao {

	List<CandidateEducation> getCandidateEducaitonsByCandidateId(String candidateId);

	boolean updateCandidateEducations(String candidateId, List<CandidateEducation> candidateEducations);

	boolean createCandidateEducations(String candidateId, List<CandidateEducation> candidateEducaitons);

	boolean removeCandidateEducations(String candidateId, LocalDate qualStartDate);

}
