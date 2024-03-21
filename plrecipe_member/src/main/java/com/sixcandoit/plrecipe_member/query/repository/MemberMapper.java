package com.sixcandoit.plrecipe_member.query.repository;

import com.sixcandoit.plrecipe_member.query.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
    List<MemberDTO> selectAllMember();
    List<MemberDTO> selectMemberById(int memberId);
    List<MemberDTO> selectLikeByMemberId(int memberId);

    MemberDTO memberTest(int memberId);
}
