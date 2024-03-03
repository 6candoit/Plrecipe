package com.sixcandoit.plrecipe_post.feature.post.controller;

import com.sixcandoit.plrecipe_post.common.ResponseMessage;
import com.sixcandoit.plrecipe_post.feature.post.MemberCount;
import com.sixcandoit.plrecipe_post.feature.post.dto.PostDTO;
import com.sixcandoit.plrecipe_post.feature.post.dto.PostHashtagDTO;
import com.sixcandoit.plrecipe_post.feature.post.dto.PostLikeDTO;
import com.sixcandoit.plrecipe_post.feature.post.entity.Post;
import com.sixcandoit.plrecipe_post.feature.post.repository.PostMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Member;
import java.nio.charset.Charset;
import java.util.List;

@RestController
@RequestMapping("/post")
public class PostRestApiTest {
    private PostMapper postMapper;

    public PostRestApiTest(PostMapper postMapper) {
        this.postMapper = postMapper;
    }

    @GetMapping("/posts")
    public List<PostDTO> selectAllPost() {
        return postMapper.selectAllPost();
    }

    @GetMapping("/posts/email/{memberEmail}")
    public List<PostDTO> selectMemberPosts(@PathVariable("memberEmail") String memberEmail) {
        return postMapper.selectMemberPosts(memberEmail);
    }

    @GetMapping("/posts/status/{postStatus}")
    public List<PostDTO> selectPostsByStatus(@PathVariable("postStatus") String postStatus){
        return postMapper.selectPostsByStatus(postStatus);
    }

    @GetMapping("/posts/memberCounts/{memberCounts}")
    public List<PostDTO> selectPostsByMemberCounts(@PathVariable("memberCounts") MemberCount memberCounts) {
        return postMapper.selectPostsByMemberCounts(memberCounts);
    }

    @GetMapping("/posts/hashtag/{postId}")
    public List<PostHashtagDTO> selectPostHashtags(@PathVariable int postId) {
        return postMapper.selectPostHashtags(postId);
    }

    @GetMapping("/posts/likes/{postId}")
    public List<PostLikeDTO> selectPostsByLikes(@PathVariable int postId) {
        return postMapper.selectPostByLikes(postId);
    }
}
