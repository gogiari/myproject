package com.gogiari.myproject.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.gogiari.myproject.board.Repository.BoardRepository;
import com.gogiari.myproject.board.entity.BoardEntity;

@Controller
public class BoardController {
    @Autowired
    BoardRepository boardRepository;

    @GetMapping("/board/commus")
    public List<BoardEntity> commus() {
        return null;
    }
}
