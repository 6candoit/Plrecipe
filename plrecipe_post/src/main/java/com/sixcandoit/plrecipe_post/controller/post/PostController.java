package com.sixcandoit.plrecipe_post.controller.post;

import com.sixcandoit.plrecipe_post.config.Pagination;
import com.sixcandoit.plrecipe_post.config.PagingButtonInfo;
import com.sixcandoit.plrecipe_post.dto.PostDTO;
import com.sixcandoit.plrecipe_post.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/post")
@Slf4j
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/{postId}")
    public String findPostByCode(@PathVariable int postId, Model model) {

        PostDTO post = postService.findPostByCode(postId);
        model.addAttribute("post", post);

        return "post/detail";
    }

    @GetMapping("/list")
    public String findPostList(@PageableDefault Pageable pageable, Model model) {
        log.info("pageable: {}", pageable);

        Page<PostDTO> postList = postService.findPostList(pageable);

        log.info("조회한 내용 목록: {}", postList.getContent());
        log.info("총 페이지 수: {}", postList.getTotalPages());
        log.info("총 메뉴 수: {}", postList.getTotalElements());
        log.info("해당 페이지에 표시 될 요소: {}", postList.getSize());
        log.info("해당 페이지에 실제 요소 수: {}", postList.getNumberOfElements());
        log.info("첫 페이지 여부: {}", postList.isFirst());
        log.info("마지막 페이지 여부: {}", postList.isLast());
        log.info("정렬 방식: {}", postList.getSort());
        log.info("여러 페이지 중 현재 인덱스: {}", postList.getNumber());

        PagingButtonInfo paging = Pagination.getPagingButtonInfo(postList);

        model.addAttribute("paging", paging);
        model.addAttribute("postList", postList);

        return "post/list";
    }


//    @GetMapping("/modify")
//    public void modifyPost() {}
//
//    @PostMapping("/modify")
//    public String modifyPost(PostDTO modifyPost) {
//        postService.modifyPost(modifyPost);
//
//        return "redirect:/post/" + modifyPost.getPostId();
//    }

    /* 게시글 삭제 */
    @GetMapping("/delete")
    public void deletePage() {}

    @PostMapping("/delete/{postId}")
    public String deletePost(@RequestParam int postId) {
        postService.deletePost(postId);

        return "redirect:/post/list";
    }
}
