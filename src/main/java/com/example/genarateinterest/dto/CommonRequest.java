package com.example.genarateinterest.dto;

public class CommonRequest {
    private String accountNo;
    private String customerId;

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "CommonRequest{" +
                "accountNo='" + accountNo + '\'' +
                ", customerId='" + customerId + '\'' +
                '}';
    }
}
