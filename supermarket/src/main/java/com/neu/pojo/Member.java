package com.neu.pojo;

import java.util.Date;

public class Member {
    private Integer memberId;

    private String menberPassword;

    private String memberName;

    private String memberPhone;

    private Double sumMoney;

    private Integer memberPoint;

    private Date resignTime;

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getMenberPassword() {
        return menberPassword;
    }

    public void setMenberPassword(String menberPassword) {
        this.menberPassword = menberPassword == null ? null : menberPassword.trim();
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName == null ? null : memberName.trim();
    }

    public String getMemberPhone() {
        return memberPhone;
    }

    public void setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone == null ? null : memberPhone.trim();
    }

    public Double getSumMoney() {
        return sumMoney;
    }

    public void setSumMoney(Double sumMoney) {
        this.sumMoney = sumMoney;
    }

    public Integer getMemberPoint() {
        return memberPoint;
    }

    public void setMemberPoint(Integer memberPoint) {
        this.memberPoint = memberPoint;
    }

    public Date getResignTime() {
        return resignTime;
    }

    public void setResignTime(Date resignTime) {
        this.resignTime = resignTime;
    }
}