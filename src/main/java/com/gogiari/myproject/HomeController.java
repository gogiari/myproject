package com.gogiari.myproject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @Value("${GG_SERVICEKEY}")
    private String servicekey;

    @RequestMapping("/")
    public ModelAndView home(){
        ModelAndView mv = new ModelAndView("home");
        mv.addObject("servicekey", servicekey);
        return mv;
    }
    
}
