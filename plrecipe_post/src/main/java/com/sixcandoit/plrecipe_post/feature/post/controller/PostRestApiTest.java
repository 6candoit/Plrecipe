package com.sixcandoit.plrecipe_post.feature.post.controller;

import com.sixcandoit.plrecipe_post.common.ResponseMessage;
import com.sixcandoit.plrecipe_post.feature.post.dto.PostDTO;
import com.sixcandoit.plrecipe_post.feature.post.repository.PostMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.Charset;
import java.util.List;

@RestController
@RequestMapping("/post")
public class PostRestApiTest {
    private PostMapper postMapper;


    @GetMapping("/posts")
    public List<PostDTO> selectAllPost() {
        return postMapper.selectAllPost();
    }

//    @GetMapping("/posts/{memberEmail}")
//    public List<PostDTO> selectMemberPosts(@PathVariable String memberEmail) {
//        memberEmail = "yun123@naver.com";
//        return postMapper.selectMemberPosts(memberEmail);
//    }
}
