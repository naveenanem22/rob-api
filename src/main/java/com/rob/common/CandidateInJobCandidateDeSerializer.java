package com.rob.common;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.node.TextNode;
import com.pmt.model.Employee;
import com.rob.model.Candidate;

public class CandidateInJobCandidateDeSerializer extends JsonDeserializer<Candidate> {

	@Override
	public Candidate deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		TreeNode treeNode = jp.getCodec().readTree(jp);
		TextNode candidateId = (TextNode) treeNode.get("candidateId");
		Candidate candidate = new Candidate();
		candidate.setId(candidateId.asInt());
		return candidate;
	}

}
