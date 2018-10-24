package com.rob.service;

import java.util.List;
import java.util.Random;

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
	public boolean removePrevEmploymentRecords(int candidateId, List<Integer> candidatePrevEmploymentIds) {

		return candidatePrevEmploymentDao.removePrevEmploymentRecords(candidateId, candidatePrevEmploymentIds);
	}

	@Override
	@Transactional(readOnly = true)
	public List<CandidatePrevEmployment> listPrevEmploymentRecords(int candidateId) {

		return candidatePrevEmploymentDao.listPrevEmploymentRecords(candidateId);
	}

	@Override
	@Transactional
	public boolean updatePrevEmploymentRecords(int candidateId,
			List<CandidatePrevEmployment> candidatePrevEmployments) {

		return candidatePrevEmploymentDao.updatePrevEmploymentRecords(candidateId, candidatePrevEmployments);
	}

	@Override
	@Transactional
	public boolean createPrevEmploymentRecords(int candidateId,
			List<CandidatePrevEmployment> candidatePrevEmployments) {
		Random random = new Random();
		candidatePrevEmployments.forEach(candidatePrevEmployment -> {
			candidatePrevEmployment.setId(random.nextInt((9999 - 1000) + 1) + 1000);
		});

		return candidatePrevEmploymentDao.createPrevEmploymentRecords(candidateId, candidatePrevEmployments);
	}

}
