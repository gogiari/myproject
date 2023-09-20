package com.gogiari.myproject.board.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gogiari.myproject.board.entity.BoardEntity;

public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {

}
