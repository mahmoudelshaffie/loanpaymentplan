package com.lendico.plangenerator.rest;

import static org.junit.Assert.assertEquals;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class MonthlyPlanGeneratorRESTTest {

	private static final String BASE_URL = "http://localhost:8080/generate-plan";

	@Test
	public void testGeneratePlaneWithValidLoanAmountShouldBeGeneratedSuccessfully() throws JSONException {
		RequestSpecification request = RestAssured.given();
		
		int duration = 24;
		double loanAmount = 5000;
		String startDate = "2018-01-01T00:00:01Z";

		JSONObject loanConfig = new JSONObject();
		loanConfig.put("loanAmount", loanAmount);
		loanConfig.put("nominalRate", "5.0");
		loanConfig.put("duration", duration);
		loanConfig.put("startDate", startDate);
		request.header("Content-Type", "application/json");
		request.body(loanConfig.toString());
		
		Response response = request.post(BASE_URL);
		assertEquals(response.getStatusCode(), HttpStatus.OK.value());
		Integer installmentsCount = response.getBody().jsonPath().get("$.size()");
		assertEquals(duration, installmentsCount, 0);		
	}
	
	@Test
	public void testGeneratePlaneWithInValidLoanAmountShouldReturnBadRequest() throws JSONException {
		RequestSpecification request = RestAssured.given();
		
		int duration = 24;
		double loanAmount = 0;
		String startDate = "2018-01-01T00:00:01Z";

		JSONObject loanConfig = new JSONObject();
		loanConfig.put("loanAmount", loanAmount);
		loanConfig.put("nominalRate", "5.0");
		loanConfig.put("duration", duration);
		loanConfig.put("startDate", startDate);
		request.header("Content-Type", "application/json");
		request.body(loanConfig.toString());
		
		Response response = request.post(BASE_URL);
		assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST.value());
	}
	
	@Test
	public void testGeneratePlaneWithInValidDurationAmountShouldReturnBadRequest() throws JSONException {
		RequestSpecification request = RestAssured.given();
		
		int duration = -25;
		double loanAmount = 5000;
		String startDate = "2018-01-01T00:00:01Z";

		JSONObject loanConfig = new JSONObject();
		loanConfig.put("loanAmount", loanAmount);
		loanConfig.put("nominalRate", "5.0");
		loanConfig.put("duration", duration);
		loanConfig.put("startDate", startDate);
		request.header("Content-Type", "application/json");
		request.body(loanConfig.toString());
		
		Response response = request.post(BASE_URL);
		assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST.value());
	}
}
