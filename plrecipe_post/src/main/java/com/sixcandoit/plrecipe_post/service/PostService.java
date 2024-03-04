package com.sixcandoit.plrecipe_post.service;

import com.sixcandoit.plrecipe_post.aggregate.MemberCount;
import com.sixcandoit.plrecipe_post.dto.PostDTO;
import com.sixcandoit.plrecipe_post.dto.PostHashtagDTO;
import com.sixcandoit.plrecipe_post.dto.PostLikeDTO;
import com.sixcandoit.plrecipe_post.aggregate.Post;
import com.sixcandoit.plrecipe_post.repository.mapper.PostMapper;
import com.sixcandoit.plrecipe_post.repository.repo.PostRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class PostService {

    private final ModelMapper mapper;
    private final PostMapper postMapper;
    private final PostRepository postRepository;

    @Autowired
    public PostService(ModelMapper mapper, PostMapper postMapper, PostRepository postRepository) {
        this.mapper = mapper;
        this.postMapper = postMapper;
        this.postRepository = postRepository;
    }

    public PostDTO findPostByCode (int postId) {
        Post post = postRepository.findById(postId).orElseThrow(IllegalArgumentException::new);
        return mapper.map(post, PostDTO.class);
    }

    public Page<PostDTO> findPostList(Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1 ,
                pageable.getPageSize(),
                Sort.by("postId").descending());

        Page<Post> postList = postRepository.findAll(pageable);

        return postList.map(post -> mapper.map(post, PostDTO.class));
    }

    public void registPost(PostDTO newPost) {
        postRepository.save(mapper.map(newPost, Post.class));
    }

    @Transactional
    public void modifyPost(PostDTO modifyPost) {
        /* 게시글 수정 오류(코스, email이 null값으로 들어가서 오류가 발생되는거로 추정됨.) */
        Date date = new Date();
        SimpleDateFormat format  =new SimpleDateFormat("yyyy-MM-dd");
        String dateTest = format.format(date);

        Post foundPost = postRepository.findById(modifyPost.getPostId()).orElseThrow(IllegalArgumentException::new);
        foundPost.setPostTitle(modifyPost.getPostTitle());
        foundPost.setIsPostPublic(modifyPost.getIsPostPublic());
        foundPost.setMemberCount(modifyPost.getMemberCount());
        foundPost.setPostDate(dateTest);

    }

    @Transactional
    public void deletePost(int postId) {
        postRepository.deleteById(postId);
    }

    /* --------------------- Mybatis --------------------- */

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
