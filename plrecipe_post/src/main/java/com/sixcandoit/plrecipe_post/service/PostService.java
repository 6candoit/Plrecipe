package com.sixcandoit.plrecipe_post.service;

import com.sixcandoit.plrecipe_post.aggregate.MemberCount;
import com.sixcandoit.plrecipe_post.aggregate.Post;
import com.sixcandoit.plrecipe_post.dto.PostDTO;
import com.sixcandoit.plrecipe_post.dto.PostHashtagDTO;
import com.sixcandoit.plrecipe_post.vo.PostAndHashtag;
import com.sixcandoit.plrecipe_post.dto.PostLikeDTO;
import com.sixcandoit.plrecipe_post.vo.PostHashtag;
import com.sixcandoit.plrecipe_post.vo.post.RequestPost;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostService {
    PostDTO findPostByCode(int postId);

    Page<PostDTO> findPostList(Pageable pageable);

    void deletePost(int postId);

    List<PostDTO> selectAllPost();



    List<PostDTO> selectPostsByStatus(String postStatus);

    List<PostDTO> selectPostsByMemberCounts(MemberCount memberCounts);

    List<PostHashtagDTO> selectPostHashtags(int postId);

    List<PostLikeDTO> selectPostByLikes(int postId);

    void registPost(PostDTO postDTO);

    Post modifyPost(int postId, RequestPost requestPost);

    Post modifyPostDeleteDate(int postId, RequestPost requestPost);

    void postLike(PostDTO postDTO);

    void registPostAndHashtag(PostAndHashtag postAndHashtag);

    List<PostDTO> selectPostByMember(int memberId);
}