package com.sixcandoit.plrecipe_post.query.service;

import com.sixcandoit.plrecipe_post.query.dto.PostDTO;
import com.sixcandoit.plrecipe_post.query.dto.PostHashtagDTO;
import com.sixcandoit.plrecipe_post.query.dto.PostLikeDTO;
import com.sixcandoit.plrecipe_post.query.client.MemberServiceClient;
import com.sixcandoit.plrecipe_post.query.vo.ResponseMember;
import com.sixcandoit.plrecipe_post.query.aggregate.MemberCount;
import com.sixcandoit.plrecipe_post.query.repository.PostMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService{
    private final ModelMapper mapper;
    private final PostMapper postMapper;
    private final MemberServiceClient memberServiceClient;

    @Autowired
    public PostServiceImpl(ModelMapper mapper, PostMapper postMapper, MemberServiceClient memberServiceClient) {
        this.mapper = mapper;
        this.postMapper = postMapper;
        this.memberServiceClient = memberServiceClient;
    }

    @Override
    public List<PostDTO> selectAllPost() {
        return postMapper.selectAllPost();
    }

    @Override
    public List<PostDTO> selectPostByMember(int memberId) {
        List<PostDTO> postList = postMapper.selectMemberPosts(memberId);

        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<PostDTO> postDTOList = postList.stream()
                .map(post -> mapper.map(post, PostDTO.class))
                .collect(Collectors.toList());

        for (int i = 0; i < postDTOList.size(); i++) {
            ResponseMember responseMember = memberServiceClient.getMemberInfo(postDTOList.get(i).getMemberId());
            postDTOList.get(i).setMember(responseMember);
        }

        return postDTOList;
    }

    @Override
    public List<PostDTO> selectPostsByStatus(String postStatus) {
        return postMapper.selectPostsByStatus(postStatus);
    }

    @Override
    public List<PostDTO> selectPostsByMemberCounts(MemberCount memberCount) {
        return postMapper.selectPostsByMemberCounts(memberCount);
    }

    @Override
    public List<PostHashtagDTO> selectPostHashtags(int postId) {
        return postMapper.selectPostHashtags(postId);
    }

    @Override
    public List<PostLikeDTO> selectPostByLikes(int postId) {
        return postMapper.selectPostByLikes(postId);
    }

}
