package com.rob.service;

import java.util.Random;

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
	public JobPost getJobPostsById(int jobPostId) {
		return jobPostDao.getJobPostById(jobPostId);
	}

	@Override
	@Transactional
	public int createJobPost(JobPost jobPost) {
		int jobPostId = 0;
		
		Random random = new Random();
		jobPost.setId(random.nextInt((9999 - 1000) + 1) + 1000);
		

		try {
			if (jobPostDao.createJobPost(jobPost))
				jobPostId = jobPostDao.getJobPostById(jobPost.getId()).getId();

		} catch (Exception e) {
			e.printStackTrace();
			throw new InternalServerErrorException("Unexpected error occurred while creating the JobPost details.");

		}

		if (jobPostId != 0)
			return jobPostId;
		else
			throw new InternalServerErrorException("Unexpected error occurred while creating the JobPost details.");

	}

	@Override
	public boolean removeJobPostById(int jobPostId) {

		return jobPostDao.removeJobPostById(jobPostId);
	}

	@Override
	public boolean updateJobPost(JobPost jobPost) {
		return jobPostDao.updateJobPost(jobPost);

	}

}
