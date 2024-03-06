package com.sixcandoit.plrecipe_post.service;

import com.sixcandoit.plrecipe_post.vo.PostAndHashtag;

public interface PostHashtagService {
    void registPostHashtag(PostAndHashtag postAndHashtag);

    void deletePost(int postHashtagId);
}
