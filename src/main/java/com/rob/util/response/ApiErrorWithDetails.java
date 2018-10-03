package com.rob.util.response;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.rob.common.JsonDateSerializer;

public class ApiErrorWithDetails {

	@JsonProperty(value = "timestamp")
	@JsonSerialize(using = JsonDateSerializer.class)
	private LocalDateTime timestamp;

	@JsonProperty(value = "erroMessage")
	private String message;

	@JsonProperty(value = "errorDetails")
	private List<Detail> details;

	public class Detail {

		@JsonProperty(value = "rejectedValue")
		private String rejectedValue;

		@JsonProperty(value = "rejectedReason")
		private String rejectedReason;
		
		@JsonProperty(value = "fieldName")
		private String fieldName;

		public Detail(String rejectedValue, String rejectedReason, String fieldName) {
			this.rejectedReason = rejectedReason;
			this.rejectedValue = rejectedValue;
			this.fieldName = fieldName;
		}

		public String getRejectedValue() {
			return rejectedValue;
		}

		public void setRejectedValue(String rejectedValue) {
			this.rejectedValue = rejectedValue;
		}

		public String getRejectedReason() {
			return rejectedReason;
		}

		public void setRejectedReason(String rejectedReason) {
			this.rejectedReason = rejectedReason;
		}

		public String getFieldName() {
			return fieldName;
		}

		public void setFieldName(String fieldName) {
			this.fieldName = fieldName;
		}
		

	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Detail> getDetails() {
		return details;
	}

	public void setDetails(List<Detail> details) {
		this.details = details;
	}

}
