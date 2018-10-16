package com.rob.dao;

import java.util.List;

import com.rob.model.JobPost;

public interface JobPostDao {
	
	List<JobPost> getJobPostsById(String jobPostId);

}
