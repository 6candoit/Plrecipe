package com.sixcandoit.plrecipe_member.command.service;

import com.sixcandoit.plrecipe_member.command.dto.MemberDTO;
import com.sixcandoit.plrecipe_member.command.dto.RegisterDTO;
import com.sixcandoit.plrecipe_member.command.aggregate.Member;
import com.sixcandoit.plrecipe_member.command.vo.RequestMember;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface CommandMemberService extends UserDetailsService {


    void registUser(RegisterDTO registerDTO);
    RegisterDTO getUserDetailsByEmail(String memberEmail);
    Member modifyMember(int memberId, RequestMember requestMember);
    Member withdrawMember(int memberId, RequestMember requestMember);

    UserDetails loadUserByUsername(String email) throws UsernameNotFoundException;
}
