package com.spring.mvc.repository;

import com.spring.mvc.Chap04.entity.Score;
import com.spring.mvc.Chap04.repository.ScoreRepository;
import com.spring.mvc.Chap04.repository.ScoreRepositoryImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class ScoreRepositoryTest {

    //테스트 대상인 ScoreRepositoryImpl 클래스를 상단에 선언해둡니다.
    ScoreRepository scoreRepository = new ScoreRepositoryImpl();

    @Test
    public void staticScoreRepositoryTest(){
        //접근제한자가 public 으로 풀려있는 동안만 실행가능하다.
//        System.out.println(ScoreRepositoryImpl.scoreMap);
//        System.out.println(ScoreRepositoryImpl.sequence);

    }

    /*
        TDD 방법
        1. 원본 클래스에 원하는 기능을 구현하지는 말고 선언만 해둔다
        2. 테스트 코드 내부에 원하는 기능대로 작성되었을 때 어떤 결과가 나올지 단언해둔다.
        3. 테스트가 통과 될 때까지 원본 클래스를 수정하면서 계속 테스트 해본다.
    */

    @Test
    public void findAllTest() {
        //GWT 패턴(AAA 패턴)
        //GIVEN - 테스트를 위해 사전에 설명해야 하는 데이터를 선언하는 구간
        //findAll은 특별한 조건없이 전체 데이터를 가져오므로 GIVEN이 없습니다.

        //WHEN - 테스트 대상 메서드를 실행하는 구간으로, 보통 한 줄로 작성한다.
        List<Score> result = scoreRepository.findAll();

        //THEN = 테스트 결과가 이렇게 나올 것이다 라는 단언을 합니다.
        //나는 result 내부에 3개의 Score가 있다고 단언한다.
        assertEquals(3, result.size());
    }

    //찾고자 하는 학번이 존재하지 않는 등의 상황에 예외처리를 해주는 경우에도 테스트 코드 짜서 예외처리가 잘 되는 지 테스트 해볼 수 있나요?

    @Test
    @DisplayName("2번 학생정보를 가져와서 비교")
    public void findByStudentNumberTest(){
        //given(2번 학생 정보가 실제정보와 일치하는지 체크할 예정
        int studentNum = 2;

        //when (2번 학생 정보를 넣어 findByStudentNumber를 호출하고, 결과는 result에 저장
        Score result = scoreRepository.findByStudentNum(studentNum);

        //then (2번 유저의 점수를 얻어왔으므로, getter로 점수 얻어와서 비교.
        assertEquals(80,result.getKorScore());
        assertEquals(95,result.getEngScore());
    }

    @Test
    @DisplayName("없는 번호로 조회시 null이어야 한다.")
    public void NotFoundByStudentNumberTest(){
        //given
        int studentNum = 99;
        //when
        Score score = scoreRepository.findByStudentNum(studentNum);
        //then
        assertNull(score);
    }

    @Test
    public void saveTest(){
        //given
        Score score = new Score();
        score.setName("이영미");
        score.setKorScore(95);
        score.setEngScore(50);
        score.setMathScore(70);

        //when
        boolean boolResult = scoreRepository.save(score);
        List<Score> result = scoreRepository.findAll();

        //then
        assertTrue(boolResult);
        assertEquals(4, result.size());

    }

    @Test
    public void deleteByStudentNumberTest(){
        //given (2번 학생 삭제)
        int studentNum = 2;

//        //모두 삭제한 경우
//        for(int i=1; i<=3;i++){
//            scoreRepository.deleteByStudentNum(i);
//        }

        //when
        scoreRepository.deleteByStudentNum(studentNum);

        //then
        assertEquals(2, scoreRepository.findAll().size());
    }
}
