package com.sixcandoit.plrecipe_post.query.vo;

public enum MemberGradeVO {

    ROLL_MEMBER(1),
    ROLL_ADMIN(2);

    private final int value;

    MemberGradeVO(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static MemberGradeVO fromValue(int value) {
        for (MemberGradeVO enumValue : MemberGradeVO.values()) {
            if (enumValue.getValue() == value) {
                return enumValue;
            }
        }
        throw new IllegalArgumentException("Invalid value for MyEnum: " + value);
    }

}
