package com.qa.automation.core.tasks;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.guice.Injectors;
import net.thucydides.core.util.EnvironmentVariables;

public class RequestSpec {
    /**
     * Get Request Specification for blog endpoint
     *
     * @return RequestSpecification
     */
    public static RequestSpecification blogReqSpec() {
        EnvironmentVariables environmentVariables = Injectors.getInjector()
                .getInstance(EnvironmentVariables.class);

        String baseUrl = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("webdriver.base.url");

        return new RequestSpecBuilder().setBaseUri(baseUrl)
                .setContentType("application/json")
                .build();
    }
}
