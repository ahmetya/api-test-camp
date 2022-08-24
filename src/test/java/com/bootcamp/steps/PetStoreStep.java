package com.bootcamp.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import com.bootcamp.utils.RequestBody;
import io.restassured.specification.RequestSpecification;
import netscape.javascript.JSObject;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.json.JSONObject;

public class PetStoreStep {

    public static final String petStoreURI = "https://petstore.swagger.io/v2";
    private static RequestBody requestBody = new RequestBody();
    private static JSONObject userRequest = requestBody.userRequestBody();
    private static String changedUserName = "";

    private String userName = "";
    private RequestSpecification request = RestAssured
            .given()
            .baseUri(petStoreURI)
            .contentType("application/json");

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

    @Then("I should see new user is created")
    public void i_should_see_new_user_is_created() {
        String expectedUserName = requestBody.userRequestBody().get("username").toString();
        System.out.println(expectedUserName + "###########");
        RestAssured.given().baseUri(petStoreURI)
                .get("/user/" + expectedUserName).then().body("phone", Matchers.equalTo(expectedUserName));
    }

    @When("I make a new post request to user module")
    public void i_make_a_new_post_request_to_user_module() {
        String message = request.body(userRequest.toString()).post("/user")
                .then().body("code", Matchers.equalTo(200))
                .extract().response().body().path("message");
        System.out.println("User Create Message: " + message);
    }

    @Then("I can receive user details")
    public void i_can_receive_user_details() {
        String responseEmail = request.get("/user/" + userRequest.get("username"))
                .then()
                .body("username", Matchers.equalTo(userRequest.get("username")))
                .extract().response().body().path("email");
        System.out.println(userRequest.get("username"));
        System.out.println(responseEmail);
    }

    @When("I change the user name with {string}")
    public void i_change_the_user_name_with(String userName) {
        changedUserName = userName + requestBody.randomId() ;
        userRequest.put("username", changedUserName);
        userRequest.put("phone", "+905420000000");
        System.out.println(userRequest.toString());
        String responseMessage = request.body(userRequest.toString())
                .put("/user/" + userRequest.get("username"))
                .then()
                .statusCode(Matchers.equalTo(200))
                .extract().response().body().path("message");
        System.out.println(responseMessage + "############");
    }

    @Then("I can receive changed user details")
    public void i_can_receive_changed_user_details() {
        String responsePhone = request.get("/user/" + changedUserName)
                .then()
                .body("username", Matchers.equalTo(changedUserName))
                .extract().response().body().path("phone");
        System.out.println(responsePhone);
    }

    @When("I delete registered user")
    public void i_delete_registered_user() {
        request.delete("/user/" + changedUserName)
                .then()
                .statusCode(Matchers.equalTo(200));
    }

    @Then("I should not receive user details for deleted user")
    public void i_should_not_receive_user_details_for_deleted_user() {
        request.get("/user/" + changedUserName)
                .then()
                .statusCode(Matchers.equalTo(404))
                .body("message", Matchers.equalTo("User not found"));
    }
}
