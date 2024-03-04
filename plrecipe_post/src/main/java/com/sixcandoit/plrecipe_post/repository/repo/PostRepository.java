package com.sixcandoit.plrecipe_post.repository.repo;

import com.sixcandoit.plrecipe_post.aggregate.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
