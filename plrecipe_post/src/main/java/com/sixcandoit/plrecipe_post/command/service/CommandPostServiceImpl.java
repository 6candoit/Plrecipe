package com.sixcandoit.plrecipe_post.command.service;


import com.sixcandoit.plrecipe_post.command.aggregate.Post;
import com.sixcandoit.plrecipe_post.command.dto.PostAndHashtagDTO;
import com.sixcandoit.plrecipe_post.command.dto.PostDTO;
import com.sixcandoit.plrecipe_post.command.repositroy.PostHashtagRepository;
import com.sixcandoit.plrecipe_post.command.aggregate.PostAndHashtag;
import com.sixcandoit.plrecipe_post.command.repositroy.PostLikeRepository;
import com.sixcandoit.plrecipe_post.command.repositroy.PostRepository;
import com.sixcandoit.plrecipe_post.command.aggregate.PostHashtag;
import com.sixcandoit.plrecipe_post.command.aggregate.PostLike;
import com.sixcandoit.plrecipe_post.command.vo.RequestPost;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommandPostServiceImpl implements CommandPostService {

    private final ModelMapper mapper;
    private final PostRepository postRepository;
    private final PostLikeRepository postLikeRepository;
    private final PostHashtagRepository postHashtagRepository;

    @Autowired
    public CommandPostServiceImpl(ModelMapper mapper, PostRepository postRepository, PostLikeRepository postLikeRepository, PostHashtagRepository postHashtagRepository) {
        this.mapper = mapper;
        this.postRepository = postRepository;
        this.postLikeRepository = postLikeRepository;
        this.postHashtagRepository = postHashtagRepository;
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
}