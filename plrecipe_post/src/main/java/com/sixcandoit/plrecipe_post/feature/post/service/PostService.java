package com.sixcandoit.plrecipe_post.feature.post.service;

import com.sixcandoit.plrecipe_post.feature.post.MemberCount;
import com.sixcandoit.plrecipe_post.feature.post.dto.PostDTO;
import com.sixcandoit.plrecipe_post.feature.post.dto.PostHashtagDTO;
import com.sixcandoit.plrecipe_post.feature.post.dto.PostLikeDTO;
import com.sixcandoit.plrecipe_post.feature.post.repository.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private PostMapper postMapper;

    @Autowired
    public PostService(PostMapper postMapper) {
        this.postMapper = postMapper;
    }

    public List<PostDTO> selectAllPost() {
        return postMapper.selectAllPost();
    }

    public List<PostDTO> selectMemberPosts(String memberEmail) {
        return postMapper.selectMemberPosts(memberEmail);
    }

    public List<PostDTO> selectPostsByStatus(String postStatus) {
        return postMapper.selectPostsByStatus(postStatus);
    }

    public List<PostDTO> selectPostsByMemberCounts(MemberCount memberCount) {
        return postMapper.selectPostsByMemberCounts(memberCount);
    }

    public List<PostHashtagDTO> selectPostHashtags(int postId) {
        return postMapper.selectPostHashtags(postId);
    }

    public List<PostLikeDTO> selectPostByLikes(int postId) {
        return postMapper.selectPostByLikes(postId);
    }
}
