package com.java.student.controller;

import com.java.student.restAssured.StudentControllerTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.test.web.servlet.ResultActions;

@SpringBootTest
@AutoConfigureMockMvc
@CucumberContextConfiguration
public class Steps extends  StudentControllerTest {

    String base_URL = "http://localhost:8080/api/v1/students";
    private static Response response;

    @Autowired
    private MockMvc mvc;
    ResultActions action;

    String payload;

    @Given("student fills up registration form")
    public void student_registration_website() throws Throwable{
        payload = "{\n" +
                "    \"id\": 2,\n" +
                "    \"firstName\": \"Test4646\",\n" +
                "    \"lastName\": \"Sa1263463\",\n" +
                "    \"className\": \"3 B\",\n" +
                "    \"nationality\":\"India\"\n" +
                "}";
    }

    @When("student submits registration form")
       public void student_details_are_provided_with() throws Throwable{
        action = mvc.perform(post(base_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload)
        );
    }

    @Then("new student record is created successfully")
    public void new_student_record_is_created_successfully() throws Throwable {
        action.andExpect(status().isCreated());
        action.andReturn().getResponse().getContentAsString().contains("3 B");
    }

    @When("^update class-name$")
    public void update_class_name_to() throws Throwable {
        action = mvc.perform(put(base_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"id\": 2,\n" +
                        "    \"className\": \"3 D\"\n" +
                        "}")
        );
        action.andExpect(status().isOk());
    }

    @Then("student class-name is updated successfully")
    public void student_class_name_is_updated_successfully() throws Throwable {
        action.andExpect(status().isOk());
        action.andReturn().getResponse().getContentAsString().contains("3 D");
    }

    @When("delete student by id")
    public void delete_student_by_id() throws Throwable {
        action = mvc.perform(delete(base_URL + "/2"));
    }

    @Then("student record is deleted successfully")
    public void student_record_is_deleted_successfully() throws Throwable{
        action.andExpect(status().isOk());
    }

    @When("student details are retrieved")
    public void student_details_are_retrieved() throws Throwable {
       action = mvc.perform(get(base_URL ));
       action.andExpect(status().isOk());
    }

    @Then ("No records are found")
    public void no_records_are_found() throws Throwable{
        action.andReturn().getResponse().getContentAsString().isEmpty();
    }
}
