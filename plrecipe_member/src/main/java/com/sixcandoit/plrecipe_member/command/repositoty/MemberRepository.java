package com.sixcandoit.plrecipe_member.command.repositoty;

import com.sixcandoit.plrecipe_member.command.aggregate.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Integer> {
    Member findByMemberEmail(String memberEmail);
}
