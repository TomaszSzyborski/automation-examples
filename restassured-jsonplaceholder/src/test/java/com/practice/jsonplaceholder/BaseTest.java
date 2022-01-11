package com.practice.jsonplaceholder;

import org.testng.annotations.BeforeClass;

public abstract class BaseTest {
    protected CommentRequests commentRequests;
    protected PostsRequests postsRequests;
    protected UserPostsRequest userPostsRequest;

    @BeforeClass
    public void classSetup(){
        commentRequests = new CommentRequests();
        postsRequests = new PostsRequests();
        userPostsRequest = new UserPostsRequest();
    }

}
