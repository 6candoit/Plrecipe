package com.sixcandoit.plrecipe_post.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class PagingButtonInfo {
    private int currentPage;
    private int startPage;
    private int endPage;
}
