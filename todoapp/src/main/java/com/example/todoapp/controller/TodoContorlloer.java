package com.example.todoapp.controller;

import com.example.todoapp.domain.User;
import com.example.todoapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
/*import org.springframework.security.crypto.password.PasswordEncoder;*/
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor

public class TodoContorlloer {

    private final UserRepository userRepository;
/*

    @GetMapping("/users")
    public String index(Model model){
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "users";
    }
*/

    @PostMapping("/addTodo")
    public String addTodo(@RequestParam("username") String username, @RequestParam("password") String password){


        //데이터베이스에 저장하면 될것!!
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        User existingUser = userRepository.findByUsername(username);

        if(existingUser == userRepository.existsByUsername(username)){
            System.out.println("중복 아이디입니다.");
            return "redirect:/";
        }else{
            userRepository.save(user);
        }
        return "redirect:/";
        // "/" 슬래쉬로 자동 이동해라!!
    }

    @PostMapping("/deleteTodo")
    public String deleteTodo(@RequestParam("id") Long id) {
        // 주어진 ID를 사용하여 User 객체를 찾음
        Optional<User> optionalUser = userRepository.findById(id);

        // User 객체가 존재하면 삭제
        if (optionalUser.isPresent()) {
            userRepository.deleteById(id);
        }

        // 삭제 후 "/" 경로로 리다이렉트
        return "redirect:/";
    }

    @PostMapping("/findTodo")
    public String findTodo(@RequestParam("id") Long id){
        // 주어진 ID를 사용하여 User 객체를 찾음
        Optional<User> optionalTodo = userRepository.findById(id);

        // User 객체가 존재하면 삭제
        if (optionalTodo.isPresent())
        // optionalTodo.isPresent() 는 isPresent는 객체에 값이있는지 확인하는 라이브러리
        {
            User user = optionalTodo.get();
            userRepository.findById(id);
        }

        // 삭제 후 "/" 경로로 리다이렉트
        return "redirect:/";
    }

   /* @PostMapping("/deleteTodo")
    public String deleteTodo(@RequestParam("todo") Long id){

        User todo = new User();
        userRepository.delete(todo);
        return "redirect:/";
    }*/

}
