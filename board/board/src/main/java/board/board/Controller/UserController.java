package board.board.Controller;

import board.board.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor

public class UserController {

    private final UserService userService;

    @GetMapping("/userRegForm")
    public String userRegForm() {
        return "userRegForm";
    }

    @GetMapping("/loginform")
    public String loginform() {
        return "loginform";
    }

    @PostMapping("/login")
    public String login(
            @RequestParam("email") String email,
            @RequestParam("password") String password) {
        System.out.println("email = " + email);
        System.out.println("password = " + password);
        return "redirect:/";
    }

    @PostMapping("/userReg")
    public String userReg(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("password") String password
    ) {

        System.out.println("name = " + name);
        System.out.println("email = " + email);
        System.out.println("password = " + password);

        userService.addUser(name,email,password);

        return "redirect:/welcome";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "welcome";
    }


    @GetMapping("logout")
    public String logout() {
        return "redirect:/";
    }


}
