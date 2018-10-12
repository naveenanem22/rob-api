package com.rob.dao;

import java.util.List;

import com.rob.model.CandidatePrevEmployment;

public interface CandidatePrevEmploymentDao {
	public boolean removeCandidatePrevEmploymentRecordsByCompany(String candidateId,
			List<CandidatePrevEmployment> candidatePrevEmployments);

	public List<CandidatePrevEmployment> listPrevEmploymentRecords(String candidateId);

	public boolean updatePrevEmploymentRecords(String candidateId,
			List<CandidatePrevEmployment> candidatePrevEmployments);

	public boolean createPrevEmploymentRecords(String candidateId,
			List<CandidatePrevEmployment> candidatePrevEmployments);

}
