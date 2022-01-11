package com.practice.jsonplaceholder;

import io.restassured.RestAssured;

public abstract class BaseRequest extends RestAssured {

    public BaseRequest() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

}
