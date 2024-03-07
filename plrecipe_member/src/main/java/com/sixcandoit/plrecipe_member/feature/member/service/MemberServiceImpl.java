package com.sixcandoit.plrecipe_member.feature.member.service;

import com.sixcandoit.plrecipe_member.feature.member.dto.MemberDTO;
import com.sixcandoit.plrecipe_member.feature.member.dto.RegisterDTO;
import com.sixcandoit.plrecipe_member.feature.member.entity.Member;
import com.sixcandoit.plrecipe_member.feature.member.repository.MemberMapper;
import com.sixcandoit.plrecipe_member.feature.member.repository.MemberRepository;
import com.sixcandoit.plrecipe_member.feature.vo.RequestMember;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class MemberServiceImpl implements MemberService {
    private final ModelMapper modelMapper;
    private final MemberMapper memberMapper;
    private final MemberRepository memberRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public MemberServiceImpl(ModelMapper mapper, MemberMapper memberMapper, MemberRepository memberRepository,
                             BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.modelMapper = mapper;
        this.memberMapper = memberMapper;
        this.memberRepository = memberRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
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
    //    ---------------------------------------------------------------
    @Override
    public List<MemberDTO> selectAllMember() {
        return memberMapper.selectAllMember();
    }
    @Override
    public MemberDTO selectMemberById(int memberId) {
        Optional<Member> userEntity = memberRepository.findById(memberId);
        MemberDTO userDTO = modelMapper.map(userEntity, MemberDTO.class);

        return userDTO;
    }
    @Override
    public List<MemberDTO> selectMemberByLikePost(int memberId) {
        return memberMapper.selectMemberByLikePost(memberId);
    }

    @Transactional
    @Override
    public void registUser(RegisterDTO registerDTO) {
//        registerDTO.setMemberEmail(UUID.randomUUID().toString());

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Member memberEntity = modelMapper.map(registerDTO, Member.class);

//        userEntity.setEncryptedPwd("암호화 된 비밀번호");
        memberEntity.setPassword(bCryptPasswordEncoder.encode(registerDTO.getPassword()));

        System.out.println("DB넣기 전 memberEntity = " + memberEntity);
        memberRepository.save(memberEntity);
    }

    @Override
    public RegisterDTO getUserDetailsByEmail(String memberEmail) {
        Member memberEntity = memberRepository.findByMemberEmail(memberEmail);

        if(memberEntity == null)
            throw new UsernameNotFoundException(memberEmail + " 아이디의 유저는 존재하지 않음");

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        RegisterDTO userDTO = modelMapper.map(memberEntity, RegisterDTO.class);

        return userDTO;
    }

    @Override
    public UserDetails loadUserByUsername(String memberEmail) throws UsernameNotFoundException {

        Member memberEntity = memberRepository.findByMemberEmail(memberEmail);

        if(memberEntity == null)
            throw new UsernameNotFoundException(memberEmail + "아이디의 유저는 존재하지 않음");

        return new User(memberEntity.getMemberEmail(), memberEntity.getPassword(),
                true, true, true, true,
                new ArrayList<>());
    }
}