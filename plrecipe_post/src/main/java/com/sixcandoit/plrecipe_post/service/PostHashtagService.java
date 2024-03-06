package com.sixcandoit.plrecipe_post.service;

import com.sixcandoit.plrecipe_post.dto.PostHashtagDTO;

public interface PostHashtagService {
    void registPostHashtag(PostHashtagDTO postHashtagDTO);

    void deletePost(int postHashtagId);
}
