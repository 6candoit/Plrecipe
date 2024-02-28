package com.sixcandoit.plrecipe.feature.post;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;


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

}
