package com.hgicreate.rno.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by chao.xj on 2017/5/27.
 */
@Entity
@Data
@Table(name = "userinfo")
public class UserInfo  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Integer age;

}
