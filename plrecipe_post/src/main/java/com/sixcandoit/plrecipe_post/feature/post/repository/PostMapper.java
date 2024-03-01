package com.sixcandoit.plrecipe_post.feature.post.repository;

import com.sixcandoit.plrecipe_post.feature.post.MemberCount;
import com.sixcandoit.plrecipe_post.feature.post.dto.PostDTO;
import com.sixcandoit.plrecipe_post.feature.post.dto.PostHashtagDTO;
import com.sixcandoit.plrecipe_post.feature.post.dto.PostLikeDTO;
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
