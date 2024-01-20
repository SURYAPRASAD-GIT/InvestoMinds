package com.java.Investominds.controller;

import com.java.Investominds.repository.UserRepository;
import com.java.Investominds.service.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/users")
public class UsersController {


    @Autowired
    private UserRepository userRepository;

    @GetMapping("/accountdetails")
    public String accountDetails(@AuthenticationPrincipal LoginUser usr, Model model){
        model.addAttribute("usr",usr);
        return "accountdetails";
    }


}







































/*      @GetMapping("/all")
        public String allUsersForm(Model model)
        {

            model.addAttribute("users",userRepository.findAll());

            return "users";
        }
*/