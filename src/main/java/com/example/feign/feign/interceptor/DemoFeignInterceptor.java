package com.example.feign.feign.interceptor;

import feign.Request;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.nio.charset.StandardCharsets;

@RequiredArgsConstructor(staticName = "of")
public class DemoFeignInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate template) {

        // get 요청일 경우
        if (template.method() == Request.HttpMethod.GET.name()) {
            System.out.println("[GET] [DemoFeignInterceptor] queries : " + template.queries());
            return;
        }

        //post 요청일 경우
        String encodedString = StringUtils.toEncodedString(template.body(), StandardCharsets.UTF_8);
        System.out.println("[POST] [DemoFeignInterceptor] requestBody : " + encodedString);

        // 추가적으로 본인이 필요한 로직을 추가
        String convertRequestBody = encodedString;

        template.body(convertRequestBody);

    }
}
