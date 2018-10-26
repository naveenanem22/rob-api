package com.rob.common;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.rob.model.JobPost;

public class JobPostInJobCandidateSerializer extends JsonSerializer<JobPost> {

	@Override
	public void serialize(JobPost jobPost, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		gen.writeStartObject();
		gen.writeNumberField("id", jobPost.getId());
		gen.writeEndObject();

	}

}
