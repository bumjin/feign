package com.example.feign.controller;

import com.example.feign.common.dto.BaseRequestInfo;
import com.example.feign.common.dto.BaseResopnseInfo;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/target_server")
public class TargetController {

    @GetMapping("/get")
    public BaseResopnseInfo demoGet(@RequestHeader("CustomHeaderName") String header,
                                    @RequestParam("name") String name,
                                    @RequestParam("age") Long age) {
        return BaseResopnseInfo.builder()
                .header(header)
                .name(name + " from target server")
                .age(age)
                .build();
    }

    @PostMapping("/post")
    public BaseResopnseInfo demoPost(@RequestHeader("CustomHeaderName") String header,
                                     @RequestBody BaseRequestInfo body) {
        return BaseResopnseInfo.builder()
                .header(header)
                .name(body.getName())
                .age(body.getAge())
                .build();
    }

}
