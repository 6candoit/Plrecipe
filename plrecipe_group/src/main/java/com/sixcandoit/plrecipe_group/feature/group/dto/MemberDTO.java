package com.sixcandoit.plrecipe_group.feature.group.dto;

public class MemberDTO {

    private String memberEmail;
    private String password;
    private String memberName;
    private String memberNickname;
    private String memberNumber;
    private String joinDate;
    private String withdrawalDate;
    private MemberGrade memberGrade;
    private String memberStatus;

    public MemberDTO() {
    }

    public MemberDTO(String memberEmail, String password, String memberName, String memberNickname, String memberNumber, String joinDate, String withdrawalDate, MemberGrade memberGrade, String memberStatus) {
        this.memberEmail = memberEmail;
        this.password = password;
        this.memberName = memberName;
        this.memberNickname = memberNickname;
        this.memberNumber = memberNumber;
        this.joinDate = joinDate;
        this.withdrawalDate = withdrawalDate;
        this.memberGrade = memberGrade;
        this.memberStatus = memberStatus;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public String getPassword() {
        return password;
    }

    public String getMemberName() {
        return memberName;
    }

    public String getMemberNickname() {
        return memberNickname;
    }

    public String getMemberNumber() {
        return memberNumber;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public String getWithdrawalDate() {
        return withdrawalDate;
    }

    public MemberGrade getMemberGrade() {
        return memberGrade;
    }

    public String getMemberStatus() {
        return memberStatus;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "memberEmail='" + memberEmail + '\'' +
                ", password='" + password + '\'' +
                ", memberName='" + memberName + '\'' +
                ", memberNickname='" + memberNickname + '\'' +
                ", memberNumber='" + memberNumber + '\'' +
                ", joinDate='" + joinDate + '\'' +
                ", withdrawalDate='" + withdrawalDate + '\'' +
                ", memberGrade=" + memberGrade +
                ", memberStatus='" + memberStatus + '\'' +
                '}';
    }
}


