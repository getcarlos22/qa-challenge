package com.qa.automation.core.stepdefinitions;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

import com.qa.automation.core.tasks.tasksQuestions;
import com.qa.automation.core.users.BlogUserQuestions;
import com.qa.automation.core.users.BlogUserActions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;


public class GetUsersSteps {

    @Steps
    BlogUserActions blogUserActions;

    @Steps
    tasksQuestions tasksQuestions;

    @Steps
    BlogUserQuestions blogUserQuestions;

    @When("I call the get user details endpoint for user \"(.*)\"")
    public void i_call_the_get_user_endpoint_for_user(String user) {
        blogUserActions.getUserDetails(user);
    }

    @When("I call the get user details endpoint for non-existent user")
    public void i_call_the_get_user_endpoint_for_non_existent_user() {
        blogUserActions.getUserDetails("getcarlos22");
    }

    @Then("user details should be retrieved")
    public void user_details_should_be_retrieved() {
        tasksQuestions.responseCodeIs(200, lastResponse());
    }

    @And("username should be \"(.*)\"")
    public void usernameShouldBe(String userName) {
        blogUserQuestions.validateUserName(userName, lastResponse());
    }

    @Then("empty response should be returned")
    public void empty_response_should_be_returned() {
        tasksQuestions.responseCodeIs(200, lastResponse());
        tasksQuestions.responseShouldBeEmptyList(lastResponse());
    }

    @And("the schema should match with the specification defined in \"(.*)\"")
    public void the_schema_should_match_with_the_specification(String spec) {
        tasksQuestions.verifyResponseSchema(lastResponse(), spec);

    }
}
