package com.pleoApi.framework;

public class RestAssuredConfiguration {

    @BeforeSuite(alwaysRun = true)
    public void configure(){
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
        RestAssured.basePath = "/PleoAPI";
    }
}
