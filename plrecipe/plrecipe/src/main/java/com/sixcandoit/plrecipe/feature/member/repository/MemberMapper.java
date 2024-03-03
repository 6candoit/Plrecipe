package com.sixcandoit.plrecipe.feature.member.repository;
import com.sixcandoit.plrecipe.feature.member.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
    List<MemberDTO> selectAllMember();

    List<MemberDTO> selectMemberByLikePost(String memberEmail);
}
