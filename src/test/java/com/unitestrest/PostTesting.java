package com.unitestrest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostTesting {
    final static String urlPost = "http://dummy.restapiexample.com/api/v1";

    @Test
    public void postRequestTest() {
        JSONObject requestParam = new JSONObject();
        requestParam.put("name", "Robin Sharma");
        requestParam.put("salary", 5000);
        requestParam.put("age", 35);
        String JsonRequest = requestParam.toJSONString();
        Response response = given().contentType(ContentType.JSON).body(JsonRequest).post(urlPost + "/create")
                .then().extract().response();
        String bodyPost = response.getBody().asString();
        System.out.println("Response body is" + bodyPost);
        String responseStatus = response.getBody().path("status");
        System.out.println("Response Status is " + responseStatus);

    }

}
