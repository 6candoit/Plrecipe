package com.sixcandoit.plrecipe_post.command.service;

import com.sixcandoit.plrecipe_post.command.dto.HashtagDTO;
import com.sixcandoit.plrecipe_post.command.repositroy.HashtagRepository;
import com.sixcandoit.plrecipe_post.command.aggregate.Hashtag;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommandHashtagServiceImpl implements CommandHashtagService {

    private final ModelMapper mapper;
    private final HashtagRepository hashtagRepository;

    @Autowired
    public CommandHashtagServiceImpl(ModelMapper mapper, HashtagRepository hashtagRepository) {
        this.mapper = mapper;
        this.hashtagRepository = hashtagRepository;
    }

    @Override
    public void registHashtag(HashtagDTO hashtagDTO) {

        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Hashtag hashtag = mapper.map(hashtagDTO, Hashtag.class);

        hashtagRepository.save(hashtag);
    }


}
