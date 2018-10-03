package com.rob.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rob.dao.CandidateDao;
import com.rob.model.Candidate;

@Service(value = "candidateServiceImpl")
public class CandidateServiceImpl implements CandidateService {
	
	@Autowired
	@Qualifier(value = "candidateDaoImpl")
	private CandidateDao candidateDao;

	@Override
	@Transactional(readOnly = true)
	public Candidate getCandidateById(String candidateId) {				
		return candidateDao.getCandidateById(candidateId);
	}

	@Override
	public boolean createCandidate(Candidate candidate) {
		return candidateDao.createCandidate(candidate);		
	}
	
	@Override
	public boolean updateCandidate(Candidate candidate) {
		return candidateDao.updateCandidate(candidate);
	}

}
