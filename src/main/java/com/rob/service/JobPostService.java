package com.rob.service;

import java.util.List;

import com.rob.model.JobPost;

public interface JobPostService {
	
	List<JobPost> getJobPostsById(String jobPostId);

}
