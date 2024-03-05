package com.sixcandoit.plrecipe_member.feature.member.service;

import com.sixcandoit.plrecipe_member.feature.member.dto.MemberDTO;
import com.sixcandoit.plrecipe_member.feature.member.repository.MemberMapper;
import com.sixcandoit.plrecipe_member.feature.member.repository.MemberRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    private final ModelMapper mapper;
    private final MemberMapper memberMapper;
    private Environment env;

    @Autowired
    public MemberServiceImpl(ModelMapper mapper, MemberMapper memberMapper) {
        this.mapper = mapper;
        this.memberMapper = memberMapper;
    }

    @Override
    public List<MemberDTO> selectAllMember() {
        return memberMapper.selectAllMember();
    }

    @Override
    public List<MemberDTO> selectMemberByLikePost(int memberId) {
        return memberMapper.selectMemberByLikePost(memberId);
    }

}