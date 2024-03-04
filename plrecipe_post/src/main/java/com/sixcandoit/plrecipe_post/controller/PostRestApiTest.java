package com.sixcandoit.plrecipe_post.controller;

import com.sixcandoit.plrecipe_post.aggregate.MemberCount;
import com.sixcandoit.plrecipe_post.dto.PostDTO;
import com.sixcandoit.plrecipe_post.dto.PostHashtagDTO;
import com.sixcandoit.plrecipe_post.dto.PostLikeDTO;
import com.sixcandoit.plrecipe_post.repository.mapper.PostMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/posts/email/{memberId}")
    public List<PostDTO> selectMemberPosts(@PathVariable int memberId) {
        return postMapper.selectMemberPosts(memberId);
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
