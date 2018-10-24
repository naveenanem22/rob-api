package com.rob.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rob.dao.CandidateEducationDao;
import com.rob.model.CandidateEducation;

@Service(value = "candidateEducationServiceImpl")
public class CandidateEducationServiceImpl implements CandidateEducationService {

	@Autowired
	@Qualifier(value = "candidateEducationDaoImpl")
	private CandidateEducationDao candidateEducationDao;

	@Override
	@Transactional(readOnly = true)
	public List<CandidateEducation> getCandidateEducaitonsByCandidateId(int candidateId) {

		return candidateEducationDao.getCandidateEducaitonsByCandidateId(candidateId);
	}

	@Override
	public boolean updateCandidateEducations(int candidateId, List<CandidateEducation> candidateEducations) {

		return candidateEducationDao.updateCandidateEducations(candidateId, candidateEducations);
	}

	@Override
	public boolean createCandidateEducations(int candidateId, List<CandidateEducation> candidateEducations) {
		Random random = new Random();
		candidateEducations.forEach(candidateEducation -> {
			candidateEducation.setId(random.nextInt((9999 - 1000) + 1) + 1000);
		});

		return candidateEducationDao.createCandidateEducations(candidateId, candidateEducations);
	}

	@Override
	public boolean removeCandidateEducationsByCandidateId(int candidateId, List<Integer> candidateEducationIds) {

		return candidateEducationDao.removeCandidateEducationsByCandidateId(candidateId, candidateEducationIds);
	}

}
