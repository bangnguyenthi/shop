package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domian.User;
import com.example.demo.service.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class UserController {
    private UserService userService;
    
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String getHomePage(Model model) {
        String test=this.userService.handleHello();
        model.addAttribute("eric", test);
        model.addAttribute("controller", "from controller with model");
        return "hello"; 
    }
    @RequestMapping("/admin/user")
    public String getUserPage(Model model) {
        String test=this.userService.handleHello();
        model.addAttribute("newUser",new User());
        return "/admin/user/create"; 
    }

    @RequestMapping(value="/admin/user/create1", method = RequestMethod.POST)
    public String createUserPage(Model model,@ModelAttribute("newUser") User hoidanit) {
        System.out.println("run here"+hoidanit);
        return "hello"; 
    }

}


// @RestController
// public class UserController {
//     private UserService userService;

//     public UserController(UserService userService) {
//         this.userService = userService;
//     }

//     @GetMapping("/")
//     public String getHomePage() {
//         return this.userService.handleHello(); 
//     }

// }
