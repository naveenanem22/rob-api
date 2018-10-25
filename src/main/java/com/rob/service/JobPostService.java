package com.rob.service;

import java.util.List;

import com.rob.model.JobPost;

public interface JobPostService {
	
	JobPost getJobPostsById(int jobPostId);
	int createJobPost(JobPost jobPost);
	boolean removeJobPostById(int jobPostId);
	boolean updateJobPost(JobPost jobPost);

}
