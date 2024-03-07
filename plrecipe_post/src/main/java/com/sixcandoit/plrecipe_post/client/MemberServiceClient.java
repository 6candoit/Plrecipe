package com.sixcandoit.plrecipe_post.client;

import com.sixcandoit.plrecipe_post.vo.member.ResponseMember;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "plrecipe-member", url = "localhost:8000")
public interface MemberServiceClient {

    @GetMapping("/plrecipe-member/searchMember/{memberId}")
   ResponseMember getMemberInfo(@PathVariable int memberId);
}
