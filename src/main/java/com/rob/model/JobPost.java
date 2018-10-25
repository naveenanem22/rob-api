package com.rob.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.pmt.model.Employee;
import com.rob.common.EmployeeInJobPostSerializer;
import com.rob.common.EmployeeInJobPostDeSerializer;

public class JobPost {

	@JsonProperty(value = "id")
	private int id;

	@JsonProperty(value = "jobPosition")
	private String jobTitle;

	@JsonProperty(value = "jobLocation")
	private String jobLocation;

	@JsonProperty(value = "roles")
	private String roles;

	@JsonProperty(value = "numberOfVacancies")
	private int numberOfVacancies;

	@JsonProperty(value = "recruiter")
	@JsonSerialize(using = EmployeeInJobPostSerializer.class)
	@JsonDeserialize(using = EmployeeInJobPostDeSerializer.class)
	private Employee hiringManager;

	@JsonProperty(value = "department")
	private String department;

	@JsonProperty(value = "overview")
	private String jobOverview;

	@JsonProperty(value = "responsibilities")
	private String responsibilities;

	@JsonProperty(value = "mustHaveExperience")
	private String mustHaveExperience;

	@JsonProperty(value = "niceToHaveExperience")
	private String niceToHaveExperience;

	@JsonProperty(value = "keySkills")
	private String keySkills;

	@JsonProperty(value = "desiredEducation")
	private String desiredEducation;

	public JobPost() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getJobLocation() {
		return jobLocation;
	}

	public void setJobLocation(String jobLocation) {
		this.jobLocation = jobLocation;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public int getNumberOfVacancies() {
		return numberOfVacancies;
	}

	public void setNumberOfVacancies(int numberOfVacancies) {
		this.numberOfVacancies = numberOfVacancies;
	}

	public Employee getHiringManager() {
		return hiringManager;
	}

	public void setHiringManager(Employee hiringManager) {
		this.hiringManager = hiringManager;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getJobOverview() {
		return jobOverview;
	}

	public void setJobOverview(String jobOverview) {
		this.jobOverview = jobOverview;
	}

	public String getResponsibilities() {
		return responsibilities;
	}

	public void setResponsibilities(String responsibilities) {
		this.responsibilities = responsibilities;
	}

	public String getMustHaveExperience() {
		return mustHaveExperience;
	}

	public void setMustHaveExperience(String mustHaveExperience) {
		this.mustHaveExperience = mustHaveExperience;
	}

	public String getNiceToHaveExperience() {
		return niceToHaveExperience;
	}

	public void setNiceToHaveExperience(String niceToHaveExperience) {
		this.niceToHaveExperience = niceToHaveExperience;
	}

	public String getKeySkills() {
		return keySkills;
	}

	public void setKeySkills(String keySkills) {
		this.keySkills = keySkills;
	}

	public String getDesiredEducation() {
		return desiredEducation;
	}

	public void setDesiredEducation(String desiredEducation) {
		this.desiredEducation = desiredEducation;
	}

}
