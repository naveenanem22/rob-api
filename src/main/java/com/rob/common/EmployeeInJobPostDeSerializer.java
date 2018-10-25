package com.rob.common;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.node.TextNode;
import com.pmt.model.Employee;

public class EmployeeInJobPostDeSerializer extends JsonDeserializer<Employee> {

	@Override
	public Employee deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {

		TreeNode treeNode = jp.getCodec().readTree(jp);
		TextNode employeeId = (TextNode) treeNode.get("employeeId");
		Employee employee = new Employee();
		employee.setId(employeeId.asInt());
		return employee;
	}

}
