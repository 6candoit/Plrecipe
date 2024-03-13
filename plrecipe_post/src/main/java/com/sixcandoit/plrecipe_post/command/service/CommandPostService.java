package com.sixcandoit.plrecipe_post.command.service;


import com.sixcandoit.plrecipe_post.command.aggregate.Post;
import com.sixcandoit.plrecipe_post.command.aggregate.PostAndHashtag;
import com.sixcandoit.plrecipe_post.command.dto.PostDTO;
import com.sixcandoit.plrecipe_post.command.vo.RequestPost;

public interface CommandPostService {


    void deletePost(int postId);

    void registPost(PostDTO postDTO);

    Post modifyPost(int postId, RequestPost requestPost);

    Post modifyPostDeleteDate(int postId, RequestPost requestPost);

    void postLike(PostDTO postDTO);

    void registPostAndHashtag(PostAndHashtag postAndHashtag);

}