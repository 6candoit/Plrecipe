package com.sixcandoit.plrecipe_member.repository.mapper;

import com.sixcandoit.plrecipe_member.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {

    List<MemberDTO> selectAllMember();

    List<MemberDTO> selectMemberByLikePost(String memberEmail);


}
