package com.example.demo.controller;  // 패키지는 프로젝트에 맞게 수정!

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  // 이 클래스가 컨트롤러 역할을 한다는 표시
@RequestMapping("/api")  // URL 앞에 "/api"를 자동으로 붙여줌
public class TestController {

    @GetMapping("/test")  // GET 요청이 들어오면 실행됨
    public String test() {
        return "✅ 서버 정상 실행 중!";
    }
}
