package com.sixcandoit.plrecipe_post.controller;

import com.sixcandoit.plrecipe_post.aggregate.MemberCount;
import com.sixcandoit.plrecipe_post.dto.PostDTO;
import com.sixcandoit.plrecipe_post.dto.PostHashtagDTO;
import com.sixcandoit.plrecipe_post.dto.PostLikeDTO;
import com.sixcandoit.plrecipe_post.repository.mapper.PostMapper;
import com.sixcandoit.plrecipe_post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/main")
public class PostRestApiTest {
    private PostMapper postMapper;
    private PostService postService;

    @Autowired
    public PostRestApiTest(PostMapper postMapper, PostService postService) {
        this.postMapper = postMapper;
        this.postService = postService;
    }

    /* ---------------------- 조회 ---------------------- */
    /* 게시글 전체 조회 */
    @GetMapping("/posts")
    public List<PostDTO> selectAllPost() {
        return postMapper.selectAllPost();
    }

    /* 회원이 작성한 게시글 조회 */
    @GetMapping("/posts/email/{memberId}")
    public List<PostDTO> selectMemberPosts(@PathVariable int memberId) {
        return postMapper.selectMemberPosts(memberId);
    }

    /* 회원 수에 따른 게시글 조회 */

    @GetMapping("/posts/memberCounts/{memberCounts}")
    public List<PostDTO> selectPostsByMemberCounts(@PathVariable("memberCounts") MemberCount memberCounts) {
        return postMapper.selectPostsByMemberCounts(memberCounts);
    }
    /* 게시글에 작성된 해시태그 조회*/

    @GetMapping("/posts/hashtag/{postId}")
    public List<PostHashtagDTO> selectPostHashtags(@PathVariable int postId) {
        return postMapper.selectPostHashtags(postId);
    }
    /* 게시글별 좋아요 조회 */

    @GetMapping("/posts/likes/{postId}")
    public List<PostLikeDTO> selectPostsByLikes(@PathVariable int postId) {
        return postMapper.selectPostByLikes(postId);
    }

    @GetMapping("/posts/status/{postStatus}")
    public List<PostDTO> selectPostsByStatus(@PathVariable("postStatus") String postStatus){
        return postMapper.selectPostsByStatus(postStatus);
    }

    /* ---------------------- update ---------------------- */

    /* 게시글 업데이트(게시글 업데이트) */
    @GetMapping("/modify")
    public void modifyPost() {}

    @PostMapping("/modify")
    public String modifyPostTest(PostDTO modifyPost) {
        postService.modifyPostTest(modifyPost);

        return "redirect:/post/" + modifyPost.getPostId();
    }

    @GetMapping("/post/{postId}")
    public String findPostByPostId(@PathVariable int postId, Model model) {
        PostDTO post = postService.findPostByCode(postId);
        model.addAttribute("post", post);

        return "post/detail";
    }
}
