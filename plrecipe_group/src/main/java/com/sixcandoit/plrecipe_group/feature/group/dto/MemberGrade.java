package com.sixcandoit.plrecipe_group.feature.group.dto;

//public enum MemberGrade {
//
//    ROLL_MEMBER(1),
//    ROLL_ADMIN(2);
//
//    private final int value;
//
//    MemberGrade(int value) {
//        this.value = value;
//    }
//
//    public int getValue() {
//        return value;
//    }
//
//    public static MemberGrade fromValue(int value) {
//        for (MemberGrade enumValue : MemberGrade.values()) {
//            if (enumValue.getValue() == value) {
//                return enumValue;
//            }
//        }
//        throw new IllegalArgumentException("Invalid value for MyEnum: " + value);
//    }
//}


public enum MemberGrade {
    ROLL_MEMBER, ROLL_ADMIN
}
