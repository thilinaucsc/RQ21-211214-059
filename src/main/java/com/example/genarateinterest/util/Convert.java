package com.example.genarateinterest.util;

import java.math.BigDecimal;

public class Convert {
    public String stringSubtract(String largeNo, String smallNo) {
        return (new BigDecimal(largeNo).subtract(new BigDecimal(smallNo)).toString());
    }

    public String stringAdd(String largeNo, String smallNo) {
        return (new BigDecimal(largeNo).add(new BigDecimal(smallNo)).toString());
    }

    public int stringCompare(String firstString, String secondString) {
        return (new BigDecimal(firstString).compareTo(new BigDecimal(secondString)));
    }

    public String stringDivide(String largeNo, String smallNo) {
        String value = largeNo;
        try {
            if (!(smallNo.equalsIgnoreCase("0") || smallNo.equalsIgnoreCase(""))) {
                value = new BigDecimal(largeNo).divide(new BigDecimal(smallNo)).toString();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return value;
    }

    public String stringMultiply(String largeNo, String smallNo) {
        return (new BigDecimal(largeNo).multiply(new BigDecimal(smallNo)).toString());
    }

    public String stringPercentage(String largeNo, String smallNo) {
        String value = "100";
        try {
            value = (new BigDecimal(largeNo).multiply(new BigDecimal("100"))).divide(new BigDecimal(smallNo)).toString();
        } catch (Exception e) {
            System.out.println("stringPercentage : " + e.getMessage());
        }
        return value;
    }
}
