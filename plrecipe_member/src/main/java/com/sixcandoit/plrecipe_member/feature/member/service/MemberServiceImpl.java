package com.sixcandoit.plrecipe_member.feature.member.service;

import com.sixcandoit.plrecipe_member.feature.member.dto.MemberDTO;
import com.sixcandoit.plrecipe_member.feature.member.entity.Member;
import com.sixcandoit.plrecipe_member.feature.member.repository.MemberMapper;
import com.sixcandoit.plrecipe_member.feature.member.repository.MemberRepository;
import com.sixcandoit.plrecipe_member.feature.vo.RequestMember;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {
    private final ModelMapper mapper;
    private final MemberMapper memberMapper;
    private final MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(ModelMapper mapper, MemberMapper memberMapper, MemberRepository memberRepository) {
        this.mapper = mapper;
        this.memberMapper = memberMapper;
        this.memberRepository = memberRepository;
    }

    @Override
    public void registMember(MemberDTO memberDTO) {

        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dateTest = format.format(date);

        Member member = mapper.map(memberDTO, Member.class);
        member.setJoinDate(dateTest);

        String password = memberDTO.getPassword();
        if (!isValidPassword(password)) {
            throw new IllegalArgumentException("비밀번호는 최소 6자 이상이어야 하며, 영문 소문자, 숫자를 각각 하나 이상 포함해야 합니다.");
        }
        memberRepository.save(member);
    }

    private boolean isValidPassword(String password) {
        // 비밀번호는 최소 8자 이상, 영문 소문자, 숫자 각각 하나 이상 포함해야 함
        String regex = "^(?=.*[a-z])(?=.*\\d).{6,}$";
        return password.matches(regex);
    }
    @Override
    public Member modifyMember(int memberId, RequestMember requestMember) {

        Optional<Member> optionalMember = memberRepository.findById(memberId);
        if (!optionalMember.isPresent()) {
            throw new EntityNotFoundException("회원이 존재하지 않습니다.");
        }

        Member member = optionalMember.get();
        member.setMemberEmail(requestMember.getMemberEmail());
        member.setPassword(requestMember.getPassword());
        member.setMemberName(requestMember.getMemberName());
        member.setMemberNickname(requestMember.getMemberNickname());
        member.setMemberNumber(requestMember.getMemberNumber());

        return memberRepository.save(member);
    }

    @Override
    public Member withdrawMember(int memberId, RequestMember requestMember) {

        Optional<Member> optionalMember = memberRepository.findById(memberId);
        if (!optionalMember.isPresent()) {
            throw new EntityNotFoundException("회원이 존재하지 않습니다.");
        }
        Member member = optionalMember.get();

        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dateTest = format.format(date);

        member.setMemberStatus(requestMember.getMemberStatus());
        member.setWithdrawalDate(dateTest);

        return memberRepository.save(member);
    }

    @Override
    public List<MemberDTO> selectAllMember() {
        return memberMapper.selectAllMember();
    }
    @Override
    public MemberDTO selectMemberById(int memberId) {
        Optional<Member> userEntity = memberRepository.findById(memberId);
        MemberDTO userDTO = mapper.map(userEntity, MemberDTO.class);

        return userDTO;
    }
    @Override
    public List<MemberDTO> selectMemberByLikePost(int memberId) {
        return memberMapper.selectMemberByLikePost(memberId);
    }
}