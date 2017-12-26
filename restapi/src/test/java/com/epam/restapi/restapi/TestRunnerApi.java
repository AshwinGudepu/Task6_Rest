package com.epam.restapi.restapi;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestRunnerApi {

	Response response = null;

	@BeforeClass
	@Parameters({ "domainName", "endpoint" })
	public void setUri(String domainName, String endpoint) {
		RestAssured.baseURI = domainName;
		response = RestAssured.given().get("/" + endpoint).andReturn();
	}

	@Test
	@Parameters({ "statusCode" })
	public void verifyStatusCode(int statusCode) {
		Assert.assertEquals(response.getStatusCode(), statusCode);
	}

	@Test
	@Parameters({ "headerKey", "headerValue" })
	public void verifyResponseContentType(String headerKey, String headerValue) {
		String valueOfContentTypeHeader = response.getHeader(headerKey);
		Assert.assertTrue(valueOfContentTypeHeader.contains(headerValue));
	}

	@Test
	public void verifyContentTypeHeader() {
		List<Header> getheadersList = response.getHeaders().asList();
		for (Header headersList : getheadersList) {
			if ("Content-Type".equals(headersList.getName())) {
				assertTrue(true);
				break;
			}
		}
	}

	@Test
	public void verifyCountOfEmployees() {
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
