package com.rob.service;

import java.util.Random;

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
	public Candidate getCandidateById(int candidateId) {				
		return candidateDao.getCandidateById(candidateId);
	}

	@Override
	@Transactional
	public boolean createCandidate(Candidate candidate) {
		Random random = new Random();		
		candidate.setId(random.nextInt((9999-1000)+1)+1000);
		return candidateDao.createCandidate(candidate);		
	}
	
	@Override
	@Transactional
	public boolean updateCandidate(Candidate candidate) {
		return candidateDao.updateCandidate(candidate);
	}
	
	@Override
	@Transactional
	public boolean deleteCandidateById(int candidateId) {
		return candidateDao.deleteCandidateById(candidateId);
	}

}
