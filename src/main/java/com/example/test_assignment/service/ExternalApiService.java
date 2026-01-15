package com.example.test_assignment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
@RequiredArgsConstructor
public class ExternalApiService {
    private final RestTemplate restTemplate;

    public String callExternal() {
        //String url = "https://jsonplaceholder.typicode.com/posts/1";
        String url = "https://vpic.nhtsa.dot.gov/api/vehicles/getallmanufacturers?format=json";
        return restTemplate.getForObject(url, String.class);
    }
}
