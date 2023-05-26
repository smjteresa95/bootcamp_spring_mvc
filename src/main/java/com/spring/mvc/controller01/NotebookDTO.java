package com.spring.mvc.controller01;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data //자동으로 getter, setter, constructor 만들어준다.
public class NotebookDTO {
    //커맨드 객체 패턴으로 컨트롤러의 파라미터로 처리하는 경우
    //반드시 setter, 기본 생성자가 만들어져 있어야 작동하는데.
    //@Data annotation을 이용해 생성해둔 상태이다.
    private String modelName;   //노트북 모델명
    private int price;     //노트북 가격
    private int ssd;     //노트북 용량
    private int ram;     //노트북 램

//    @Builder
//    public NotebookDTO(String modelName, int price, int ram, int ssd){
//        this.modelName=modelName;
//        this.price=price;
//        this.ram=ram;
//        this.ssd=ssd;
//    }

    @Override
    public String toString(){
        return "model name : "+ this.modelName+", price: "+ this.price+ ", ram : " + this.ram +", ssd: "+ this.ssd;
    }


}
