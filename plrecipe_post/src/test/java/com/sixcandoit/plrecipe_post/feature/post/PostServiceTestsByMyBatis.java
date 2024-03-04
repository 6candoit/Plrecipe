package com.sixcandoit.plrecipe_post.feature.post;

import com.sixcandoit.plrecipe_post.aggregate.MemberCount;
import com.sixcandoit.plrecipe_post.dto.PostDTO;
import com.sixcandoit.plrecipe_post.dto.PostHashtagDTO;
import com.sixcandoit.plrecipe_post.dto.PostLikeDTO;
import com.sixcandoit.plrecipe_post.service.PostService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class PostServiceTestsByMyBatis {

    @Autowired
    private PostService postService;

    @Test
    void selectAllPost() {

        List<PostDTO> posts = postService.selectAllPost();
        posts.forEach(System.out::println);

        assertNotNull(posts);
    }

    @ParameterizedTest
    @ValueSource(strings = {"park123@naver.com", "yun123@naver.com"})
    void selectMemberPosts(String memberEmail) {
        List<PostDTO> postList = postService.selectMemberPosts(memberEmail);

        postList.forEach(System.out::println);

        assertTrue(!postList.isEmpty());
    }

    @ParameterizedTest
    @ValueSource(strings = {"Y", "N"})
    void selectPostsByStatus(String postStatus) {
        List<PostDTO> postList = postService.selectPostsByStatus(postStatus);

        postList.forEach(System.out::println);

        assertTrue(!postList.isEmpty());
    }

    @ParameterizedTest
    @ValueSource(strings = {"ONE", "TWO", "MANY"})
    void selectPostsByMemberCounts(MemberCount memberCount) {
        List<PostDTO> postList = postService.selectPostsByMemberCounts(memberCount);

        postList.forEach(System.out::println);

        assertTrue(!postList.isEmpty());
    }

    @ParameterizedTest
    @ValueSource(ints = {1})
    void selectPostHashtags(int postId) {
        List<PostHashtagDTO> postList = postService.selectPostHashtags(postId);

        postList.forEach(System.out::println);

        assertTrue(!postList.isEmpty());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 4, 8})
    void selectPostByLikes(int postId) {

        List<PostLikeDTO> postList = postService.selectPostByLikes(postId);
        postList.forEach(System.out::println);

        assertTrue(!postList.isEmpty());
    }

}
