package com.sixcandoit.plrecipe_member.feature.member.service;

import com.sixcandoit.plrecipe_member.feature.member.dto.MemberDTO;
import com.sixcandoit.plrecipe_member.feature.member.dto.RegisterDTO;
import com.sixcandoit.plrecipe_member.feature.member.entity.Member;
import com.sixcandoit.plrecipe_member.feature.vo.RequestMember;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface MemberService extends UserDetailsService {

    List<MemberDTO> selectAllMember();
    MemberDTO selectMemberById(int memberId);
    List<MemberDTO> selectMemberByLikePost(int memberId);

    void registUser(RegisterDTO registerDTO);

    RegisterDTO getUserDetailsByEmail(String memberEmail);

    Member modifyMember(int memberId, RequestMember requestMember);
    Member withdrawMember(int memberId, RequestMember requestMember);

    UserDetails loadUserByUsername(String email) throws UsernameNotFoundException;
}
