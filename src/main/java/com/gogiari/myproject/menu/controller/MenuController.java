package com.gogiari.myproject.menu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gogiari.myproject.menu.entity.MenuEntity;
import com.gogiari.myproject.menu.repository.MenuRepository;

@Controller
public class MenuController {
    @Autowired
    MenuRepository menuRepository;

    @ResponseBody
    @GetMapping("/menu/list")
    public List<MenuEntity> list() {
        List<MenuEntity> menuList = menuRepository.findAll();
        return menuList;
    }
}
