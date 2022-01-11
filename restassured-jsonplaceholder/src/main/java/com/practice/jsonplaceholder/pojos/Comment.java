package com.practice.jsonplaceholder.pojos;
import io.restassured.path.json.JsonPath;

import java.util.OptionalInt;

public class Comment {
    private int postId;
    private OptionalInt commentId;
    private String name;
    private String email;
    private String commentContent;

    public Comment(JsonPath jsonPath) {
        this.commentId = OptionalInt.of(jsonPath.getInt("id"));
        this.postId = jsonPath.getInt("postId");
        this.name = jsonPath.getString("name");
        this.email = jsonPath.getString("email");
        this.commentContent = jsonPath.getString("body");
    }

    public Comment(int postId, String name, String email, String commentContent) {
        this.commentId = OptionalInt.empty();
        this.postId = postId;
        this.name = name;
        this.email = email;
        this.commentContent = commentContent;
    }

    public int getPostId() {
        return postId;
    }

    public OptionalInt getCommentId() {
        return commentId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCommentContent() {
        return commentContent;
    }
}
