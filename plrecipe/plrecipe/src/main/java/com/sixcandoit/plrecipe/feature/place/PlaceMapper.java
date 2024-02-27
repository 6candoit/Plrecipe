package com.sixcandoit.plrecipe.feature.place;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PlaceMapper {
    List<PlaceDTO> selectAllPlace();

    List<PlaceDTO> selectPlaceByCategory(String categoryName);

    List<PlaceStarDTO> selectStarByPlace(int placeId);
}
