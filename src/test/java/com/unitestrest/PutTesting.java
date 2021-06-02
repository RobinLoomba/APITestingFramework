package com.unitestrest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PutTesting {
    final static String urlPut = "http://dummy.restapiexample.com/api/v1";

    @Test
    public void putRequestTest() {
        JSONObject requestParam = new JSONObject();
        requestParam.put("name", "Sachin Sharma");
        requestParam.put("salary", 5000);
        requestParam.put("age", 35);
        String JsonRequest = requestParam.toJSONString();
        Response response = given().contentType(ContentType.JSON).body(JsonRequest).put(urlPut + "/update/7104")
                .then().extract().response();
        String bodyPost = response.getBody().asString();
        System.out.println("Response body is" + bodyPost);
        String responseStatus = response.getBody().path("status");
        System.out.println("Response Status is " + responseStatus);

    }

}
