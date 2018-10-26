package com.rob.dao;

import java.util.List;

import com.rob.model.JobCandidate;

public interface JobCandidateDao {

	boolean createJobCandidateRecords(List<JobCandidate> jobCandidates);

	boolean updateJobCandidateRecords(List<JobCandidate> jobCandidates);

	boolean removeJobCandidateRecords(List<Integer> jobCandidateIds);

	List<JobCandidate> listJobCandidateRecordsByJobPostId(int jobPostId);

}
