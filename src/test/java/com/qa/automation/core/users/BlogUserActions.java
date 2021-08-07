package com.qa.automation.core.users;

import com.qa.automation.core.tasks.RequestSpec;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class BlogUserActions {

    @Step("Get details for user {0}")
    public Response getUserDetails(String user) {
        return SerenityRest.given().spec(RequestSpec.blogReqSpec())
                .basePath("users")
                .queryParam("username", user)
                .get().then().extract().response();
    }
}
