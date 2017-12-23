package com.epam.restapi.restapi;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestRunnerApi {

	Response response = null;

	@BeforeClass
	@Parameters({"domainName","uri"})
	public void setUri(String domainName,String uri) {
		RestAssured.baseURI = domainName;
		response = RestAssured.given().get("/" +uri).andReturn();
	}

	@Test
	public void checkStatusCode() {
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test
	public void checkResponseContentType() {
		String valueOfContentTypeHeader = response.getHeader("content-type");		
		Assert.assertTrue(valueOfContentTypeHeader.contains("application/json; charset=utf-8"));   
	}

	@Test
	public void checkCountOfEmployees() {
		EmployeeInformation[] empinformation = response.as(EmployeeInformation[].class);
		Assert.assertEquals(empinformation.length, 10);
	}

	@Test
	public void printObjects() {
		EmployeeInformation[] employeesinformation = response.as(EmployeeInformation[].class);
		for (EmployeeInformation empinformation : employeesinformation) {
			System.out.println(empinformation);
		}
	}
}
