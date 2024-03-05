package com.sixcandoit.plrecipe_member.feature.member.service;

import com.sixcandoit.plrecipe_member.feature.member.dto.MemberDTO;

import java.util.List;

public interface MemberService {
    List<MemberDTO> selectAllMember();
    List<MemberDTO> selectMemberByLikePost(int memberId);
}
