package com.rob.service;

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
	public boolean updateCandidateEducations(String candidateId, List<CandidateEducation> candidateEducations) {

		return candidateEducationDao.updateCandidateEducations(candidateId, candidateEducations);
	}

}
