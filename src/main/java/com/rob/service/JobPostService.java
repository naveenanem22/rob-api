package com.rob.service;

import java.util.List;

import com.rob.model.JobPost;

public interface JobPostService {
	
	JobPost getJobPostsById(String jobPostId);
	String createJobPost(JobPost jobPost);
	boolean removeJobPostById(String jobPostId);
	boolean updateJobPost(JobPost jobPost);

}
