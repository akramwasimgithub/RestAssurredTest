package com.bridelabz;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class FetchingData {

    @Test
    public void getTestId(){
        Response response = RestAssured.get("http://localhost:3000/posts");
        System.out.println("Response: " + response.getStatusCode());
        JsonPath jsonPath = response.jsonPath();
        System.out.println("Id :"+ jsonPath.get("id"));
       // response.prettyPrint();

    }

    @Test
    public void getTestTitle(){
       Response response= RestAssured.get("http://localhost:3000/posts");
       System.out.println("Response code: " + response.getStatusCode());
       JsonPath jsonPath = response.jsonPath();
        System.out.println("Title: " + jsonPath.get("title"));

    }
    @Test
    public void getTestAuthor(){

        Response response= RestAssured.get("http://localhost:3000/posts");
        JsonPath jsonPath = response.jsonPath();
        System.out.println("Author: " + jsonPath.get("author"));
    }

}
