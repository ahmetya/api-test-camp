package com.bootcamp.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PetStoreStep {

    public static final String petStoreURI = "https://petstore.swagger.io/v2";

    @When("I make a get request to user module")
    public void i_make_a_get_request_to_user_module() {
        RestAssured.given().baseUri(petStoreURI).get("/user/invalidUser").then().statusCode(404);
    }

    @When("I make a get request for inventory to store module")
    public void i_make_a_get_request_for_inventory_to_store_module() {
        Response response = RestAssured.given().baseUri(petStoreURI)
                .get("/store/inventory/")
                .then().extract().response();
        System.out.println(response.body().asString());
    }

    @Then("I make a get request for finding pet with ID {int}")
    public void i_make_a_get_request_for_finding_pet_with_id(Integer petID) {
        Response response = RestAssured.given().baseUri(petStoreURI)
                .get("/pet/" + petID + "/")
                .then().statusCode(200).extract().response();
        System.out.println(response.body().asString());
    }

}
