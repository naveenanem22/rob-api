package com.rob.service;

import java.time.LocalDate;
import java.util.List;

import com.rob.model.CandidateEducation;
import com.rob.model.CandidatePrevEmployment;

public interface CandidatePrevEmploymentService {
	public boolean removeCandidatePrevEmploymentRecordsByCompany(String candidateId,
			List<CandidatePrevEmployment> candidatePrevEmployments);

	public List<CandidatePrevEmployment> listPrevEmploymentRecords(String candidateId);

	public boolean updatePrevEmploymentRecords(String candidateId,
			List<CandidatePrevEmployment> candidatePrevEmployments);

	public boolean createPrevEmploymentRecords(String candidateId,
			List<CandidatePrevEmployment> candidatePrevEmployments);

}
