package com.spring.mvc.Chap04.repository;

import com.spring.mvc.Chap04.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
/*
    역할 명세(추상화)
    1. 전체 성적 조회
    2. 개별 성적 조회
    3. 성적 삭제
    4. 성적 등록
*/


public interface ScoreRepository{
    //성적을 어떻게 받아올 것인가
    //entity계층에 score라는 정보가 어떻게 구성되는 지 먼저 정의하고
    //score 객체에 담아와서 처리
    //특정한 테이블에 있는 값을 가지고 와야 할 것.

    //하나의 score 객체는 DB 테이블의 한 row의 정보만 담을 수 있다.
    public List<Score> findAll();

    //등록하는 것은 return 자료형은 필요없고 등록 성공여부만 반환한다.
    //입력 할 테이블 정보를 넘겨준다.
    public boolean save(Score score);

    //성적 정보 한개 삭제
    public boolean deleteByStudentNum(int studentNum);

    //개별 성적조회
    public Score findByStudentNum(int studentNum);

}
