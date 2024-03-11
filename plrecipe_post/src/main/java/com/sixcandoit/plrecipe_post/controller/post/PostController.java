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
public class PostController {
    private HashtagService hashtagService;
    private PostService postService;
    private ModelMapper modelMapper;
    private PostHashtagService postHashtagService;

    @Autowired
    public PostController(HashtagService hashtagService, PostService postService, ModelMapper modelMapper, PostHashtagService postHashtagService) {
        this.hashtagService = hashtagService;
        this.postService = postService;
        this.modelMapper = modelMapper;
        this.postHashtagService = postHashtagService;
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

    /* 해시태그 생성 */
    @PostMapping("/regist/hashtag")
    private ResponseEntity<ResponseHashtag> registHashTag(@RequestBody RequestHashtag hashtag) {
        HashtagDTO hashtagDTO = modelMapper.map(hashtag, HashtagDTO.class);

        hashtagService.registHashtag(hashtagDTO);

        ResponseHashtag responseHashtag = modelMapper.map(hashtagDTO, ResponseHashtag.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseHashtag);
    }

    /* 게시글 생성(해시태그 중간 객체도 같이 insert) */
    @PostMapping("/regist_both")
    private ResponseEntity<?> registPostAndHashtag(@RequestBody RequestPostHashtag test) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        PostAndHashtag postAndHashtag = modelMapper.map(test, PostAndHashtag.class);
        postService.registPostAndHashtag(postAndHashtag);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /* 게시글 수정 */
    @PatchMapping("/modify/{postId}")
    public ResponseEntity<Post> modifyPost (@RequestBody RequestPost requestPost, @PathVariable int postId ) {
        return ResponseEntity.ok(postService.modifyPost(postId, requestPost));
    }

    /* 게시글 삭제(게시글 삭제일 update) */
    @PatchMapping("/delete/{postId}")
    public ResponseEntity<Post> deletePost (@RequestBody RequestPost requestPost, @PathVariable int postId) {
        return ResponseEntity.ok(postService.modifyPostDeleteDate(postId, requestPost));
    }

    /* 해시태그 삭제 */
    @GetMapping("/hashtag/delete")
    public void deletePage() {}

    /* 해시태그 중간객체 삭제 */
    @DeleteMapping("/hashtag/delete/{postHashtagId}")
    public ResponseEntity<PostHashtag> deletePostHashTag(@PathVariable int postHashtagId) {
        postHashtagService.deletePost(postHashtagId);

        return ResponseEntity.ok().build();
    }

    /* 게시글 좋아요 등록 */
    @PostMapping("/like")
    private ResponseEntity<ResponsePost> postLike(@RequestBody RequestPost post) {
        PostDTO postDTO = modelMapper.map(post, PostDTO.class);

        postService.postLike(postDTO);

        ResponsePost responsePost = modelMapper.map(postDTO, ResponsePost.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(responsePost);
    }

    /*  */
    @PostMapping("/regist")
    private ResponseEntity<ResponsePost> registPost(@RequestBody RequestPost post) {
        PostDTO postDTO = modelMapper.map(post, PostDTO.class);

        postService.registPost(postDTO);

        ResponsePost responsePost = modelMapper.map(postDTO, ResponsePost.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(responsePost);
    }
}