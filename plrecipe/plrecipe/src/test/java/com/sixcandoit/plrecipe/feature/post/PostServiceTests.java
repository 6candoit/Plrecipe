package com.sixcandoit.plrecipe.feature.post;

import com.sixcandoit.plrecipe.feature.post.dto.PostDTO;
import com.sixcandoit.plrecipe.feature.post.dto.PostHashtagDTO;
import com.sixcandoit.plrecipe.feature.post.dto.PostLikeDTO;
import com.sixcandoit.plrecipe.feature.post.entity.Post;
import com.sixcandoit.plrecipe.feature.post.service.MemberCount;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
public class PostServiceTests {

    @Autowired
    private Post postService;

    @Test
    void testRegistNewOrder() {

        List<PostDTO> post = postService.selectAllPost();
        post.forEach(System.out::println);

        assertNotNull(post);
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
    @ValueSource(strings = {"ONE", "TWO", "THREE"})
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
