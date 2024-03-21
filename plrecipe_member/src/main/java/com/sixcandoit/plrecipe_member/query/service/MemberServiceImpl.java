package com.sixcandoit.plrecipe_member.query.service;

import com.sixcandoit.plrecipe_member.query.dto.MemberDTO;
import com.sixcandoit.plrecipe_member.query.repository.MemberMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService{
    private final ModelMapper modelMapper;
    private final MemberMapper memberMapper;

    @Autowired
    public MemberServiceImpl(ModelMapper modelMapper, MemberMapper memberMapper) {
        this.modelMapper = modelMapper;
        this.memberMapper = memberMapper;
    }

    @Override
    public List<MemberDTO> selectAllMember() {
        return memberMapper.selectAllMember();
    }

    @Override
    public List<MemberDTO> selectMemberById(int memberId) {
        return memberMapper.selectMemberById(memberId);
    }

    @Override
    public List<MemberDTO> selectLikeByMemberId(int memberId) {
        return memberMapper.selectLikeByMemberId(memberId);
    }

    @Override
    public MemberDTO memberTest(int memberId) {
        return memberMapper.memberTest(memberId);
    }
}
