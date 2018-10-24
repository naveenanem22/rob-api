package com.rob.model;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rob.custom.validators.ScoreTypeConstraint;

public class CandidateEducation {

	@JsonProperty(value = "id")
	private int id;

	@JsonProperty(value = "qualificationName")
	@Size(min = 1, message = "Qualificatoin Name cannot be blank.")
	private String qualName;

	@JsonProperty(value = "specialization")
	@NotBlank(message = "Specialization cannot be blank.")
	private String specialization;

	@JsonProperty(value = "qualStartDate")
	private LocalDate qualStartDate;

	@JsonProperty(value = "qualEndDate")
	private LocalDate qualEndDate;

	@JsonProperty(value = "score")
	private float score;

	@JsonProperty(value = "scoreType")
	@NotBlank(message = "Score-type cannot be blank.")
	@ScoreTypeConstraint(message = "Score-type must be either GPA or Percentage.")
	private String scoreType;

	@JsonProperty(value = "institution")
	@NotBlank(message = "Institution name cannot be blank.")
	private String institution;

	public CandidateEducation() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
