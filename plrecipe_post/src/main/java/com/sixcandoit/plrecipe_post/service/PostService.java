package com.sixcandoit.plrecipe_post.service;

import com.sixcandoit.plrecipe_post.dto.PostDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostService {
    PostDTO findPostByCode(int postId);

    Page<PostDTO> findPostList(Pageable pageable);

    void modifyPost(PostDTO modifyPost);

    void deletePost(int postId);
}
