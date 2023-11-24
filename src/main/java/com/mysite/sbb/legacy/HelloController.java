package com.mysite.sbb.legacy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // 컨트롤러 기능 수행, 스프링부트 프레임워크가 컨트롤러로 인식
public class HelloController {
    @GetMapping("/hello")   // /hello URL과 hello 메서드를 매핑
    @ResponseBody   // 메서드 응답결과가 문자열 그 자체
    public String hello() {
        return "Hello SBBB";
    }
}