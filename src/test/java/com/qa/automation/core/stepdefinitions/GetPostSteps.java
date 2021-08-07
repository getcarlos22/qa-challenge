package com.qa.automation.core.stepdefinitions;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

import com.qa.automation.core.tasks.tasksQuestions;
import com.qa.automation.core.posts.BlogPostActions;
import com.qa.automation.core.posts.BlogPostQuestions;
import com.qa.automation.core.users.BlogUserActions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.List;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class GetPostSteps {

    @Steps
    BlogUserActions blogUserActions;

    @Steps
    BlogPostQuestions blogPostQuestions;

    @Steps
    BlogPostActions blogPostActions;

    @Steps
    tasksQuestions tasksQuestions;

    @Given("\"(.*)\" has few post to (?:.*) name in the blog")
    public void user_has_few_posts_in_the_blog(String user) {
        blogUserActions.getUserDetails(user);
        tasksQuestions.responseCodeIs(200, lastResponse());

        int userId = lastResponse().getBody().jsonPath().getInt("[0].id");
        Serenity.setSessionVariable("userId").to(String.valueOf(userId));
    }

    @When("I call the endpoint to get posts by the user")
    public void i_call_the_endpoint_to_get_posts_by_the_user() {
        blogPostActions.getUserPost(Serenity.sessionVariableCalled("userId"));
    }

    @Then("all posts by the user should be returned")
    public void all_posts_by_the_user_should_be_returned() {
        tasksQuestions.responseCodeIs(200, lastResponse());

        List<Object> posts = lastResponse().jsonPath().getList("");
        blogPostQuestions.verifyUserIdInPosts(posts);
    }

    @When("I call the endpoint to get posts by the user with invalid user id")
    public void i_call_the_endpoint_to_get_posts_by_invalid_userId() {
        blogPostActions.getUserPost("999999");
    }

}
