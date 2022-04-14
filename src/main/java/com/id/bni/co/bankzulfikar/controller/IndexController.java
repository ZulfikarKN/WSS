package com.id.bni.co.bankzulfikar.controller;

import com.id.bni.co.bankzulfikar.service.BankJavaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class IndexController {

    public BankJavaService bankJavaService;

    @Autowired
    public void setBankJavaService(BankJavaService bankJavaService) {
        this.bankJavaService = bankJavaService;
    }

    @GetMapping("/nasabah")
    public Map<String, Object> getIndex() {
        return bankJavaService.getNasabah();
    }
}
