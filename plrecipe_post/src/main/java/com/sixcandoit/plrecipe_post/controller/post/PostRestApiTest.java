package com.sixcandoit.plrecipe_post.controller.post;

import com.sixcandoit.plrecipe_post.aggregate.MemberCount;
import com.sixcandoit.plrecipe_post.aggregate.Post;
import com.sixcandoit.plrecipe_post.dto.HashtagDTO;
import com.sixcandoit.plrecipe_post.dto.PostDTO;
import com.sixcandoit.plrecipe_post.dto.PostHashtagDTO;
import com.sixcandoit.plrecipe_post.vo.PostAndHashtag;
import com.sixcandoit.plrecipe_post.dto.PostLikeDTO;
import com.sixcandoit.plrecipe_post.service.HashtagService;
import com.sixcandoit.plrecipe_post.service.PostHashtagService;
import com.sixcandoit.plrecipe_post.service.PostService;
import com.sixcandoit.plrecipe_post.vo.*;
import com.sixcandoit.plrecipe_post.vo.hashtag.RequestHashtag;
import com.sixcandoit.plrecipe_post.vo.hashtag.ResponseHashtag;
import com.sixcandoit.plrecipe_post.vo.post.RequestPost;
import com.sixcandoit.plrecipe_post.vo.post.ResponsePost;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/post")
@RequestMapping("/")
public class PostRestApiTest {
    private HashtagService hashtagService;
    private PostService postService;
    private ModelMapper modelMapper;
    private PostHashtagService postHashtagService;

    @Autowired
    public PostRestApiTest(HashtagService hashtagService, PostService postService, ModelMapper modelMapper, PostHashtagService postHashtagService) {
        this.hashtagService = hashtagService;
        this.postService = postService;
        this.modelMapper = modelMapper;
        this.postHashtagService = postHashtagService;
    }


    @GetMapping("/posts")
    public List<PostDTO> selectAllPost() {
        return postService.selectAllPost();
    }

    @GetMapping("/posts/{memberId}")
    List<PostDTO> selectMemberPosts(@PathVariable int memberId) {
        return postService.selectPostByMember(memberId);
    }

    @GetMapping("/status/{postStatus}")
    public List<PostDTO> selectPostsByStatus(@PathVariable("postStatus") String postStatus){
        return postService.selectPostsByStatus(postStatus);
    }

    @GetMapping("/memberCounts/{memberCounts}")
    public List<PostDTO> selectPostsByMemberCounts(@PathVariable("memberCounts") MemberCount memberCounts) {
        return postService.selectPostsByMemberCounts(memberCounts);
    }

    @GetMapping("/hashtag/{postId}")
    public List<PostHashtagDTO> selectPostHashtags(@PathVariable int postId) {
        return postService.selectPostHashtags(postId);
    }

    @GetMapping("/likes/{postId}")
    public List<PostLikeDTO> selectPostsByLikes(@PathVariable int postId) {
        return postService.selectPostByLikes(postId);
    }

    @PostMapping("/regist/hashtag")
    private ResponseEntity<ResponseHashtag> registHashTag(@RequestBody RequestHashtag hashtag) {
        HashtagDTO hashtagDTO = modelMapper.map(hashtag, HashtagDTO.class);

        hashtagService.registHashtag(hashtagDTO);

        ResponseHashtag responseHashtag = modelMapper.map(hashtagDTO, ResponseHashtag.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseHashtag);
    }

    @PostMapping("/regist")
    private ResponseEntity<ResponsePost> registPost(@RequestBody RequestPost post) {
        PostDTO postDTO = modelMapper.map(post, PostDTO.class);

        postService.registPost(postDTO);

        ResponsePost responsePost = modelMapper.map(postDTO, ResponsePost.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(responsePost);
    }

    @PostMapping("/regist_both")
    private ResponseEntity<?> registPostAndHashtag(@RequestBody RequestTest test) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        PostAndHashtag postAndHashtag = modelMapper.map(test, PostAndHashtag.class);
        postService.registPostAndHashtag(postAndHashtag);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PatchMapping("/modify/{postId}")
    public ResponseEntity<Post> modifyPost (@RequestBody RequestPost requestPost, @PathVariable int postId ) {
        return ResponseEntity.ok(postService.modifyPost(postId, requestPost));
    }

    @PatchMapping("/delete/{postId}")
    public ResponseEntity<Post> deletePost (@RequestBody RequestPost requestPost, @PathVariable int postId) {
        return ResponseEntity.ok(postService.modifyPostDeleteDate(postId, requestPost));
    }


    @GetMapping("/hashtag/delete")
    public void deletePage() {}

    @DeleteMapping("/hashtag/delete/{postHashtagId}")
    public ResponseEntity<PostHashtag> deletePostHashTag(@PathVariable int postHashtagId) {
        postHashtagService.deletePost(postHashtagId);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/like")
    private ResponseEntity<ResponsePost> postLike(@RequestBody RequestPost post) {
        PostDTO postDTO = modelMapper.map(post, PostDTO.class);

        postService.postLike(postDTO);

        ResponsePost responsePost = modelMapper.map(postDTO, ResponsePost.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(responsePost);
    }
}