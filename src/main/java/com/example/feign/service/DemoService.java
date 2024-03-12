package com.example.feign.service;

import com.example.feign.common.dto.BaseRequestInfo;
import com.example.feign.common.dto.BaseResopnseInfo;
import com.example.feign.feign.client.DemoFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DemoService {
    private final DemoFeignClient demoFeignClient;
    public String get() {
        ResponseEntity<BaseResopnseInfo> response = demoFeignClient.callGet("CustomHeader", "CustomName", 1L);
        System.out.println("Name : " + response.getBody().getName());
        System.out.println("Age : " + response.getBody().getAge());
        System.out.println("Header : " + response.getBody().getHeader());
        return "get";
    }

    public String post() {
        BaseRequestInfo baseRequestInfo = BaseRequestInfo.builder()
                .name("customName")
                .age(2L)
                .build();
        ResponseEntity<BaseResopnseInfo> response = demoFeignClient.callPost("CustomHeader", baseRequestInfo);
        System.out.println("Name : " + response.getBody().getName());
        System.out.println("Age : " + response.getBody().getAge());
        System.out.println("Header : " + response.getBody().getHeader());
        return "post";
    }
}
