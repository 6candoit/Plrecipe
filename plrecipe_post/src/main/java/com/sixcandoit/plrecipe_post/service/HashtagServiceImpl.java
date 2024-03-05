package com.sixcandoit.plrecipe_post.service;

import com.sixcandoit.plrecipe_post.aggregate.Post;
import com.sixcandoit.plrecipe_post.dto.HashtagDTO;
import com.sixcandoit.plrecipe_post.repository.mapper.PostMapper;
import com.sixcandoit.plrecipe_post.repository.repo.HashtagRepository;
import com.sixcandoit.plrecipe_post.vo.Hashtag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class HashtagServiceImpl implements HashtagService{

    private final ModelMapper mapper;
    private final PostMapper postMapper;
    private final HashtagRepository hashtagRepository;

    @Autowired
    public HashtagServiceImpl(ModelMapper mapper, PostMapper postMapper, HashtagRepository hashtagRepository) {
        this.mapper = mapper;
        this.postMapper = postMapper;
        this.hashtagRepository = hashtagRepository;
    }

    @Override
    public void registHashtag(HashtagDTO hashtagDTO) {


        Hashtag hashtag = mapper.map(hashtagDTO, Hashtag.class);

        hashtagRepository.save(hashtag);
    }
}
