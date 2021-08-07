package com.qa.automation.core.comments;


import com.qa.automation.core.tasks.RequestSpec;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;



public class Actions {

    @Step("Get comments on post with postId {0}")
    public Response getPostComments(String postId) {
        return SerenityRest.given().spec(RequestSpec.blogReqSpec())
                .basePath("comments")
                .queryParams("postId", postId)
                .get().then().extract().response();
    }

}
