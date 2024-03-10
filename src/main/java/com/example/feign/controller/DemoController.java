package com.example.feign.controller;

import com.example.feign.service.DemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class DemoController {
    private final DemoService demoService;

    @GetMapping("/get")
    public String getController() {
        return demoService.get();
    }
}
