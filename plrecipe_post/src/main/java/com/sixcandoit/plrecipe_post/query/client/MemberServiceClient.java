package com.sixcandoit.plrecipe_post.query.client;

import com.sixcandoit.plrecipe_post.query.vo.ResponseMember;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "plrecipe-member", url = "localhost:8000")
public interface MemberServiceClient {

    /* 회원 정보를 가져온다. */
    @GetMapping("/plrecipe-member/searchMember/{memberId}")
   ResponseMember getMemberInfo(@PathVariable int memberId);
}
