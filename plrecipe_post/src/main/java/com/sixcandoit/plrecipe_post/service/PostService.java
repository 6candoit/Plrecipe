package com.sixcandoit.plrecipe_post.service;

import com.sixcandoit.plrecipe_post.aggregate.MemberCount;
import com.sixcandoit.plrecipe_post.dto.PostDTO;
import com.sixcandoit.plrecipe_post.dto.PostHashtagDTO;
import com.sixcandoit.plrecipe_post.dto.PostLikeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostService {
    PostDTO findPostByCode(int postId);

    Page<PostDTO> findPostList(Pageable pageable);

    void modifyPost(PostDTO modifyPost);

    void deletePost(int postId);

    List<PostDTO> selectAllPost();

    List<PostDTO> selectMemberPosts(int memberId);

    List<PostDTO> selectPostsByStatus(String postStatus);

    List<PostDTO> selectPostsByMemberCounts(MemberCount memberCounts);

    List<PostHashtagDTO> selectPostHashtags(int postId);

    List<PostLikeDTO> selectPostByLikes(int postId);

    void registPost(PostDTO postDTO);
}
