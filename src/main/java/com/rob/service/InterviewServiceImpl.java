package com.rob.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rob.dao.InterviewDao;
import com.rob.model.Interview;

@Service(value = "interviewServiceImpl")
public class InterviewServiceImpl implements InterviewService {
	
	@Autowired
	@Qualifier(value = "interviewDaoImpl")
	private InterviewDao interviewDao;

	@Override
	@Transactional(readOnly = true)
	public Interview getInterviewById(int interviewId) {
		return interviewDao.getInterviewById(interviewId);
	}

	@Override
	@Transactional
	public boolean createInterview(Interview interview) {
		return interviewDao.createInterview(interview);
	}

	@Override
	@Transactional
	public boolean updateInterviewById(Interview interview) {
		return interviewDao.updateInterviewById(interview);
	}

	@Override
	@Transactional
	public boolean removeInterviewById(int interviewId) {
		return interviewDao.removeInterviewById(interviewId);
	}

}
