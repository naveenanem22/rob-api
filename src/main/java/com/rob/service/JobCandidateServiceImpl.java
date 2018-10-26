package com.rob.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rob.dao.JobCandidateDao;
import com.rob.model.JobCandidate;
import com.rob.model.JobPost;

@Service(value = "jobCandidateServiceImpl")
public class JobCandidateServiceImpl implements JobCandidateService {

	@Autowired
	@Qualifier(value = "jobCandidateDaoImpl")
	private JobCandidateDao jobCandidateDao;

	@Override
	@Transactional
	public boolean createJobCandidateRecords(List<JobCandidate> jobCandidates) {
		jobCandidates.forEach(jobCandidate -> {
			Random random = new Random();
			jobCandidate.setId(random.nextInt((9999-1000)+1)+1000);
		});
		return jobCandidateDao.createJobCandidateRecords(jobCandidates);
	}

	@Override
	@Transactional
	public boolean updateJobCandidateRecords(List<JobCandidate> jobCandidates) {
		return jobCandidateDao.updateJobCandidateRecords(jobCandidates);
	}

	@Override
	@Transactional
	public boolean removeJobCandidateRecords(List<Integer> jobCandidateIds) {
		return jobCandidateDao.removeJobCandidateRecords(jobCandidateIds);
	}

	@Override
	@Transactional(readOnly = true)
	public List<JobCandidate> listJobCandidateRecordsByJobPostId(int jobPostId) {
		return jobCandidateDao.listJobCandidateRecordsByJobPostId(jobPostId);
	}

}
