package com.rob.dao;

import java.util.List;

import com.rob.model.CandidatePrevEmployment;

public interface CandidatePrevEmploymentDao {
	public boolean removePrevEmploymentRecords(int candidateId, List<Integer> candidatePrevEmploymentIds);

	public List<CandidatePrevEmployment> listPrevEmploymentRecords(int candidateId);

	public boolean updatePrevEmploymentRecords(int candidateId, List<CandidatePrevEmployment> candidatePrevEmployments);

	public boolean createPrevEmploymentRecords(int candidateId, List<CandidatePrevEmployment> candidatePrevEmployments);

}
