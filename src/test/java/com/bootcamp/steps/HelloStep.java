package com.bootcamp.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HelloStep {

    @Given("I have logged in with a unrestricted registered user to the page")
    public void i_have_logged_in_with_a_unrestricted_registered_user_to_the_page() {
        System.out.println("CALLED");
    }

    @Then("I should see welcome popup")
    public void i_should_see_welcome_popup() {
        System.out.println("CALLED");
    }

    @When("I click to the account button")
    public void i_click_to_the_account_button() {
        System.out.println("CALLED");
    }

    @Then("I should see the account details")
    public void i_should_see_the_account_details() {
        System.out.println("CALLED");
    }
}
