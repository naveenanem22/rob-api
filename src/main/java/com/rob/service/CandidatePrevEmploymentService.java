package com.rob.service;

import java.time.LocalDate;
import java.util.List;

import com.rob.model.CandidateEducation;
import com.rob.model.CandidatePrevEmployment;

public interface CandidatePrevEmploymentService {
	public boolean removePrevEmploymentRecords(int candidateId, List<Integer> candidatePrevEmploymentIds);

	public List<CandidatePrevEmployment> listPrevEmploymentRecords(int candidateId);

	public boolean updatePrevEmploymentRecords(int candidateId, List<CandidatePrevEmployment> candidatePrevEmployments);

	public boolean createPrevEmploymentRecords(int candidateId, List<CandidatePrevEmployment> candidatePrevEmployments);

}
