package com.gogiari.myproject.user.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
    @ResponseBody
    @GetMapping("/user/edit")
    public ModelAndView editForm(String userid){
        ModelAndView mv = new ModelAndView();
        Optional<UserEntity> findUser = userRepository.findById(userid);
        UserEntity user = findUser.orElse(null);
        System.out.println(user);
        mv.addObject("user", user);
        return mv;
    }
    @PatchMapping("/user/edit")
    public ModelAndView edit(UserEntity userEntity){
        ModelAndView mv = new ModelAndView("redirect:/");
        System.out.println(userEntity);
        return mv;
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    @PostMapping("/login")
    public ModelAndView login(HttpSession session, String userid, String password) {
        ModelAndView mv = new ModelAndView("redirect:/");
        Optional<UserEntity> findUser = userRepository.findById(userid);
        UserEntity user = findUser.orElse(null);

        if( user ==  null || !user.getPassword().equals(password) ){
            mv.addObject("message", "아이디나 비밀번호를 다시 확인해주세요.");
            mv.setViewName("redirect:/login");
        } else if(user.getPassword().equals(password)){
            session.setAttribute("userid", userid);
        }
        return mv;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }
}