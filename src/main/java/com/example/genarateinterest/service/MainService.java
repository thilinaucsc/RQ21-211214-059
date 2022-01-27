package com.example.genarateinterest.service;

import com.example.genarateinterest.dto.AllInterest;
import com.example.genarateinterest.dto.CommonRequest;
import com.example.genarateinterest.dto.InterestData;

import java.util.List;

public interface MainService {
    AllInterest getAllInterest();

    List<AllInterest> getCustomerInterest(CommonRequest commonRequest);

    List<InterestData> getLast10Interest(CommonRequest commonRequest);
}
