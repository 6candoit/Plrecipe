package com.sixcandoit.plrecipe_member.feature.member.repository;

import com.sixcandoit.plrecipe_member.feature.member.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {

    List<MemberDTO> selectAllMember();
    List<MemberDTO> selectMemberByLikePost(int memberId);
//    MemberDTO selectMemberById();

}
