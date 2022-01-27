package com.example.genarateinterest.dto;

public class AllInterest {
    private String interest;
    private String accountNo;

    public AllInterest(String interest) {
        this.interest = interest;
    }

    public AllInterest(String interest, String accountNo) {
        this.interest = interest;
        this.accountNo = accountNo;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    @Override
    public String toString() {
        return "AllInterest{" +
                "interest='" + interest + '\'' +
                ", accountNo='" + accountNo + '\'' +
                '}';
    }
}
