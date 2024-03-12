package com.sixcandoit.plrecipe_place.command.vo;


public class ResponseMember {
    private int memberId;
    private String memberName;
    private String memberNickname;
    private MemberGradeVO memberGrade;

    public ResponseMember() {
    }

    public ResponseMember(int memberId, String memberName, String memberNickname, MemberGradeVO memberGrade) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.memberNickname = memberNickname;
        this.memberGrade = memberGrade;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberNickname() {
        return memberNickname;
    }

    public void setMemberNickname(String memberNickname) {
        this.memberNickname = memberNickname;
    }

    public MemberGradeVO getMemberGrade() {
        return memberGrade;
    }

    public void setMemberGrade(MemberGradeVO memberGrade) {
        this.memberGrade = memberGrade;
    }

    @Override
    public String toString() {
        return "ResponseMember{" +
                "memberId=" + memberId +
                ", memberName='" + memberName + '\'' +
                ", memberNickname='" + memberNickname + '\'' +
                ", memberGrade=" + memberGrade +
                '}';
    }
}
