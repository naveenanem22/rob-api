package com.rob.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CandidatePrevEmployment {

	@JsonProperty(value = "id")
	private int id;

	@JsonProperty(value = "companyName")
	@NotBlank(message = "Company name cannot be blank.")
	private String companyName;

	@JsonProperty(value = "totalExperienceInMonths")
	private int totalExperienceInMonths;

	@JsonProperty(value = "relevantExperienceInMonths")
	private int relevantExperienceInMonths;

	@JsonProperty(value = "startDate")
	private LocalDate startDate;

	@JsonProperty(value = "endDate")
	private LocalDate endDate;

	@JsonProperty(value = "designation")
	@NotBlank(message = "Designation cannot be blank.")
	private String designation;

	@JsonProperty(value = "remuneration")
	private BigDecimal remuneration;

	@JsonProperty(value = "natureOfEmployment")
	@NotBlank(message = "Nature of Employment cannot be blank.")
	private String natureOfEmployment;

	@JsonProperty(value = "supervisorName")
	@NotBlank(message = "Supervisor name cannot be blank.")
	private String supervisorName;

	@JsonProperty(value = "supervisorDesignation")
	@NotBlank(message = "Supervisor designation cannot be blank.")
	private String supervisorDesignation;

	@JsonProperty(value = "reasonForLeaving")
	@NotBlank(message = "Reason for leaving cannot be blank.")
	private String reasonForLeaving;

	@JsonProperty(value = "supervisorEmailId")
	@Email
	@NotBlank(message = "Supervisor email cannot be blank.")
	private String supervisorEmailId;

	@JsonProperty(value = "employeeCode")
	@NotBlank(message = "Employee-Code cannot be blank.")
	private String employeeCode;

	public CandidatePrevEmployment() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getRemuneration() {
		return remuneration;
	}

	public void setRemuneration(BigDecimal remuneration) {
		this.remuneration = remuneration;
	}

	public String getNatureOfEmployment() {
		return natureOfEmployment;
	}

	public void setNatureOfEmployment(String natureOfEmployment) {
		this.natureOfEmployment = natureOfEmployment;
	}

	public String getSupervisorName() {
		return supervisorName;
	}

	public void setSupervisorName(String supervisorName) {
		this.supervisorName = supervisorName;
	}

	public String getSupervisorDesignation() {
		return supervisorDesignation;
	}

	public void setSupervisorDesignation(String supervisorDesignation) {
		this.supervisorDesignation = supervisorDesignation;
	}

	public String getReasonForLeaving() {
		return reasonForLeaving;
	}

	public void setReasonForLeaving(String reasonForLeaving) {
		this.reasonForLeaving = reasonForLeaving;
	}

	public String getSupervisorEmailId() {
		return supervisorEmailId;
	}

	public void setSupervisorEmailId(String supervisorEmailId) {
		this.supervisorEmailId = supervisorEmailId;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getTotalExperienceInMonths() {
		return totalExperienceInMonths;
	}

	public void setTotalExperienceInMonths(int totalExperienceInMonths) {
		this.totalExperienceInMonths = totalExperienceInMonths;
	}

	public int getRelevantExperienceInMonths() {
		return relevantExperienceInMonths;
	}

	public void setRelevantExperienceInMonths(int relevantExperienceInMonths) {
		this.relevantExperienceInMonths = relevantExperienceInMonths;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

}
