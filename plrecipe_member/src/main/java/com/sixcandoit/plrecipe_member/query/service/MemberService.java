package com.sixcandoit.plrecipe_member.query.service;

import com.sixcandoit.plrecipe_member.query.dto.MemberDTO;

import java.util.List;

public interface MemberService {
    List<MemberDTO> selectAllMember();

}
