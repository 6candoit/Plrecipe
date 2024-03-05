package com.sixcandoit.plrecipe_post.service;

import com.sixcandoit.plrecipe_post.aggregate.MemberCount;
import com.sixcandoit.plrecipe_post.dto.PostDTO;
import com.sixcandoit.plrecipe_post.dto.PostHashtagDTO;
import com.sixcandoit.plrecipe_post.dto.PostLikeDTO;
import com.sixcandoit.plrecipe_post.aggregate.Post;
import com.sixcandoit.plrecipe_post.repository.mapper.PostMapper;
import com.sixcandoit.plrecipe_post.repository.repo.PostRepository;
import com.sixcandoit.plrecipe_post.vo.RequestPost;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    private final ModelMapper mapper;
    private final PostMapper postMapper;
    private final PostRepository postRepository;

    @Autowired
    public PostServiceImpl(ModelMapper mapper, PostMapper postMapper, PostRepository postRepository) {
        this.mapper = mapper;
        this.postMapper = postMapper;
        this.postRepository = postRepository;
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

//    @Transactional
//    @Override
//    public void modifyPost(PostDTO postDTO) {
//        /* 게시글 수정 오류(코스, email이 null값으로 들어가서 오류가 발생되는거로 추정됨.) */
//        Date date = new Date();
//        SimpleDateFormat format  = new SimpleDateFormat("yyyy-MM-dd");
//        String dateTest = format.format(date);
//
//        Post foundPost = postRepository.findById(postDTO.getPostId()).orElseThrow(IllegalArgumentException::new);
//        foundPost.setPostTitle(postDTO.getPostTitle());
//        foundPost.setIsPostPublic(postDTO.getIsPostPublic());
//        foundPost.setMemberCount(postDTO.getMemberCount());
//        foundPost.setPostDate(dateTest);
//
//    }


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
    public void registPost(PostDTO postDTO) {
        Date date = new Date();
        SimpleDateFormat format  =new SimpleDateFormat("yyyy-MM-dd");
        String dateTest = format.format(date);

        Post post = mapper.map(postDTO, Post.class);
        post.setPostDate(dateTest);

        postRepository.save(post);
    }

    /* --------------------- Mybatis --------------------- */

    @Override
    public List<PostDTO> selectAllPost() {
        return postMapper.selectAllPost();
    }

    @Override
    public List<PostDTO> selectMemberPosts(int memberId) {
        return postMapper.selectMemberPosts(memberId);
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