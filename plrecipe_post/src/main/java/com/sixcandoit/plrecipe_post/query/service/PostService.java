package com.sixcandoit.plrecipe_post.query.service;

import com.sixcandoit.plrecipe_post.query.dto.PostDTO;
import com.sixcandoit.plrecipe_post.query.dto.PostHashtagDTO;
import com.sixcandoit.plrecipe_post.query.dto.PostLikeDTO;
import com.sixcandoit.plrecipe_post.query.aggregate.MemberCount;


import java.util.List;

public interface PostService {
    List<PostDTO> selectAllPost();
    List<PostDTO> selectPostByMember(int memberId);

    List<PostDTO> selectPostsByStatus(String postStatus);

    List<PostDTO> selectPostsByMemberCounts(MemberCount memberCounts);

    List<PostHashtagDTO> selectPostHashtags(int postId);

    List<PostLikeDTO> selectPostByLikes(int postId);

    List<PostDTO> selectMemberLikesPosts(int memberId);

    List<PostDTO> selectPost(int postId);
}
