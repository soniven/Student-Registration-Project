package com.java.student.restAssured;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@SpringBootTest
@RunWith(SpringRunner.class)
public class StudentControllerTest {
    String base_URL = "http://localhost:8080/api/v1/students";

    @BeforeTest
    public void setUp()
    {
        RestAssured.baseURI=base_URL;
    }

    @Test
    public void testGetAllStudents() {
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET);
        String responseBody = response.getBody().asString();
        System.out.println(responseBody);
        int statusCode = response.getStatusCode();
        Assert.assertEquals(String.valueOf(statusCode),"200");
    }

    @Test
    public void testGetStudentById() {
        int Student_id = 223445;
        String getStudentByIdRequest = base_URL + "/" + Student_id;
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET);
        String responseBody = response.getBody().asString();
        System.out.println(responseBody);
        int statusCode = response.getStatusCode();
        Assert.assertEquals(String.valueOf(statusCode),"200");
    }

    @Test
    public void testSaveCustomer() {

    }

    @Test
    public void testUpdateStudent() {

    }

    @Test
    public void testDeleteStudentById() {

    }
}