package com.sixcandoit.plrecipe_post.repository.repo;

import com.sixcandoit.plrecipe_post.aggregate.Post;
import com.sixcandoit.plrecipe_post.vo.Hashtag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HashtagRepository  extends JpaRepository<Hashtag, Integer> {
}
