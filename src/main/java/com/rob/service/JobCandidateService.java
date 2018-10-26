package com.rob.service;

import java.util.List;

import com.rob.model.JobCandidate;

public interface JobCandidateService {

	boolean createJobCandidateRecords(List<JobCandidate> jobCandidates);

	boolean updateJobCandidateRecords(List<JobCandidate> jobCandidates);

	boolean removeJobCandidateRecords(List<Integer> jobCandidateIds);

	List<JobCandidate> listJobCandidateRecordsByJobPostId(int jobPostId);

}
