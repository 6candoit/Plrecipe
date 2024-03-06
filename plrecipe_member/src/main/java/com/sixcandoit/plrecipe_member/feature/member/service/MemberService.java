package com.sixcandoit.plrecipe_member.feature.member.service;

import com.sixcandoit.plrecipe_member.feature.member.dto.MemberDTO;
import com.sixcandoit.plrecipe_member.feature.member.entity.Member;
import com.sixcandoit.plrecipe_member.feature.vo.RequestMember;

import java.util.List;

public interface MemberService {

    List<MemberDTO> selectAllMember();
    MemberDTO selectMemberById(int memberId);
    List<MemberDTO> selectMemberByLikePost(int memberId);
    void registMember(MemberDTO memberDTO);
    Member modifyMember(int memberId, RequestMember requestMember);
    Member withdrawMember(int memberId, RequestMember requestMember);

}
