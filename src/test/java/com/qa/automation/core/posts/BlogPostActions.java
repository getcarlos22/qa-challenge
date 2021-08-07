package com.qa.automation.core.posts;

import com.qa.automation.core.tasks.RequestSpec;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class BlogPostActions {

    @Step("Get blog posts for user with userid {0}")
    public Response getUserPost(String userId) {
        return SerenityRest.given().spec(RequestSpec.blogReqSpec())
                .basePath("posts")
                .queryParams("userId", userId)
                .get().then().extract().response();
    }
}
