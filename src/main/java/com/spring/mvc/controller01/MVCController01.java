package com.spring.mvc.controller01;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller("/chap01") // 해당 어노테이션이 있어야, 스프링 코어가 관리하는 컨트롤러가 됨.
public class MVCController01 {

    // 특정 주소로 접속했을때 처리할 로직을 작성합니다.
    @RequestMapping("/hello") // localhost:8080이 기본주소이고, 뒤에 /hello를 붙여 접속시 실행
      //spring 3 버전까지 쓰던 방법                    배열로 나열시 2개 이상 메서드 허용가능
//    @RequestMapping(value = "/hello", method = {RequestMethod.GET, RequestMethod.POST})
    public String hello(){
        System.out.println("/hello 접속 감지!!!!!!");
        // 어떤 .jsp파일과 연동할지 return구문에 문자열로 파일이름을 적어줌
        // prefix였던 /WEB-INF/views와 suffix였던 .jsp를 앞뒤로 붙여서
        // 최종적으로 열리는 파일은 /WEB-INF/views/hello.jsp
        return "hello";
    }

    @RequestMapping("/abc")
    public String world(){
        System.out.println("주소와 jsp 파일이름이 달라도 문제되지 않아");
        //def.jsp 출력
        return "def";
    }

    //html의 get 방식요청만 허용하는 어노테이션
    @GetMapping("/getreq") //localhost:8080/getreq 접속허용
    public String getReq(){
        System.out.println("get 방식요청을 감지했습니다. ");
        return "reqview";
    }

    //html의 post 방식요청만 허용하는 어노테이션
    @PostMapping("/postreq") //localhost:8080/postreq 접속허용
    public String postReq(){
        System.out.println("post 방식요청을 감지했습니다. ");
        return "reqview";
    }

    //요청은 달라도 결과페이지는 같을 수 있다.

    /*
       요청 파라미터 읽어오기(Query String = GET 방식, RequestBody = POST 방식)\
       1. HttpSevletRequest 사용하기(원시적인 JSP에서 쓰는 방법)
       /person?name=kim&age=30
    */

    //http://localhost:8080/person?name=minjee&age=29
    //이런식으로 url에 입력이 되었을 때 콘솔창에 값이 뜬다.
    @RequestMapping("/person")
    public String person(HttpServletRequest request){
        //http전송 방식에서는 모든 파라미터의 자료형이 문자로 통일 됩니다. 그래서 나이도 문자로 받습니다.
        //request.getParameter: java 와 http 동작방식이 다르다. http 데이터를 java 데이터로 바꿔주기 위해서 이 메서드를 사용하는 것.
        String name = request.getParameter("name");
        String age = request.getParameter("age");

        System.out.println("name 파라미터 전송값: "+name);
        System.out.println("age 파라미터 전송값: "+ age);

        return "http요청";
    }

    //@RequestParam 사용하기
    //major?scu=Song&major=informationcommunication&gpa=3.0
    //메서드 선언부에 파라미터와 자료형을 입력하고, 왼쪽에 @RequestParam("가져올 변수명") 입력

    @RequestMapping("/major")
    //자료형을 자동으로 바꿔준다.
    public String major(String univ,
                        @RequestParam(defaultValue = "0.0")double gpa,
                        @RequestParam("major") String 전공)
    //RequestParam은 url에 뜨는 변수명과 로직 안의 변수명을 다르게 하고싶을 때 쓸 수 있다.
    //(@RequestParam("major") String major, @RequestParam("gpa") int gpa)

    // 파라미터가 따로 입력이 안된 경우 에러가 뜨므로, default값 지정 가능하다.
    // @RequestParam("gpa", defaultValue = "0.0")
    {
        System.out.println("univ 파라미터에 저장된 값: " + univ);
        System.out.println("gpa 파라미터에 저장된 값: " + gpa);
        System.out.println("gpa가 만점에서 몇 점 모자란지 " + Math.ceil(4.5-gpa));
        System.out.println("major 파라미터에 저장 된 값: " + 전공);

        return "";
    }

    /*
        커맨드 객체 이용하기
        연관된 자료를 한 번에 처리해야 하는 경우 외부에 class를 하나 만들고,
        그 클래스를 파라미터로 주면 외부 클래스의 내부 멤버변수명이 전부 매핑되어 주입됨.
    */

    @RequestMapping("notebook") //notebookDTO의 멤버변수명칭으로 들어오는 파라미터를 자동 대입

                        //modelName, price, ram, ssd 멤버변수명칭으로 들어오는 것을 받아준다.
    public String notebook(NotebookDTO notebook){

        System.out.println("파라미터로 전달받은 NotebookDTO의 내부: "+ notebook.toString());
        return "";
    }

    @RequestMapping("/employee")
    public String employee(EmployeeDTO employee){
        System.out.println(employee.toString());
        return "";
    }

    /*
        4. URL에 경로로 붙어있는 데이터 읽어오기
        /board/103
        게시판의 103번 글을 읽고 싶음
    * */

    @RequestMapping("/board/{bNo}")  //패턴과 동일한 이름의 변수를 파라미터 선언부에 선언 후
    public String board(@PathVariable int bNo){ //왼쪽 @PathVariable을 붙여준다.
        System.out.println("경로로 받아온 bNo의 값: " + bNo);
        return "";
    }

    /*
        /member/회원이름/회원번호
        패턴으로 param처리하도록 만들어 주세요
        회원 이름은 mName, 회원 번호는 mNo명칭을 사용합니다.
    */

    //http://localhost:8080/member/minjee/29
    @RequestMapping("/member/{mName}/{mNo}")
    public String member(@PathVariable String mName, @PathVariable Long mNo){
        System.out.println("멤버이름: " + mName);
        System.out.println("멤버번호: " + mNo);
        return "";
    }

    //데이터를 보낼 때는 URL에 직접 파라미터를 붙여서 보내게 하는 대신
    //당연히 form이라는 양식을 제공하고,
    //거기에 대해서 적절한 처리를 하는 처리 메서드를 만들게 됩니다.
    @GetMapping("/catform")
    public String catForm(){
        System.out.println("고양이를 등록할 수 있는 형식으로 연결 해드립니다.");
        //파일명 앞에 /를 붙이면 폴더 지정도 할 수 있다.
        // WEB-INF/views/chap01/catform.jsp
        return "/chap01/catform";
    }

    //catform 에서 보낸 데이터를 처리해주는 페이지 생성
//    @GetMapping("/cat") //GET method를 쓰면 url에 info붙어서 나온다.
    @PostMapping("/cat") //post로 하면 url에 인포가 붙어 나오지 않고 RequestBody에 붙어 보내진다.(콘솔창에 뜸)
    public String cat(String name, int age, String breed){
        System.out.println("등록할 고양이 이름: "+name);
        System.out.println("등록할 고양이 나이: "+ age);
        System.out.println("등록할 고양이 품종: "+ breed);
        //chap01 폴더 내부의 catreg.jsp로 연결되도록 해주세요
        return "/chap01/catreg";
    }

    //아이디, 비밀번호를 각각 id pw라는 name에 실어서 전달해주는 폼을 생성해주세요
    //chap01 폴더 내에 loginform.jsp로 지정해주세요
    @RequestMapping("/loginform")
    public String loginForm(){
        System.out.println("로그인 폼으로 연결");
        return "/chap01/loginform";
    }

    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String login(String id, String pw){
        System.out.println("id: " +id);
        System.out.println("pw: " +pw);
        return "/chap01/login";
    }
}
