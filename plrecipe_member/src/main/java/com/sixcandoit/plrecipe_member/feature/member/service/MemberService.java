package com.sixcandoit.plrecipe_member.feature.member.service;

import com.sixcandoit.plrecipe_member.feature.member.dto.MemberDTO;
import com.sixcandoit.plrecipe_member.feature.member.entity.Member;

import java.util.List;

public interface MemberService {

    MemberDTO findMemberById(int memberId);

    void modifyMember(MemberDTO modifyMember);

    List<MemberDTO> selectAllMember();

    List<MemberDTO> selectMemberByLikePost(int memberId);

    String selectMemberById(int memberId);

    void registMember(MemberDTO memberDTO);
}
