package com.gogiari.myproject.menu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "MENU")
public class MenuEntity {

    @Id
    @Column(name = "MENU_SQL", length = 5, nullable = false)
    private int menusql;

    @Column(name = "MENU_ID", length = 6, nullable = false)
    private String menuid;
    
    @Column(name = "MENU_NAME", length = 120, nullable = false)
    private String menuname;
}
