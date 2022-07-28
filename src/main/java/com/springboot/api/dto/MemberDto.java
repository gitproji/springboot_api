package com.springboot.api.dto;

//DTO(Data Transfer Object) : 각 클래스 및 인터페이스를 호출하면서 전달하는 매개변수로 사용되는 데이터 객체
//다른 레이어 간의 데이터 교환에 활용된다.

public class MemberDto {
    //필드는 컨트롤러의 메서드에서 쿼리 파라미터의 키와 매핑된다
    private String name;
    private String email;
    private String organization;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    @Override
    public String toString() {
        return "MemberDto{"+"name='"+name+'\''+", email='"+email+'\''+", organization='"+organization+'\''+'}';
    }
}
