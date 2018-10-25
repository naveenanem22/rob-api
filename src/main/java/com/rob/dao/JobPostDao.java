package com.rob.dao;

import java.util.List;

import com.rob.model.JobPost;

public interface JobPostDao {

	JobPost getJobPostById(int jobPostId);

	boolean createJobPost(JobPost jobPost);
	
	boolean removeJobPostById(int jobPostId);
	
	boolean updateJobPost(JobPost jobPost);

}
