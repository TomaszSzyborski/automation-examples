package com.practice.jsonplaceholder;

import io.qameta.allure.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.practice.jsonplaceholder.pojos.Comment;

import static com.practice.jsonplaceholder.enums.Extremum.MAX;
import static org.assertj.core.api.Assertions.assertThat;

@Epic("Regression tests for Forum")
@Feature("Post new comment")
public class MaxUserIdTest extends BaseTest {

    private int userId;
    private int postId;

    @Test(priority = 0, description = "Get and check maximum value of userId")
    @Severity(SeverityLevel.BLOCKER)
    public void checkMaximumUserId() {
        userId = postsRequests.getUserId(MAX);

        assertThat(userId)
                .as("Maximum userId")
                .isEqualTo(10);
    }

    @Test(priority = 1, description = "Get and check maximum value of postId of given user")
    @Severity(SeverityLevel.BLOCKER)
    public void checkMaximumPostIdForUser() {
        postId = userPostsRequest.getUserPosts(userId, MAX);

        assertThat(postId)
                .as("Maximum userId")
                .isEqualTo(100);
    }

    @Test(priority = 2, description = "Post a new comment for given post and user")
    @Severity(SeverityLevel.CRITICAL)
    @Parameters({"Name", "Email", "Comment"})
    public void createNewCommentForGivenPost(String name, String email, String commentContent) {
        int maxCommentId = commentRequests.getComment(MAX);

        assertThat(maxCommentId)
                .as("Maximum commentId")
                .isEqualTo(500);

        Comment comment = new Comment(postId, name, email, commentContent);

        Comment responseData = commentRequests.postComment(comment);

        assertThat(responseData.getName()).as("Received name").isEqualTo(name);
        assertThat(responseData.getEmail()).as("Received email").isEqualTo(email);
        assertThat(responseData.getCommentContent()).as("Received commentContent").isEqualTo(commentContent);
        assertThat(responseData.getPostId()).as("received postId").isEqualTo(postId);
        assertThat(responseData.getCommentId().orElse(0)).as("received commentId").isEqualTo(maxCommentId + 1);
    }
}
