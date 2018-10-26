package com.rob.common;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.node.TextNode;
import com.rob.model.Candidate;
import com.rob.model.JobPost;

public class JobPostInJobCandidateDeSerializer extends JsonDeserializer<JobPost>{

	@Override
	public JobPost deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		
		TreeNode treeNode = jp.getCodec().readTree(jp);
		TextNode jobPostId = (TextNode) treeNode.get("jobPostId");
		JobPost jobPost = new JobPost();
		jobPost.setId(jobPostId.asInt());
		return jobPost;
	}

}
