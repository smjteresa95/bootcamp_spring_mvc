package com.spring.mvc.controller01;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class memberDTO {
    private Long id;
    private Long mNo;
    private String mName;

    @Override
    public String toString(){
        return "멤버이름: " + this.mName + ", 멤버번호: "+ mNo;
    }
}
