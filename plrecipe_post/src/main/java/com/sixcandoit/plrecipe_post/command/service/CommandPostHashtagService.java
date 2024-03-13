package com.sixcandoit.plrecipe_post.command.service;

import com.sixcandoit.plrecipe_post.command.aggregate.PostAndHashtag;

public interface CommandPostHashtagService {
    void registPostHashtag(PostAndHashtag postAndHashtag);

    void deletePost(int postHashtagId);
}
