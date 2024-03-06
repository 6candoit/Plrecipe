package com.sixcandoit.plrecipe_post.repository.repo;

import com.sixcandoit.plrecipe_post.aggregate.Post;
import com.sixcandoit.plrecipe_post.vo.PostHashtag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostHashtagRepository  extends JpaRepository<PostHashtag, Integer> {
}
