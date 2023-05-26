package com.spring.mvc.Chap04.entity;

import jakarta.persistence.Entity;
import lombok.*;

@Getter @Setter @ToString
@AllArgsConstructor
@NoArgsConstructor
public class Score {
    private String name;    //학생이름
    private int korScore;   //국어성적
    private int engScore;   //영어성적
    private int mathScore;  //수학성적
    private int studentNum;  //학번
    private int total;  //총점
    private double average;   //평균
}
