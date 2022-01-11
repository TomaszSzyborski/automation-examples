package com.practice.jsonplaceholder;

import com.practice.jsonplaceholder.pojos.Comment;
import com.google.gson.Gson;
import com.practice.jsonplaceholder.enums.Extremum;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

import java.util.Map;

public class CommentRequests extends BaseRequest {

    public int getComment(Extremum extremum) {
        return given()
                .when()
                .get("/comments")
                .then()
                .assertThat()
                .contentType(ContentType.JSON)
                .and()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getInt("id.toList()*.toInteger()" + extremum.toString());
    }

    public Comment postComment(Comment comment) {
        String payload = new Gson().toJson(Map.of(
                "postId", comment.getPostId(),
                "name", comment.getName(),
                "email", comment.getEmail(),
                "body", comment.getCommentContent())
        );

        JsonPath responseData = given()
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post("comments")
                .then()
                .assertThat()
                .contentType(ContentType.JSON)
                .and()
                .statusCode(201)
                .extract()
                .jsonPath();

        return new Comment(responseData);
    }
}
