package com.sixcandoit.plrecipe_post.command.service;

import com.sixcandoit.plrecipe_post.command.aggregate.PostAndHashtag;

public interface PostHashtagService {
    void registPostHashtag(PostAndHashtag postAndHashtag);

    void deletePost(int postHashtagId);
}
