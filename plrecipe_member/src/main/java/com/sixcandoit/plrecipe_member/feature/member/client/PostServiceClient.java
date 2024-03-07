package com.sixcandoit.plrecipe_member.feature.member.client;

import com.sixcandoit.plrecipe_member.feature.vo.ResponsePost;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name ="plrecipe-post" , url = "localhost:8000")
public interface PostServiceClient {

    @GetMapping("/plrecipe-post/posts/email/{memberId}")
    List<ResponsePost> selectMemberPosts(@PathVariable() String memberId);

}

