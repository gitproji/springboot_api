package com.springboot.api.controller;

import com.springboot.api.dto.MemberDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

//5.4 PUT API 만들기
//PUT API : 웹 애플리케이션 서버를 통해 데이터베이스 같은 저장소에 존재하는 리소스 값을 업데이트하는 데 사용
//리소스를 HTTP Body에 담아 서버에 전달한다.

@RestController
@RequestMapping("/api/v1/put-api")
public class PutController {

    //@RequestBody를 활용
    //서버에 어떤 값이 들어올지 모를 때 Map 객체 활용
    //http://localhost:8080/api/v1/put-api/member
    @PutMapping(value = "/member")
    public String postMember(@RequestBody Map<String, Object> putData) {
        StringBuilder sb = new StringBuilder();

        putData.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });
        return sb.toString();
    }


    //서버에 들어오는 요청에 담겨 있는 값이 정해져 있는 경우엔 DTO 객체 활용

    //String 타입으로 값을 전달받게 되며 DTO 객체의 toString 메서드 결과값이 출력된다.
    //http://localhost:8080/api/v1/put-api/member1
    @PutMapping (value = "/member1")
    public String postMemberDto1(@RequestBody MemberDto memberDto) {
        return memberDto.toString();
    }

    //Json 형식으로 전달
    //http://localhost:8080/api/v1/put-api/member2
    @PutMapping (value = "/member2")
    public MemberDto postMemberDto2(@RequestBody MemberDto memberDto) {
        return memberDto;
    }


    //HttpEntity 클래스 : 헤더와 바디로 구성된 HTTP 요청과 응답을 구성하는 역할을 수행
    //RequestEntity와 ResponseEntity는 HttpEntity를 상속받아 구현한 클래스

    //ResponseEntity : 서버에 들어온 요청에 대해 응답 데이터를 구성해서 전달할 수 있게 한다.
    //자체적으로 HttpStatus를 구현한다
    //이 클래스를 활용하면 응답 코드 변경은 물론 Header와 Body를 더욱 쉽게 구성할 수 있다.
    //PUT 메서드뿐만 아니라 다른 메서드에서도 모두 사용 가능

    //http://localhost:8080/api/v1/put-api/member3
    @PutMapping(value = "/member3")
    public ResponseEntity<MemberDto> postMemberDto3(@RequestBody MemberDto memberDto) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED) //이 메서드를 대상으로 요청을 수행하면 응답 코드가 202로 변경됨
                .body(memberDto);
    }
}
