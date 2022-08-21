package com.bootcamp.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import com.bootcamp.utils.RequestBody;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

public class PetStoreStep {

    public static final String petStoreURI = "https://petstore.swagger.io/v2";
    private static RequestBody requestBody = new RequestBody();
    private String responseUserName;

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

    @When("I make a new post request to user module")
    public void i_make_a_new_post_request_to_user_module() {
        RestAssured.given().baseUri(petStoreURI)
                .contentType("application/json")
                .body(requestBody.userRequestBody().toString()).post("/user")
                .then().statusCode(200);
    }

    @Then("I should see new user is created")
    public void i_should_see_new_user_is_created() {
        String expectedUserName = requestBody.userRequestBody().get("username").toString();
        System.out.println(expectedUserName + "###########");
        RestAssured.given().baseUri(petStoreURI)
                .get("/user/" + expectedUserName).then().body("phone", Matchers.equalTo(expectedUserName));
    }
}
