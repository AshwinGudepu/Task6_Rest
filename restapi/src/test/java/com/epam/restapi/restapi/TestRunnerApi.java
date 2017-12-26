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
	@Parameters({ "domainName", "uri" })
	public void setUri(String domainName, String uri) {
		RestAssured.baseURI = domainName;
		response = RestAssured.given().get("/" + uri).andReturn();
	}

	@Test
	public void verifyStatusCode() {
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test
	public void verifyResponseContentType() {
		String valueOfContentTypeHeader = response.getHeader("content-type");
		Assert.assertTrue(valueOfContentTypeHeader.contains("application/json; charset=utf-8"));
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
