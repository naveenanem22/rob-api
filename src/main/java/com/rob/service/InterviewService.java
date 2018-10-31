package com.rob.service;

import com.rob.model.Interview;

public interface InterviewService {
	
	Interview getInterviewById(int interviewId);
	boolean createInterview(Interview interview);
	boolean updateInterviewById(Interview interview);
	boolean removeInterviewById(int interviewId);

}
