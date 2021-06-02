package com.unitestrest;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;

public class GetTesting {
    static final String URL = "https://demoqa.com/utilities/weather/city";
    static final String urlQuery = "https://samples.openweathermap.org/data/2.5/";

    @Test
    public void getWeatherTest() {
        Response response = given().when().get(URL + "/Amritsar").then().extract().response();
        // System.out.println("Rest Response is " + response.getBody().asString());
        String temperature = response.getBody().path("Temperature").toString();
        System.out.println("City Temperature" + temperature);
        int code = response.getStatusCode();
        System.out.println("Status Code is " + code);
        Assert.assertEquals(code, 200);
        String contentType = response.getHeader("Content-Type");
        String serverType = response.getHeader("Server");
        String acceptLanguage = response.getHeader("Content-Encoding");
        System.out.println("Content type is " + contentType);
        System.out.println("Server Name is "+serverType);
        System.out.println("Accept Language is "+acceptLanguage);
    }
    @Test
    public void getAllHeaders()
    {
        Response response = given().when().get(URL+"/Amritsar").then().extract().response();
        Headers allHeader = response.getHeaders();
        for(Header header : allHeader )
                {
                    System.out.println("Key: "+ header.getName() + "Value" +header.getValue());

        }
    }
    @Test
    public void getQueryParamTest()
    {
       Response response =  given().when().queryParam("q", "London,UK")
               .queryParam("appid", "2b1fd2d7f77ccf1b7de9b441571b39b8")
               .get(urlQuery+"weather").then().extract().response();
       String body = response.getBody().asString();
       System.out.println("Body is"+body);


    }
}
