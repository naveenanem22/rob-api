package com.rob.unittests;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.rob.application.Application;
import com.rob.controller.CandidateController;
import com.rob.model.Candidate;
import com.rob.service.CandidateService;
import com.rob.service.CandidateServiceImpl;

@RunWith(SpringRunner.class)
@WebMvcTest(value = CandidateController.class, secure = false)
@ContextConfiguration(classes = { Application.class, CandidateService.class, CandidateServiceImpl.class })
public class CandidateControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CandidateServiceImpl candidateServiceImpl;

	@Test
	public void getCandidate() throws Exception {

		CandidateService candidateService = candidateServiceImpl;

		Candidate candidate = new Candidate();
		candidate.setFirstName("Naveen Kumar");
		candidate.setLastName("Anem");
		candidate.setEmail("naveen.anem@kony.com");
		candidate.setGender("Male");
		candidate.setId("KH2475");
		candidate.setLastDesignation("Technical Lead");
		candidate.setPassportNumber("J2940263");
		candidate.setMaritalStatus("Married");
		candidate.setDateOfBirth(LocalDate.of(1985, Month.AUGUST, 21));		
		
		
		Mockito.when(candidateService.getCandidate(Mockito.anyString())).thenReturn(candidate);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/candidates/KH2475")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String actualResult = result.getResponse().getContentAsString();
		String expectedResult = "{\"id\":\"KH2475\",\"firstName\":\"Naveen Kumar\",\"lastName\":\"Anem\",\"passportNumber\":\"J2940263\",\"email\":\"naveen.anem@kony.com\",\"lastDesignation\":\"Technical Lead\",\"gender\":\"Male\",\"maritalStatus\":\"Married\",\"dob\":\"1985-08-21\"}";
		JSONAssert.assertEquals(expectedResult, actualResult, false);

	}

}
