package board.board.Controller;


import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BoardController {

    // 게시물의 목록을 보여주는 컨트롤러
    // 컨트롤러의 메소드가 리턴하는 문자열은 템플릿 이름
    // localhost:8080 ----> 에서 http로 통신 하는 컨트롤러

    @GetMapping("/")
    public String list() {
        return "list";
    }

    //board?id =3 //파라미터 id의 값은 3
    //board?id =2 //파라미터 id의 값은 2
    //board?id =1 //파라미터 id의 값은 1
    @GetMapping("/board")
    public String board(@RequestParam("id") int id) {
        System.out.println("id = " + id);
        //id에 해당하는 게시물 정보를 읽어와야한다.
        //조회수가 +1 되어야한다.

        return "board";
    }

    //글 작성
    @GetMapping("/writeForm")
    public String writeForm() {


        return "writeForm";


    }

    @PostMapping("/write")
    public String write(
            @RequestParam("title") String title,
            @RequestParam("content") String content
    ) {

        //글 작성자만 글을 수정
        // 로그인 상태로만 글 작성 가능해야함.

        System.out.println("title = " + title);
        System.out.println("content = " + content);
        return "redirect:/";
    }

    //삭제 -> 관리자는 모든 글을 삭제 가능
    //수정 -> 작성자만 작성 글을 삭제 가능


}
