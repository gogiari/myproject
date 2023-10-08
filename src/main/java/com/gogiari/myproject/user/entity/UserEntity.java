package com.gogiari.myproject.user.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

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
@DynamicUpdate
@DynamicInsert
@Table(name = "USER")
public class UserEntity {
    
    @Id
    @Column(name = "USERID", length = 12, nullable = false)
    private String userid;

    @Column(name = "PASSWD", length = 12, nullable = false)
    private String password;

    @Column(name = "USERNAME", length = 30, nullable = false)
    private String username;

    @Column(name = "EMAIL", length = 320)
    private String email;

    @Column(name = "INDATE")
    // @Temporal(TemporalType.TIMESTAMP)
    private Date indate;
}
