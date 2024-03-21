package com.sixcandoit.plrecipe_post.query.repository;

import com.sixcandoit.plrecipe_post.query.aggregate.MemberCount;
import com.sixcandoit.plrecipe_post.query.dto.PostDTO;
import com.sixcandoit.plrecipe_post.query.dto.PostHashtagDTO;
import com.sixcandoit.plrecipe_post.query.dto.PostLikeDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper{

    List<PostDTO> selectAllPost();

    List<PostDTO> selectMemberPosts(int memberId);

    List<PostDTO> selectPostsByStatus(String postStatus);

    List<PostDTO> selectPostsByMemberCounts(MemberCount memberCount);

    List<PostHashtagDTO> selectPostHashtags(int postId);

    List<PostLikeDTO> selectPostByLikes(int postId);

    List<PostDTO> selectMemberLikesPosts(int memberId);

    List<PostDTO> selectPost(int postId);
}
