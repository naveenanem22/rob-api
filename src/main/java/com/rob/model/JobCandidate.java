package com.rob.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.rob.common.CandidateInJobCandidateDeSerializer;
import com.rob.common.CandidateInJobCandidateSerializer;
import com.rob.common.JobPostInJobCandidateDeSerializer;
import com.rob.common.JobPostInJobCandidateSerializer;

public class JobCandidate {

	@JsonProperty(value = "id")
	private int id;

	@JsonProperty(value = "candidate")
	@JsonDeserialize(using = CandidateInJobCandidateDeSerializer.class)
	@JsonSerialize(using = CandidateInJobCandidateSerializer.class)
	private Candidate candidate;

	@JsonProperty(value = "job")
	@JsonDeserialize(using = JobPostInJobCandidateDeSerializer.class)
	@JsonSerialize(using = JobPostInJobCandidateSerializer.class)
	private JobPost jobPost;

	@JsonProperty(value = "stage")
	private String stage;

	@JsonProperty(value = "notes")
	private String notes;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public JobPost getJobPost() {
		return jobPost;
	}

	public void setJobPost(JobPost jobPost) {
		this.jobPost = jobPost;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}
