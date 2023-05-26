package com.spring.mvc.Chap04.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

    /*
        학생의 성적정보를 조회, 등록, 삭제 할 수 있는 시스템을 만들어보겠습니다.
        <요청 URL의 종류>
        1.학생 성적정보등록화면을 보여주고, 성적정보 목록조회를 처리
        /score/list : GET
        2 성적정보 등록처리 요청
        /score/register: POST
        3. 성적정보 삭체
        /score/remove: POST
        4. 성적정보상세
        /score/detail: GET
     */

//DB 변경이 생기는 것은 POST, DB변경이 생기지 않는 방식은 GET

@Controller("/score")
public class ScoreController {

    //1. 성적등록화면 띄우기 + 정보목록조회
    @RequestMapping(value = "/list", method = RequestMethod.GET )
    public String list(){
        System.out.println("/score/list: GET 방식");
        return "";
    }

    //2. 성적정보 등록처리 요청
    @PostMapping("/register")
    public String register(){
        System.out.println("/score/register: POST 방식");
        return "";
    }

    //3. 성적정보 삭체
    @PostMapping("/remove")
    public String remove(){
        System.out.println("/score/remove: POST 방식");
        return "";
    }

    //4. 성적정보상세
    @GetMapping("/detail")
    public String detail(){
        System.out.println("/score/detail: GET방식");
        return "";
    }







}
