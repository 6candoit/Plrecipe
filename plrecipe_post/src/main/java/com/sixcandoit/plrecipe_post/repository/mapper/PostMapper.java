package com.sixcandoit.plrecipe_post.repository.mapper;

import com.sixcandoit.plrecipe_post.aggregate.MemberCount;
import com.sixcandoit.plrecipe_post.dto.PostDTO;
import com.sixcandoit.plrecipe_post.vo.PostAndHashtag;
import com.sixcandoit.plrecipe_post.dto.PostLikeDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper{

    List<PostDTO> selectAllPost();

    List<PostDTO> selectMemberPosts(int memberId);

    List<PostDTO> selectPostsByStatus(String postStatus);

    List<PostDTO> selectPostsByMemberCounts(MemberCount memberCount);

    List<PostAndHashtag> selectPostHashtags(int postId);

    List<PostLikeDTO> selectPostByLikes(int postId);
}
