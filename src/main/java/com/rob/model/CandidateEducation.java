package com.rob.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CandidateEducation {

	@JsonProperty(value = "qualificationName")	
	private String qualName;

	@JsonProperty(value = "specialization")
	private String specialization;

	@JsonProperty(value = "qualStartDate")
	private LocalDate qualStartDate;

	@JsonProperty(value = "qualEndDate")
	private LocalDate qualEndDate;

	@JsonProperty(value = "score")
	private float score;

	@JsonProperty(value = "scoreType")
	private String scoreType;

	@JsonProperty(value = "institution")
	private String institution;

	public CandidateEducation() {

	}

	public String getQualName() {
		return qualName;
	}

	public void setQualName(String qualName) {
		this.qualName = qualName;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public LocalDate getQualStartDate() {
		return qualStartDate;
	}

	public void setQualStartDate(LocalDate qualStartDate) {
		this.qualStartDate = qualStartDate;
	}

	public LocalDate getQualEndDate() {
		return qualEndDate;
	}

	public void setQualEndDate(LocalDate qualEndDate) {
		this.qualEndDate = qualEndDate;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public String getScoreType() {
		return scoreType;
	}

	public void setScoreType(String scoreType) {
		this.scoreType = scoreType;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

}
