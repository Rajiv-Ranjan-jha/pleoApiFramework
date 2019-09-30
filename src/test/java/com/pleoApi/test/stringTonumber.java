package com.pleoApi.test;

import com.pleoApi.framework.RestAssuredConfiguration;
import com.pleoApi.test.common.EndPoint;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class stringTonumber {

    @Test
    public void validatenumbertostring2(){

        given().get(EndPoint.GET_String).then().statusCode(200).log().all();
    }


    //Here I took an example of facebook to explain profile detail validation

    @Test (groups = "get")
    public <JSONObject> void validategetprofile(){
        RequestSpecification requestSpecification = new RestAssuredConfiguration().getRequestSpecification();
        requestSpecification.queryParam(stringTonumber).log().all();
        given().spec(requestSpecification).get(EndPoint.GET_String).then().statusCode(200).log().all();
        Response response =  given().spec(requestSpecification).get(EndPoint.GET_Profile);

        //Assuming this in case of valid Number Convertion
        Assert.assertEquals(response.getStatusCode(),"200");

        ResponseBody body = response.getBody();
        String bodyStringValue = body.asString()
        Assert.assertTrue(bodyStringValue.contains("message"));
        Assert.assertTrue(bodyStringValue.contains("Success"));

        //Assuming this in case of Invalid token
        Assert.assertEquals(response.getStatusCode(),"400");

        @Test (groups = "profilepost")
        public void validatepostprofile(){

            RequestSpecification requestSpecification = new RestAssuredConfiguration().getRequestSpecification();
            requestSpecification.queryParam(token).log().all();

            JSONObject requestbody = new JSONObject();
            requestbody.put("name", "Alex"); // Cast
            requestbody.put("has_spouce", "true");
            requestbody.put("birthday", "1989-05-04");
            requestbody.put("current_city","New York");
            requestbody.put("Sex","Female");

            requestSpecification.body(requestbody.toJSONString());

            Response response =  given().spec(requestSpecification).post(EndPoint.POST_PROFILE_PARAM);

            ProfileBin profileBin = response.as(ProfileBin.class);

            // Data Validation we can do against Database, Another API , Nosql source and commom Logic
            SoftAssert softAssert = new SoftAssert();

            softAssert.assertTrue(!stringTonumber.getToken().equalsIgnoreCase(""),"Token is blank Invalid Response");

            softAssert.assertEquals(stringTonumber.getname(),"Roma","Number of kids is not equal");
            softAssert.assertEquals(stringTonumber.isHas_spouse(), "true" "spouce data mismatch");
            softAssert.assertEquals(stringTonumber.getBirthday(), "1989-05-04" "Birthday data is mismatch");
            softAssert.assertEquals(stringTonumber.getcurrent_city(),"Boston", "Boston data is mismatch");
            softAssert.assertEquals(stringTonumber.getsex(),"Female","Sex is mismatch");
            softAssert.assertTrue(response.getTimeIn(TimeUnit.SECONDS<10,"Response Time is not within Limit"));

        }

    //Request Specification - We can add here some more test for Query Parameters, Path Parameters and Post Parameters.

}
