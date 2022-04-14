package com.id.bni.co.bankzulfikar.service;


import com.id.bni.co.bankzulfikar.domain.Nasabah;
import com.id.bni.co.bankzulfikar.repository.BankJavaRepository;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Configurable(preConstruction = true, autowire = Autowire.BY_NAME)
public class BankJavaServiceImplementation implements BankJavaService{

    private BankJavaRepository bankJavaRepository;

    @Autowired
    public BankJavaServiceImplementation(BankJavaRepository bankJavaRepository) {
        this.bankJavaRepository = bankJavaRepository;
    }

    @Qualifier
    private RestTemplate restTemplate = new RestTemplate();

    @Override
    @Transactional
    public Map<String, Object> getNasabah() {
        Map<String, Object> response = new HashMap<>();
        try {
            List<Nasabah> nasabahList = bankJavaRepository.getAllNasabah();
            if (nasabahList.isEmpty()) {
                response.put("message", "List is Empty");
                response.put("statusCode", "02");
                response.put("status", "list is Empty");
                return response;
            }
            response = formatResponse(nasabahList);
        } catch (Exception e) {
            response = new HashMap<>();
            response.put("message", e.getMessage());
            response.put("statusCode", "01");
            response.put("status", "Error");
        }
        return response;
    }
    public Map<String, Object> formatResponse(List<Nasabah> nasabahList) {
        Map<String, Object> result = new HashMap<>();
        result.put("statusCode", "00");
        result.put("data", nasabahList);
        result.put("message", "success");
        return result;
    }
}
