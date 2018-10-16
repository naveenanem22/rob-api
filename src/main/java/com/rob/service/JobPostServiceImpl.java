package com.rob.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rob.dao.JobPostDao;
import com.rob.model.JobPost;

@Service(value = "jobPostServiceImpl")
public class JobPostServiceImpl implements JobPostService {

	@Autowired
	@Qualifier(value = "jobPostDaoImpl")
	private JobPostDao jobPostDao;

	@Override
	@Transactional(readOnly = true)
	public List<JobPost> getJobPostsById(String jobPostId) {
		return jobPostDao.getJobPostsById(jobPostId);
	}

}
