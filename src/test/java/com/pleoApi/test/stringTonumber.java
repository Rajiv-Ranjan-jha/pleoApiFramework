package com.pleoApi.test;

import com.pleoApi.test.common.EndPoint;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class stringTonumber {

    @Test
    public void validatenumbertostring(){

        given().get("http://localhost:8080/PleoAPI/rest/NumberToString?number=2310000.159897").then().statusCode(200).log().all();
    }

    @Test
    public void validatenumbertostring2(){

        given().get(EndPoint.GET_String).then().statusCode(200).log().all();
    }

}
