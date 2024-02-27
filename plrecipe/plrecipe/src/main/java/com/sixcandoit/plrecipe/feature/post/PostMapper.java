package com.sixcandoit.plrecipe.feature.post;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {
    List<PostDTO> selectAllPost();

    List<PostDTO> selectMemberPosts(String memberEmail);

    List<PostDTO> selectPostsByStatus(String postStatus);

    List<PostDTO> selectPostsByMemberCounts(MemberCount memberCount);

    List<PostHashtagDTO> selectPostHashtags(int postId);

    List<PostLikeDTO> selectPostByLikes(int postId);
}
