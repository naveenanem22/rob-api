package com.rob.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import com.rob.model.CandidateEducation;

public interface CandidateEducationDao {

	List<CandidateEducation> getCandidateEducaitonsByCandidateId(int candidateId);

	boolean updateCandidateEducations(int candidateId, List<CandidateEducation> candidateEducations);

	boolean createCandidateEducations(int candidateId, List<CandidateEducation> candidateEducations);

	boolean removeCandidateEducationsByCandidateId(int candidateId, List<Integer> candidateEducationIds);

}
