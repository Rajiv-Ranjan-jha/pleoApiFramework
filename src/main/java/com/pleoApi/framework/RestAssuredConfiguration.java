package com.pleoApi.framework;

public class RestAssuredConfiguration {

    @BeforeSuite(alwaysRun = true)
    public void configure(){
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
        RestAssured.basePath = "/PleoAPI";
    }

    //Request Specification Class
    public RequestSpecification getRequestSpecification(){

        return RestAssured.given().contentType(ContentType.JSON);
    }

    //Response Builder Class
    public Response getResponse(RequestSpecification requestSpecification String endpoint, int status)
    {
        Response response = requestSpecification.get(endpoint);
        Assert.assertEquals(response.getStatusCode(),status);
        response.then().log().all();
        return response;
    }

    public Cookie getToken(RequestSpecification requestSpecification String endpoint, String username, String password)
    {
        Response response = requestSpecification.get(endpoint).(String username=admin, String password = admin);
        ResponseProcessCookies responseProcessCookies = response.getCookie(String cookie);
        while(responseProcessCookies.hasNext()){
            String x = responseProcessCookies.next().toString();
            //System.out.println(x);
            if (x.contains("X-CSRF-TOKEN")) {
                String y[] = x.split(":");
                String z[] = y[1].split(";");
                String it[] = z[0].split("=");
                token[0] = it[1];
            }
            if (x.contains("JSESSIONID")) {
                String y[] = x.split(":");
                String z[] = y[1].split(";");
                String it[] = z[0].split("=");
                token[1] = it[1];
            }
        }
        return token;

    }
}
