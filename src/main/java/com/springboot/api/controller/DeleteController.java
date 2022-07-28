package com.springboot.api.controller;

import org.springframework.web.bind.annotation.*;

//5.5 DELETE API 만들기
//DELETE API : 웹 애플리케이션 서버를 거쳐 데이터베이스 등의 저장소에 있는 리소스를 삭제할 때 사용

@RestController
@RequestMapping("/api/v1/delete-api")
public class DeleteController {

    //@PathVariable을 이용해 URI에 포함된 값을 받아 로직 처리
    //@DeleteMapping 어노테이션과 @PathVariable에 지정된 변수명을 동일하게 맞춰야 함.
    //http://localhost:8080/api/v1/delete-api/{String 값}
    @DeleteMapping(value = "/{variable}")
    public String DeleteVariable(@PathVariable String variable) {
        return variable;
    }

    //@RequestParam을 이용해 쿼리스트링 값을 받아 로직 처리
    //키값과 변수명이 같아야 함.
    //http://localhost:8080/api/v1/delete-api/request1?email=value
    @DeleteMapping(value = "/request1")
    public String getRequestParam1(@RequestParam String email) {
        return "e-mail : " + email;
    }
}
