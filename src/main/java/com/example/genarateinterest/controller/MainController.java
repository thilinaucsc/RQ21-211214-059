package com.example.genarateinterest.controller;

import com.example.genarateinterest.dto.CommonRequest;
import com.example.genarateinterest.service.MainService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/data")
public class MainController {
    private final MainService mainService;

    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping("/getAllInterest")
    public ResponseEntity<?> getAllInterest() {
        return ResponseEntity.ok(mainService.getAllInterest());
    }

    @PostMapping("/getCustomerInterest")
    public ResponseEntity<?> getCustomerInterest(@RequestBody CommonRequest commonRequest) {
        return ResponseEntity.ok(mainService.getCustomerInterest(commonRequest));
    }

    @PostMapping("/getLast10Interest")
    public ResponseEntity<?> getLast10Interest(@RequestBody CommonRequest commonRequest) {
        return ResponseEntity.ok(mainService.getLast10Interest(commonRequest));
    }
}
