package com.gogiari.myproject.user.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gogiari.myproject.user.entity.UserEntity;
import com.gogiari.myproject.user.repository.UserRepository;

@Controller
public class UserController {
    @Autowired
    UserRepository userRepository;
    
    @RequestMapping("/user/list")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView("user/list");
        List<UserEntity> userList = userRepository.findAll(Sort.by(Sort.Direction.ASC, "indate"));
        // System.out.println(userList);
        mv.addObject("userList", userList);
        return mv;
    }

    @GetMapping("/user/signUp")
    public ModelAndView signUpForm() {
        ModelAndView mv = new ModelAndView("user/signUp");
        return mv;
    }

    @PostMapping("/user/signUp")
    public ModelAndView signUp(UserEntity userEntity) {
        ModelAndView mv = new ModelAndView("redirect:/");
        userEntity.setIndate(new Date());
        // System.out.println(userEntity);
        userRepository.save(userEntity);
        
        return mv;
    }
}