package com.unitestrest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteTesting {
    final static String urlPut = "http://dummy.restapiexample.com/api/v1";

    @Test
    public void deleteRequestTest() {
        Response response = given().contentType(ContentType.JSON).delete(urlPut + "/delete/555")
                .then().extract().response();
        String bodyPost = response.getBody().asString();
        System.out.println("Response body is" + bodyPost);
        String responseStatus = response.getBody().path("status");
        System.out.println("Response Status is " + responseStatus);

    }

}
