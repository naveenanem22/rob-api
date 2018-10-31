package com.rob.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Interview {

	@JsonProperty(value = "id")
	private int id;

	@JsonProperty(value = "jobCandidate")
	private JobCandidate jobCandidate;

	@JsonProperty(value = "interviewStartTime")
	private LocalDateTime startTime;

	@JsonProperty(value = "interviewEndTime")
	private LocalDateTime endTime;

	@JsonProperty(value = "levelOfInterview")
	private String levelOfInterview;

	@JsonProperty(value = "typeOfInterview")
	private String typeOfInterview;

	@JsonProperty(value = "result")
	private String status;

	@JsonProperty(value = "notes")
	private String notes;

	public Interview() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public JobCandidate getJobCandidate() {
		return jobCandidate;
	}

	public void setJobCandidate(JobCandidate jobCandidate) {
		this.jobCandidate = jobCandidate;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public String getLevelOfInterview() {
		return levelOfInterview;
	}

	public void setLevelOfInterview(String levelOfInterview) {
		this.levelOfInterview = levelOfInterview;
	}

	public String getTypeOfInterview() {
		return typeOfInterview;
	}

	public void setTypeOfInterview(String typeOfInterview) {
		this.typeOfInterview = typeOfInterview;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}
