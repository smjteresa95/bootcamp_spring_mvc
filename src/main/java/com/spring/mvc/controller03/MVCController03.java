package com.spring.mvc.controller03;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/chap03")
public class MVCController03 {
    @RequestMapping("/form")
    public String getOrder(Model model){
        System.out.println("주문서 내보냅니다.");
        List<String> meunList = List.of("짜장면", "간짜장", "짬뽕", "소고기짬뽕", "탕수육");
        // /WEB-INF/views/chap03/foodform.jsp
        model.addAttribute("menuList", meunList);
        return "chap03/foodform";
    }

    @PostMapping ("/order")
    public ModelAndView orderReceived(String name, String tableNum, String menu){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("chap03/foodresult");

        mv.addObject("name",name);
        mv.addObject("tableNum", tableNum);
        mv.addObject("menuList", menu);

        return mv;
    }

    @RequestMapping("/naver")
    public String naver(){
        //redirect는 "redirect:보낼 주소; 형식으로 문자를 작성하면 실행됩니다.
        //마치 a 태그를 클릭하는 것 처럼 자동으로 페이지를 보낼 주소로 이동시킵니다.
        //이 과정에서 포워딩과는 달리 model.addAttribute()처럼 자료를 첨부해 이동시킬 수는 없습니다.
        //하지만 get 방식으로 이동하는 만큼 쿼리스트링을 붙여서 보내는 것은 가능합니다
        return "redirect:https://www.naver.com";
    }

    @RequestMapping("/goFoodform")
    public String goFoodForm(Model model){
        //리다이렉션은 model.addAttribute()를 통한 데이터 전송이 불가능 합니다.
        model.addAttribute("title", "음식 주문 키오스크"); //test라는 이름으로 "test"문자열 적재

        //return " redirect:/chap03/form"; //redirect: 재요청을 넣는다. 목적파일로 포워딩하지 않고 목적 메서드 주소로 리다이렉트
        //redirect는 정보 전달이 안된다. "http://localhost:8080/chap03/form"의 주소를 찾아가는 것

        return "/chap03/foodform"; //forward: 요청의 연속적인 동작. 목적 파일인 foodform.jps로 적재테이터도 보내는 포워딩 방식
        //forwarding 방식은 특정 파일을 찾는다. 목적 파일인 foodform.jsp로 적재 데이터도 보낸다.
    }

    //redirect는 데이터 전달이 불가능한가요?
    //GET방식에서만 할 수 있다. POST 방식으로는 안된다.
    //GET 방식을 url에 쿼리스트링을 붙여서 데이터를 전송하기때문에
    //리다이렉트 타겟 URL에 쿼리스트링을 붙여 리다이렉트를 수행하면 전달 가능합니다.
    @RequestMapping("search")
    public String searchForm(){
        return "/chap03/searchform";
    }

    //네이버 쿼리를 받아서 리다이렉션 해주는 메서드 세팅
    @RequestMapping("research")
    public String reSearch(String query){
        String resultPage = "redirect:https://search.naver.com/search.naver?query=" + query;
        return resultPage;
    }


}
