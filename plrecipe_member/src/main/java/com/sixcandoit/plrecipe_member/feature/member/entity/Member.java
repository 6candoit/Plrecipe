package com.sixcandoit.plrecipe_member.feature.member.entity;

import com.sixcandoit.plrecipe_member.feature.member.dto.MemberGrade;

public class Member {

    private String memberEmail;
    private String password;
    private String memberName;
    private String memberNickname;
    private String memberNumber;
    private String joinDate;
    private String withdrawalDate;
    private MemberGrade memberGrade;

    private String memberStatus;

    public Member() {
    }

    public Member(String memberEmail, String password, String memberName, String memberNickname, String memberNumber, String joinDate, String withdrawalDate, MemberGrade memberGrade, String memberStatus) {
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

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getMemberNumber() {
        return memberNumber;
    }

    public void setMemberNumber(String memberNumber) {
        this.memberNumber = memberNumber;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public String getWithdrawalDate() {
        return withdrawalDate;
    }

    public void setWithdrawalDate(String withdrawalDate) {
        this.withdrawalDate = withdrawalDate;
    }

    public MemberGrade getMemberGrade() {
        return memberGrade;
    }

    public void setMemberGrade(MemberGrade memberGrade) {
        this.memberGrade = memberGrade;
    }

    public String getMemberStatus() {
        return memberStatus;
    }

    public void setMemberStatus(String memberStatus) {
        this.memberStatus = memberStatus;
    }

    @Override
    public String toString() {
        return "Member{" +
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
