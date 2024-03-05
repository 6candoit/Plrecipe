package com.sixcandoit.plrecipe_post.controller;

import com.sixcandoit.plrecipe_post.aggregate.MemberCount;
import com.sixcandoit.plrecipe_post.dto.PostDTO;
import com.sixcandoit.plrecipe_post.dto.PostHashtagDTO;
import com.sixcandoit.plrecipe_post.dto.PostLikeDTO;
import com.sixcandoit.plrecipe_post.repository.mapper.PostMapper;
import com.sixcandoit.plrecipe_post.service.PostService;
import com.sixcandoit.plrecipe_post.vo.RequestPost;
import com.sixcandoit.plrecipe_post.vo.ResponsePost;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostRestApiTest {
    private PostService postService;
    private ModelMapper modelMapper;
    private PostService postMapper;

    @Autowired
    public PostRestApiTest(PostService postService, ModelMapper modelMapper, PostService postMapper) {
        this.postService = postService;
        this.modelMapper = modelMapper;
        this.postMapper = postMapper;
    }

    @GetMapping("/posts")
    public List<PostDTO> selectAllPost() {
        return postService.selectAllPost();
    }

    @GetMapping("/posts/email/{memberId}")
    public List<PostDTO> selectMemberPosts(@PathVariable int memberId) {
        return postService.selectMemberPosts(memberId);
    }

    @GetMapping("/posts/status/{postStatus}")
    public List<PostDTO> selectPostsByStatus(@PathVariable("postStatus") String postStatus){
        return postService.selectPostsByStatus(postStatus);
    }

    @GetMapping("/posts/memberCounts/{memberCounts}")
    public List<PostDTO> selectPostsByMemberCounts(@PathVariable("memberCounts") MemberCount memberCounts) {
        return postService.selectPostsByMemberCounts(memberCounts);
    }

    @GetMapping("/posts/hashtag/{postId}")
    public List<PostHashtagDTO> selectPostHashtags(@PathVariable int postId) {
        return postService.selectPostHashtags(postId);
    }

    @GetMapping("/posts/likes/{postId}")
    public List<PostLikeDTO> selectPostsByLikes(@PathVariable int postId) {
        return postService.selectPostByLikes(postId);
    }

    @PostMapping("/regist")
    private ResponseEntity<ResponsePost> registPost(@RequestBody RequestPost post) {
        PostDTO postDTO = modelMapper.map(post, PostDTO.class);

        postService.registPost(postDTO);

        ResponsePost responsePost = modelMapper.map(postDTO, ResponsePost.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(responsePost);
    }
}
