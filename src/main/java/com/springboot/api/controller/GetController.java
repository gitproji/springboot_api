package com.springboot.api.controller;

import com.springboot.api.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

//5.2 GET API 만들기
//GET API : 웹 애플리케이션 서버에서 값을 가져올 때 사용하는 API

@RestController
@RequestMapping("/api/v1/get-api") //공통 url 설정
public class GetController {

    //@RequestMapping : HTTP의 요청을 받는다.(별다른 설정 없으면 모든 요청)
    //스프링 4.3 버전 이후로 더 이상 사용x
    //http://localhost:8080/api/v1/get-api/hello
    @RequestMapping(value = "/hello", method = RequestMethod.GET) //요청형식을 GET으로만 설정
    public String getHello() {
        return "Hello World";
    }

    //매개변수가 없는 GET 메서드 구현
    //http://localhost:8080/api/v1/get-api/name
    @GetMapping(value = "/name")
    public String getName() {
        return "Flature";
    }


    //@PathVariable : 메소드 매개변수와 값을 연결해주는 기능
    //URL 자체에 값을 담아 요청한다

    //@GetMapping 어노테이션과 @PathVariable에 지정된 변수명을 동일하게 맞춰야 함.
    //http://localhost:8080/api/v1/get-api/variable1/{String 값}
    @GetMapping(value = "/variable1/{variable}") //실제 요청 시 중괄호 제외 변수명 입력
    public String getVariable1(@PathVariable String variable) {
        return variable;
    }

    //@GetMapping 어노테이션과 @PathVariable에 지정된 변수명을 동일하게 맞출 수 없을 때
    //http://localhost:8080/api/v1/get-api/variable2/{String 값}
    @GetMapping(value = "/variable2/{variable}")
    //풀어쓰면 public String getVariable2(@PathVariable(value = "variable") String var) {
    public String getVariable2(@PathVariable("variable") String var) {
        return var;
    }


    //@RequestParam : 쿼리 값과 매핑
    //쿼리스트링 : URL 주소뒤에 물음표(?)를 붙이고 key1=value1&key2=value2...방식으로 데이터를 요청

    //@RequestParam 뒤에 적는 이름과 매개변수 이름을 동일하게 설정
    //http://localhost:8080/api/v1/get-api/request1?name=value1&email=value2&organization=value3
    @GetMapping(value = "/request1")
    public String getRequestParam1(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String organization) {
        return name+" "+email+" "+organization;
    }

    //@RequestParam 뒤에 적는 이름과 매개변수 이름을 동일하게 설정할 수 없을 때
    //http://localhost:8080/api/v1/get-api/requesttest?name=value1&email=value2&organization=value3
    @GetMapping(value = "/requesttest")
    public String getRequestParamTest(
            @RequestParam("name") String n,
            @RequestParam("email") String e,
            @RequestParam("organization") String orga) {
        return n+" "+e+" "+orga;
    }

    //쿼리스트링에 어떤 값이 들어올지 모른다면 Map 객체 활용(변수 개수, 변수명, 값 모두 자유)
    //http://localhost:8080/api/v1/get-api/request2?key1=value1&key2=value2
    @GetMapping(value = "/request2")
    public String getRequestParam2(@RequestParam Map<String, String> param) {
        StringBuilder sb = new StringBuilder();

        param.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });
        return sb.toString();
    }

    //키가 정해져 있지만 받아야 할 파라미터(매개변수)가 많을 경우 DTO 객체 활용
    //http://localhost:8080/api/v1/get-api/request3?name=value1&email=value2&organization=value3
    @GetMapping(value = "/request3")
    public String getRequestParam3(MemberDto memberDto) {
        //return memberDto.getName()+" "+memberDto.getEmail()+" "+memberDto.getOrganization();
        return memberDto.toString();
    }

}
