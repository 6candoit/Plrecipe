package com.sixcandoit.plrecipe_post.query.aggregate;

public enum MemberCount {
    ONE(1),
    TWO(2),
    MANY(3);

    private final int value;

    MemberCount(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static MemberCount fromValue(int value) {
        for (MemberCount enumValue : MemberCount.values()) {
            if (enumValue.getValue() == value) {
                return enumValue;
            }
        }
        throw new IllegalArgumentException("Invalid value for MyEnum: " + value);
    }
}
