package com.practice.jsonplaceholder;

import com.practice.jsonplaceholder.enums.Extremum;
import io.restassured.http.ContentType;

public class UserPostsRequest extends BaseRequest{

    public int getUserPosts(int userId, Extremum extremum){
        return given()
                .queryParam("userId", userId)
                .when()
                .get("/posts")
                .then()
                .assertThat()
                .contentType(ContentType.JSON)
                .and()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getInt("id.toList()*.toInteger()" + extremum.toString());
    }
}
