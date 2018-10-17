package com.rob.dao;

import java.util.List;

import com.rob.model.JobPost;

public interface JobPostDao {

	JobPost getJobPostById(String jobPostId);

	boolean createJobPost(JobPost jobPost);
	
	boolean removeJobPostById(String jobPostId);
	
	boolean updateJobPost(JobPost jobPost);

}
