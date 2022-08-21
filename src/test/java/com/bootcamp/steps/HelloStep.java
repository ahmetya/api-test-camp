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

    @Then("I should introduce myself as {string}")
    public void i_should_introduce_myself_as(String name) {
        System.out.println("my name is " + name);
    }

    @Then("My cats name is {string}")
    public void my_cats_name_is(String catsName) {
        System.out.println("Kedimin ismi " + catsName);
    }

    @When("My age is {int}")
    public void my_age_is(Integer age) {
        System.out.println("Your age is " + age);
    }

    @Then("System says you are too old")
    public void system_says_you_are_too_old() {
        System.out.println("You are too old !!!");
    }

    @When("My cats name is {string} and its age is {int}")
    public void my_cats_name_is_and_its_age_is(String name, Integer age) {
        System.out.println("My cats name is " + name + "and its age is " + age);
    }


}
