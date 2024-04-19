package com.example.todoapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//@Spring MVC
@Controller
public class HelloController {
    @GetMapping("/")
    public String home() {

        return "home";
    }

    @GetMapping("/addTodo")
    public String addTodo() {
        return "/addTodo";
    }

    @GetMapping("/deleteTodo")
    public String deleteTodo() {
        return "/deleteTodo";
    }

    @GetMapping("/directoryTodo")
    public String directoryTodo() {
        return "/directoryTodo";
    }

/*@GetMapping("/findTodo")
    public String findTodo(){
    return "/findTodo";
}*/

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @GetMapping("/user-list")
    public String indexID(){
        return "/user-list";
    }
/*@GetMapping("/todos")
    public String indexTodo(){
    return "/todos";
}*/

}


