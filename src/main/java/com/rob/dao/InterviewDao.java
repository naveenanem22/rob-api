package com.rob.dao;

import com.rob.model.Interview;

public interface InterviewDao {
	
	Interview getInterviewById(int interviewId);
	boolean createInterview(Interview interview);
	boolean updateInterviewById(Interview interview);
	boolean removeInterviewById(int interviewId);
}
