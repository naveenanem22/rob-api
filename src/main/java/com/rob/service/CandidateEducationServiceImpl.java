package com.rob.service;

import java.time.LocalDate;
import java.util.List;

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
	@Transactional
	public boolean updateCandidateEducations(String candidateId, List<CandidateEducation> candidateEducations) {

		return candidateEducationDao.updateCandidateEducations(candidateId, candidateEducations);
	}

	@Override
	@Transactional
	public boolean createCandidateEducations(String candidateId, List<CandidateEducation> candidateEducations) {

		return candidateEducationDao.createCandidateEducations(candidateId, candidateEducations);
	}

	@Override
	@Transactional
	public boolean removeCandidateEducationByStartDate(String candidateId, LocalDate qualStartDate) {

		return candidateEducationDao.removeCandidateEducationByStartDate(candidateId, qualStartDate);
	}

	@Override
	@Transactional(readOnly = true)
	public List<CandidateEducation> getCandidateEducaitonsByCandidateId(String candidateId) {
		return candidateEducationDao.getCandidateEducaitonsByCandidateId(candidateId);

	}

}
