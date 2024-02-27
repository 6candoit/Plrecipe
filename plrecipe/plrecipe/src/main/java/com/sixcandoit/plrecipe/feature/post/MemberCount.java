package com.sixcandoit.plrecipe.feature.post;

public enum MemberCount {
    ONE(1),
    TWO(2),
    THREE(3);

    private final int value;

    MemberCount(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
