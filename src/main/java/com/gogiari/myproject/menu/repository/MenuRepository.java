package com.gogiari.myproject.menu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gogiari.myproject.menu.entity.MenuEntity;

public interface MenuRepository extends JpaRepository<MenuEntity, Integer> {

}
