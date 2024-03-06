package com.sixcandoit.plrecipe_post.service;

import com.sixcandoit.plrecipe_post.vo.PostAndHashtag;
import com.sixcandoit.plrecipe_post.repository.repo.PostHashtagRepository;
import com.sixcandoit.plrecipe_post.vo.PostHashtag;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostHashtagServiceImpl implements PostHashtagService{
    private final ModelMapper mapper;
    private final PostHashtagRepository postHashtagRepository;

    @Autowired
    public PostHashtagServiceImpl(ModelMapper mapper, PostHashtagRepository postHashtagRepository) {
        this.mapper = mapper;
        this.postHashtagRepository = postHashtagRepository;
    }

    @Override
    public void registPostHashtag(PostAndHashtag postAndHashtag) {
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        PostHashtag postHashtag = mapper.map(postAndHashtag, PostHashtag.class);

        postHashtagRepository.save(postHashtag);
    }

    @Override
    public void deletePost(int postHashtagId) {
        postHashtagRepository.deleteById(postHashtagId);
    }
}
