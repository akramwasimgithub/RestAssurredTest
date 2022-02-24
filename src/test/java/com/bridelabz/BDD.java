package com.bridelabz;

import io.restassured.RestAssured;

import io.restassured.common.mapper.TypeRef;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.http.Headers;
import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.json.config.JsonPathConfig;
import io.restassured.path.xml.XmlPath;
import io.restassured.path.xml.config.XmlPathConfig;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;

public class BDD {

    @Test
    public void GetTest(){
        given().
                when().
                    get("http://localhost:3000/posts").
                then().
                    assertThat().statusCode(200);


    }

    @Test
    public void PostTest(){
        JSONObject jsonObject= new JSONObject();
        jsonObject.put("id","12");
        jsonObject.put("title","BDD");
        jsonObject.put("author","Wasim");
        RestAssured.given()
                .header("Content-Type","Application/json")
                .body(jsonObject.toJSONString())
                .when()
                    .post("http://localhost:3000/posts")
                .then()
                    .assertThat()
                    .statusCode(201);



    }
    @Test
    public void PutTest(){
        JSONObject jsonObject= new JSONObject();
        jsonObject.put("id","9");
        jsonObject.put("title","Wasimakramput");
        jsonObject.put("author","post Author put");

        Response response = RestAssured.given()
                    .header("Content-type","Application/json")
                    .body(jsonObject.toJSONString())
                .when()
                    .post("http://localhost:3000/posts");
        
                response.getStatusCode();
                response.asString();
                response.prettyPrint();

    }
    @Test
    public void DeleteTest(){
        Response response=RestAssured.given()
                    .header("Content-type","Application/json")
                .when()
                    .delete("http://localhost:3000/posts/6");
    }

}

