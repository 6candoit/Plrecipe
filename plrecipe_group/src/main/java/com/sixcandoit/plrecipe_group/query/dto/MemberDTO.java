package com.sixcandoit.plrecipe_group.query.dto;

import com.sixcandoit.plrecipe_group.query.dto.MemberGrade;

public class MemberDTO {

    private int memberId;
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

    public MemberDTO(int memberId, String memberEmail, String password, String memberName, String memberNickname, String memberNumber, String joinDate, String withdrawalDate, MemberGrade memberGrade, String memberStatus) {
        this.memberId = memberId;
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

    public int getMemberId() {
        return memberId;
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

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public void setMemberNickname(String memberNickname) {
        this.memberNickname = memberNickname;
    }

    public void setMemberNumber(String memberNumber) {
        this.memberNumber = memberNumber;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public void setWithdrawalDate(String withdrawalDate) {
        this.withdrawalDate = withdrawalDate;
    }

    public void setMemberGrade(MemberGrade memberGrade) {
        this.memberGrade = memberGrade;
    }

    public void setMemberStatus(String memberStatus) {
        this.memberStatus = memberStatus;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "memeberId=" + memberId +
                ", memberEmail='" + memberEmail + '\'' +
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


