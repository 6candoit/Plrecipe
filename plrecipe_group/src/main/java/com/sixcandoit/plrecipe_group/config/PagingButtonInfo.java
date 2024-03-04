package com.sixcandoit.plrecipe_group.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

//@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class PagingButtonInfo {
    private int currentPage;
    private int startPage;
    private int endPage;

    public PagingButtonInfo(int currentPage, int startPage, int endPage) {
        this.currentPage = currentPage;
        this.startPage = startPage;
        this.endPage = endPage;
    }
}
