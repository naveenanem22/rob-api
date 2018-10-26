package com.rob.common;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.rob.model.Candidate;

public class CandidateInJobCandidateSerializer extends JsonSerializer<Candidate> {

	@Override
	public void serialize(Candidate candidate, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		gen.writeStartObject();
		gen.writeNumberField("id", candidate.getId());
		gen.writeEndObject();

	}

}
