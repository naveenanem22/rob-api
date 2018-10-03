package com.rob.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.rob.common.JsonDateDeserializer;
import com.rob.common.JsonDateSerializer;
import com.rob.custom.validators.GenderConstraint;

public class Candidate {

	@JsonProperty(value = "id")
	private String id;

	@JsonProperty(value = "firstName")
	@Size(min = 2, message = "First Name should not be empty.")
	private String firstName;

	@JsonProperty(value = "lastName")
	@Size(min = 1, message = "Last Name should not be empty.")
	private String lastName;

	@JsonProperty(value = "passportNumber")
	@NotNull(message = "Passport number is mandatory.")
	@Size(min = 1, message = "Passport number should not be empty.")
	private String passportNumber;

	@JsonProperty(value = "email")
	private String email;

	@JsonProperty(value = "lastDesignation")
	private String lastDesignation;

	@JsonProperty(value = "dob")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@NotNull(message = "Date of birth is mandatory.")
	private LocalDate dateOfBirth;

	@JsonProperty(value = "gender")
	@NotNull(message = "Gender is mandatory.")
	@Size(min = 1, message = "Gender cannot be blank.")
	@GenderConstraint(message = "Gender must be either Male Or Female")
	private String gender;

	@JsonProperty(value = "maritalStatus")
	@NotNull(message = "Marital status is mandatory.")
	@Size(min = 1, message = "Marital status cannot be blank.")
	private String maritalStatus;

	@JsonProperty(value = "createdDate")
	@JsonDeserialize(using = JsonDateDeserializer.class)
	@JsonSerialize(using = JsonDateSerializer.class)
	private LocalDateTime createdDate;

	@JsonProperty(value = "updatedDate")
	@JsonDeserialize(using = JsonDateDeserializer.class)
	@JsonSerialize(using = JsonDateSerializer.class)
	private LocalDateTime updatedDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLastDesignation() {
		return lastDesignation;
	}

	public void setLastDesignation(String lastDesignation) {
		this.lastDesignation = lastDesignation;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public LocalDateTime getCreatedDate() {
		return LocalDateTime.now();
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getUpdatedDate() {
		return LocalDateTime.now();
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Override
	public String toString() {
		return id + ", " + firstName + ", " + lastName;
	}

}
