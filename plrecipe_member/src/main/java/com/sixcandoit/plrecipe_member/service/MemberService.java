package com.sixcandoit.plrecipe_member.service;

import com.sixcandoit.plrecipe_member.dto.MemberDTO;
import com.sixcandoit.plrecipe_member.repository.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private MemberMapper memberMapper;

    @Autowired
    public MemberService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    public List<MemberDTO> selectAllMember() {
        return memberMapper.selectAllMember();
    }

    public List<MemberDTO> selectMemberByLikePost(String memberEmail) {
        return memberMapper.selectMemberByLikePost(memberEmail);
    }

}
