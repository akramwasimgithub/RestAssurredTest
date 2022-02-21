package com.bridelabz;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.net.URLConnection;

public class GetPostPutDeleteTest {

    @Test
    public void getTest(){
        Response response = RestAssured.get("http://localhost:3000/posts");
        System.out.println("Response: " + response.getStatusCode());
        response.prettyPrint();

    }

    @Test
    public void PostTest(){
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.header("Content-Type","application/json");
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("id","10" );
        jsonObject.put("title","Wasimakram");
        jsonObject.put("author","abcd ");
        requestSpecification.body(jsonObject.toJSONString());
        Response response= requestSpecification.post("http://localhost:3000/posts");
        System.out.println("Response code: " + response.getStatusCode());
        response.prettyPrint() ;
    }

    @Test
    public void PutTest(){
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.header("Content-Type","application/json");
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("id","5" );
        jsonObject.put("title","Wasimakram");
        jsonObject.put("author","post Author");
        requestSpecification.body(jsonObject.toJSONString());
        Response response= requestSpecification.put("http://localhost:3000/posts/10");
        System.out.println("Response code: " + response.getStatusCode());
        response.prettyPrint() ;
    }
    @Test
    public void DeleteTest(){
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.header("Content-Type","application/json");
        Response response= requestSpecification.delete("http://localhost:3000/posts/5");
        System.out.println("Response code: " + response.getStatusCode());
        response.prettyPrint() ;
    }
}

