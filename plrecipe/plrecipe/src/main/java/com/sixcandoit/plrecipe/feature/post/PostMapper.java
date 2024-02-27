package com.sixcandoit.plrecipe.feature.post;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {
    List<PostDTO> selectAllPost();
}
