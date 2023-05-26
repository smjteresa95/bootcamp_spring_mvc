package com.spring.mvc.Chap04.repository;

import com.spring.mvc.Chap04.entity.Score;

import java.util.*;

public class ScoreRepositoryImpl implements ScoreRepository{

    //Key: 학번, value: 성적정보
    private static final Map<Integer, Score> scoreMap;

    //학번에 사용할 일련번호, 정적변수는 0으로 자동 초기화 된다.
    private static int sequence; //primary key로 사용할 학번을 체크해주는 변수

    //정적변수를 초기화해줄 정적 블록
    static {
        scoreMap = new HashMap<>();
        Score stu1 = new Score("송민지", 100, 90, 80, ++sequence, 0, 0);
        Score stu2 = new Score("송민정", 80, 95, 60, ++sequence, 0, 0);
        Score stu3 = new Score("송현정", 80, 100, 45, ++sequence, 0, 0);

        scoreMap.put(stu1.getStudentNum(), stu1);
        scoreMap.put(stu2.getStudentNum(), stu2);
        scoreMap.put(stu3.getStudentNum(), stu3);
        System.out.println(scoreMap);
    }

    @Override
    public List<Score> findAll() {

        //비어있는 ArrayList 생성
        List<Score> scoreList = new ArrayList<>();
        for(Map.Entry<Integer, Score> entry : scoreMap.entrySet()){
            scoreList.add(entry.getValue());
        }
//        for(Score score : scoreMap.values()){
//            scoreList.add(score);
//        }
        System.out.println(scoreList);
        return scoreList;
    }

    @Override
    public boolean save(Score score) {
        //이미 존재하는 학번이면 false 리턴
        if(scoreMap.containsKey(score.getStudentNum())){
            return false;
        }
        score.setStudentNum(++sequence); //사용된 적 없는 학번 정보 setter로 추가
        scoreMap.put(score.getStudentNum(), score);

        return true;
    }

    @Override
    public boolean deleteByStudentNum(int studentNum) {

        //if메서드는 안쓰는 추세, Boolean으로 메서드 만들어서 대체한다.
        if(scoreMap.isEmpty()){
            throw new ArrayIndexOutOfBoundsException("삭제 할 학생이 없습니다.");
        }
        else if(!scoreMap.containsKey(studentNum)){
            throw new NoSuchElementException("존재하지 않는 학번입니다.");
        }

        scoreMap.remove(studentNum);

        return true;
    }

    @Override
    public Score findByStudentNum(int studentNum) {
        if(scoreMap.get(studentNum)==null){
            throw new NullPointerException("잘못된 학번입니다.");
        }
        return scoreMap.get(studentNum);
    }

    //TODO
    //update 메서드 만들기
    public Score update(Score newScore){
        //업데이트 하고자 하는 Score가 없을 때 예외처리
        if(!scoreMap.containsKey(newScore.getStudentNum()))
            throw new NullPointerException();


    }
}
