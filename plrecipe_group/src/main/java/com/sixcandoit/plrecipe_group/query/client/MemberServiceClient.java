package com.sixcandoit.plrecipe_group.query.client;

import com.sixcandoit.plrecipe_group.query.vo.ResponseMember;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "plrecipe-member", url="localhost:8000")
public interface MemberServiceClient {

    @GetMapping("/plrecipe-member/select/{memberId}")
    ResponseMember getMemberInfo(@PathVariable("memberId") int memberId);
}
