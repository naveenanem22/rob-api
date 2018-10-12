package com.rob.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rob.dao.CandidatePrevEmploymentDao;
import com.rob.model.CandidatePrevEmployment;

@Service(value = "candidatePrevEmploymentServiceImpl")
public class CandidatePrevEmploymentServiceImpl implements CandidatePrevEmploymentService {

	@Autowired
	@Qualifier(value = "candidatePrevEmploymentDaoImpl")
	private CandidatePrevEmploymentDao candidatePrevEmploymentDao;

	@Override
	@Transactional
	public boolean removeCandidatePrevEmploymentRecordsByCompany(String candidateId,
			List<CandidatePrevEmployment> candidatePrevEmployments) {
		return candidatePrevEmploymentDao.removeCandidatePrevEmploymentRecordsByCompany(candidateId,
				candidatePrevEmployments);

	}

	@Override
	@Transactional(readOnly = true)
	public List<CandidatePrevEmployment> listPrevEmploymentRecords(String candidateId) {

		return candidatePrevEmploymentDao.listPrevEmploymentRecords(candidateId);
	}

	@Override
	@Transactional
	public boolean updatePrevEmploymentRecords(String candidateId,
			List<CandidatePrevEmployment> candidatePrevEmployments) {

		return candidatePrevEmploymentDao.updatePrevEmploymentRecords(candidateId, candidatePrevEmployments);
	}

	@Override
	@Transactional
	public boolean createPrevEmploymentRecords(String candidateId,
			List<CandidatePrevEmployment> candidatePrevEmployments) {
		
		return candidatePrevEmploymentDao.createPrevEmploymentRecords(candidateId, candidatePrevEmployments);
	}

}
