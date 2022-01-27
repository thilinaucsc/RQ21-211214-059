package com.example.genarateinterest.dto;

public class InterestData {
    private String amount;
    private String date;
    private String type;

    public InterestData(String amount, String date, String type) {
        this.amount = amount;
        this.date = date;
        this.type = type;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "InterestData{" +
                "amount='" + amount + '\'' +
                ", date='" + date + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
