package com.sixcandoit.plrecipe.feature.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Post {
    private PostMapper postMapper;

    @Autowired
    public Post(PostMapper postMapper) {
        this.postMapper = postMapper;
    }

    public List<PostDTO> selectAllPost() {
        return postMapper.selectAllPost();
    }
}
