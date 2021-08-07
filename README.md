# qa-challenge-mobiquity
[![CircleCI](https://circleci.com/gh/getcarlos22/qa-challenge-mobiquity.svg?style=svg)](https://circleci.com/gh/getcarlos22/qa-challenge-mobiquity)

## About 
Serenity BDD is a library that makes it easier to write high quality automated acceptance tests, with powerful reporting and living documentation features. It has strong support for both web testing with Selenium, and API testing using RestAssured.

Serenity strongly encourages good test automation design, and supports several design patterns, including classic Page Objects, the newer Lean Page Objects/ Action Classes approach, and the more sophisticated and flexible Screenplay pattern.

Sample Rest API test solution for https://jsonplaceholder.typicode.com/ endpoints. The published APIs represent a blog application where users can publish post and comment on them.

##The starter project
- Tests are written in BDD Gherkin format in Cucumber feature files and it is represented as a living documentation in the test report. 
- This solution is designed in an Action-Question pattern with the code base categorized into domain model packages based on user actions and questions to understand/validate results. 
- The API spec for schema comparison is placed inside "schema" folder in test resources. The specs are generated from https://www.liquid-technologies.com/online-json-to-schema-converter.

## Executing the tests
To run the sample project, you can either just run the `CucumberTestSuite` test runner class, or run either `mvn verify` or `gradle test` from the command line.

By default, the tests will run using Chrome. You can run them in Firefox by overriding the `driver` system property, e.g.
```json
$ mvn clean verify -Ddriver=firefox
```
Or 
```json
$ gradle clean test -Pdriver=firefox
```

## Serenity Reports
The test results will be recorded in the `target/site/serenity/index` directory.

## Allure Reports
To be able to view the reports for the Testing on your PC, install Allure Report first on the Machine (https://docs.qameta.io/allure/). Afterwards proceed to the Project directory on your PC, navigate to target/allure-results folder. Run the command `allure serve ./` 


## Simplified WebDriver configuration and other Serenity extras
The sample projects both use some Serenity features which make configuring the tests easier. In particular, Serenity uses the `serenity.conf` file in the `src/test/resources` directory to configure test execution options.  

### Environment-specific configurations
We can also configure environment-specific properties and options, so that the tests can be run in different environments. Here, we configure three environments, __dev__, _staging_ and _prod_, with different starting URLs for each:
```json
environments {
  default {
    webdriver.base.url = "https://jsonplaceholder.typicode.com"
  }
  dev {
    webdriver.base.url = "https://jsonplaceholder.typicode.com/dev"
  }
  staging {
    webdriver.base.url = "https://jsonplaceholder.typicode.com/staging"
  }
  prod {
    webdriver.base.url = "https://jsonplaceholder.typicode.com/prod"
  }
}
```
## Executing the tests
You use the `environment` system property to determine which environment to run against. For example to run the tests in the staging environment, you could run:
```json
$ mvn clean verify -Denvironment=staging
```
