package com.example.feign.feign.client;

import com.example.feign.common.dto.BaseRequestInfo;
import com.example.feign.common.dto.BaseResponseInfo;
import com.example.feign.feign.config.DemoFeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name = "demo-client",
        url = "${feign.url.prefix}",
        configuration = DemoFeignConfig.class
)
public interface DemoFeignClient {
    @GetMapping("/get") //-> http://localhost:8080/target_server/get
    ResponseEntity<BaseResponseInfo> callGet(@RequestHeader("CustomHeaderName") String customHeader,
                                             @RequestParam("name") String name,
                                             @RequestParam("age") Long age);

    @GetMapping("/post") //-> http://localhost:8080/target_server/post
    ResponseEntity<BaseResponseInfo> callPost(@RequestHeader("CustomHeaderName") String customHeader,
                                              @RequestBody BaseRequestInfo baseRequestInfo);

    @GetMapping("/error") //-> http://localhost:8080/target_server/post
    ResponseEntity<BaseResponseInfo> callErrorDecoder();
}
