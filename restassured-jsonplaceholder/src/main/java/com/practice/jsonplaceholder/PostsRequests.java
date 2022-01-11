package com.practice.jsonplaceholder;

import com.practice.jsonplaceholder.enums.Extremum;
import io.restassured.http.ContentType;

public class PostsRequests extends BaseRequest {

    public int getUserId(Extremum extremum){
        return when()
                .get("/posts")
                .then()
                .assertThat()
                .contentType(ContentType.JSON)
                .and()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getInt("userId.toList()*.toInteger()" + extremum.toString());
    }
}
