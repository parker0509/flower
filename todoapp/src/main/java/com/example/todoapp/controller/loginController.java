package com.example.todoapp.controller;

import com.example.todoapp.domain.User;
import com.example.todoapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor

public class loginController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {

        User user = userRepository.findByUsernameAndPassword(username,password);

        //이거 아이디찾기할떄 이렇게쓰는거아님? //

        if (user != null && user.getPassword().equals(password) && user.getUsername().equals(username)) {

            //로그인 성공
            return "redirect:/";
        } else {
            //로그인 실패
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }


    }
    /*public class isUserExist(String username){

        return userRepository.existByUsername(username);
    }*/
}
