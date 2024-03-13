package com.sixcandoit.plrecipe_post.query.controller;

import com.sixcandoit.plrecipe_post.query.dto.PostDTO;
import com.sixcandoit.plrecipe_post.query.dto.PostHashtagDTO;
import com.sixcandoit.plrecipe_post.query.dto.PostLikeDTO;
import com.sixcandoit.plrecipe_post.query.service.PostService;
import com.sixcandoit.plrecipe_post.query.aggregate.MemberCount;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class PostController {
    private PostService postService;
    private ModelMapper modelMapper;

    @Autowired
    public PostController(PostService postService, ModelMapper modelMapper) {
        this.postService = postService;
        this.modelMapper = modelMapper;
    }

    /* 설명. 게시글 전체 조회 */
    @GetMapping("/posts")
    public List<PostDTO> selectAllPost() {
        return postService.selectAllPost();
    }

    /* 설명. 멤버가 작성한 게시글 조회(Feign Client를 사용하여 멤버 정보까지 불러옴) */
    @GetMapping("/posts/{memberId}")
    List<PostDTO> selectMemberPosts(@PathVariable int memberId) {
        return postService.selectPostByMember(memberId);
    }

    /* 설명. 게시글 공개 상태별 조회 */
    @GetMapping("/status/{postStatus}")
    public List<PostDTO> selectPostsByStatus(@PathVariable("postStatus") String postStatus){
        return postService.selectPostsByStatus(postStatus);
    }

    /* 게시글 인원수별 조회 */
    @GetMapping("/memberCounts/{memberCounts}")
    public List<PostDTO> selectPostsByMemberCounts(@PathVariable("memberCounts") MemberCount memberCounts) {
        return postService.selectPostsByMemberCounts(memberCounts);
    }

    /* 게시글에 작성된 해시태그 조회 */
    @GetMapping("/hashtag/{postId}")
    public List<PostHashtagDTO> selectPostHashtags(@PathVariable int postId) {
        return postService.selectPostHashtags(postId);
    }

    /* 게시글별 좋아요 조회 */
    @GetMapping("/likes/{postId}")
    public List<PostLikeDTO> selectPostsByLikes(@PathVariable int postId) {
        return postService.selectPostByLikes(postId);
    }

}