package com.sixcandoit.plrecipe_post.command.repositroy;

import com.sixcandoit.plrecipe_post.command.aggregate.PostHashtag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostHashtagRepository  extends JpaRepository<PostHashtag, Integer> {
}
