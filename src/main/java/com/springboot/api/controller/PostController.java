package com.springboot.api.controller;

import com.springboot.api.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

//5.3 POST API 만들기
//POST API : 웹 애플리케이션을 통해 데이터베이스 등의 저장소에 리소스를 저장할 때 사용
//저장하고자 하는 리소스나 값을 HTTP Body에 담아 서버에 전달한다.

@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {

    //@RequestMapping으로 구현하기
    //별도의 리소스를 받지 않고 POST 요청만 받는 메서드
    @RequestMapping(value = "/domain", method = RequestMethod.POST)
    public String postExample() {
        return "Hello Post API";
    }

    //@RequestBody : HTTP의 Body 내용을 해당 어노테이션이 지정된 객체에 매핑하는 역할
    //POST 요청에서는 리소스를 담기 위해 HTTP Body에 JSON 형식으로 값을 넣어 전송한다.
    //Map 객체는 요청을 통해 어떤 값이 들어오게 될지 특정하기 어려울 때 주로 사용
    //변수 개수, 변수명, 값 모두 자유롭게 입력 가능
    //http://localhost:8080/api/v1/post-api/member
    @PostMapping(value = "/member")
    public String postMember(@RequestBody Map<String, Object> postData) {
        StringBuilder sb = new StringBuilder();

        postData.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });
        return sb.toString();
    }

    //요청 메시지에 들어갈 값이 정해져 있다면 DTO 객체를 변수로 삼아 작성할 수 있다.
    //변수명이 다르면 출력x, 변수 값을 안넣어주면 'null' 출력
    //http://localhost:8080/api/v1/post-api/member2
    @PostMapping(value = "/member2")
    public String postMemberDto(@RequestBody MemberDto memberDto) {
        return memberDto.toString();
    }

    //URL : 웹 주소
    //URI : 특정 리소스를 식별할 수 있는 식별자

}
