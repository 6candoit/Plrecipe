package com.sixcandoit.plrecipe_post.command.repositroy;

import com.sixcandoit.plrecipe_post.command.aggregate.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
    Post findByMemberId(Integer integer);
}
