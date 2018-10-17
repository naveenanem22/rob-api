package com.rob.service;

import javax.ws.rs.InternalServerErrorException;

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
	public JobPost getJobPostsById(String jobPostId) {
		return jobPostDao.getJobPostById(jobPostId);
	}

	@Override
	@Transactional
	public String createJobPost(JobPost jobPost) {
		String jobPostId = "";

		try {
			if (jobPostDao.createJobPost(jobPost))
				jobPostId = jobPostDao.getJobPostById(jobPost.getId()).getId();

		} catch (Exception e) {
			e.printStackTrace();
			throw new InternalServerErrorException("Unexpected error occurred while creating the JobPost details.");

		}

		if (!jobPostId.isEmpty())
			return jobPostId;
		else
			throw new InternalServerErrorException("Unexpected error occurred while creating the JobPost details.");

	}

	@Override
	public boolean removeJobPostById(String jobPostId) {

		return jobPostDao.removeJobPostById(jobPostId);
	}

	@Override
	public boolean updateJobPost(JobPost jobPost) {
		return jobPostDao.updateJobPost(jobPost);

	}

}
