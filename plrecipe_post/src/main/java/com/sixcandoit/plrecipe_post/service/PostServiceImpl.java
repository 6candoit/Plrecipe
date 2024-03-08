package com.sixcandoit.plrecipe_post.service;

import com.sixcandoit.plrecipe_post.aggregate.MemberCount;
import com.sixcandoit.plrecipe_post.client.MemberServiceClient;
import com.sixcandoit.plrecipe_post.dto.PostDTO;
import com.sixcandoit.plrecipe_post.dto.PostAndHashtagDTO;
import com.sixcandoit.plrecipe_post.dto.PostHashtagDTO;
import com.sixcandoit.plrecipe_post.repository.repo.PostHashtagRepository;
import com.sixcandoit.plrecipe_post.vo.PostAndHashtag;
import com.sixcandoit.plrecipe_post.dto.PostLikeDTO;
import com.sixcandoit.plrecipe_post.aggregate.Post;
import com.sixcandoit.plrecipe_post.repository.mapper.PostMapper;
import com.sixcandoit.plrecipe_post.repository.repo.PostLikeRepository;
import com.sixcandoit.plrecipe_post.repository.repo.PostRepository;
import com.sixcandoit.plrecipe_post.vo.PostHashtag;
import com.sixcandoit.plrecipe_post.vo.PostLike;
import com.sixcandoit.plrecipe_post.vo.member.ResponseMember;
import com.sixcandoit.plrecipe_post.vo.post.RequestPost;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.POST;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private final ModelMapper mapper;
    private final PostMapper postMapper;
    private final PostRepository postRepository;
    private final PostLikeRepository postLikeRepository;
    private final PostHashtagRepository postHashtagRepository;
    private final MemberServiceClient memberServiceClient;

    @Autowired
    public PostServiceImpl(ModelMapper mapper, PostMapper postMapper, PostRepository postRepository, PostLikeRepository postLikeRepository, PostHashtagRepository postHashtagRepository, MemberServiceClient memberServiceClient) {
        this.mapper = mapper;
        this.postMapper = postMapper;
        this.postRepository = postRepository;
        this.postLikeRepository = postLikeRepository;
        this.postHashtagRepository = postHashtagRepository;
        this.memberServiceClient = memberServiceClient;
    }

    @Override
    public PostDTO findPostByCode (int postId) {
        Post post = postRepository.findById(postId).orElseThrow(IllegalArgumentException::new);
        return mapper.map(post, PostDTO.class);
    }

    @Override
    public Page<PostDTO> findPostList(Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1 ,
                pageable.getPageSize(),
                Sort.by("postId").descending());

        Page<Post> postList = postRepository.findAll(pageable);

        return postList.map(post -> mapper.map(post, PostDTO.class));
    }


    @Transactional
    @Override
    public void deletePost(int postId) {
        postRepository.deleteById(postId);
    }

    @Override
    public void registPost(PostDTO postDTO) {
        Date date = new Date();
        SimpleDateFormat format  =new SimpleDateFormat("yyyy-MM-dd");
        String dateTest = format.format(date);

        Post post = mapper.map(postDTO, Post.class);
        post.setPostDate(dateTest);

        postRepository.save(post);
    }

    @Override
    public Post modifyPost(int postId, RequestPost requestPost) {
        Optional<Post> optionalPost = postRepository.findById(postId);
        if (!optionalPost.isPresent()) {
            throw new EntityNotFoundException("게시글이 존재하지 않습니다.");
        }
        Post post = optionalPost.get();
        post.setPostTitle(requestPost.getPostTitle());
        post.setPostContent(requestPost.getPostContent());
        post.setCourseId(requestPost.getCourseId());
        post.setIsPostPublic(requestPost.getIsPostPublic());
        post.setMemberCount(requestPost.getMemberCount());

        return postRepository.save(post);
    }

    @Override
    public Post modifyPostDeleteDate(int postId, RequestPost requestPost) {
        Optional<Post> optionalPost = postRepository.findById(postId);
        if (!optionalPost.isPresent()) {
            throw new EntityNotFoundException("게시글이 존재하지 않습니다.");
        }

        Date date = new Date();
        SimpleDateFormat format  =new SimpleDateFormat("yyyy-MM-dd");
        String dateTest = format.format(date);

        Post post = optionalPost.get();
        post.setPostDeleteDate(dateTest);

        return postRepository.save(post);
    }

    @Override
    public void postLike(PostDTO postDTO) {
        PostLike postLike = mapper.map(postDTO, PostLike.class);
        postLike.setPostId(postDTO.getPostId());
        postLike.setMemberId(postDTO.getMemberId());
        postLikeRepository.save(postLike);
    }

    public void registPostAndHashtag(PostAndHashtag postHashtag){
        Date date = new Date();
        SimpleDateFormat format  =new SimpleDateFormat("yyyy-MM-dd");
        String dateTest = format.format(date);
        Post newPost = postHashtag.getPost();
        newPost.setPostDate(dateTest);
        postRepository.save(newPost);


        savePostHashtags(newPost.getPostId(), postHashtag.getHashtagId());
    }

    private void savePostHashtags(int postId, List<Integer> hashtags) {
        List<PostAndHashtagDTO> postHashtagList = new ArrayList<>();
        for (int i = 0; i < hashtags.size(); i++) {
            PostAndHashtagDTO postAndHashtagDTO = new PostAndHashtagDTO(hashtags.get(i), postId);
            postHashtagList.add(postAndHashtagDTO);
        }

        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<PostHashtag> postHashtags = postHashtagList.stream()
                .map(postHashtag -> mapper.map(postHashtag, PostHashtag.class))
                .collect(Collectors.toList());
        postHashtagRepository.saveAll(postHashtags);

    }

    /* --------------------- Mybatis --------------------- */

    @Override
    public List<PostDTO> selectAllPost() {
        return postMapper.selectAllPost();
    }

    /* 제발 푸쉬좀123131 */
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