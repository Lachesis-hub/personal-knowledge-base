package com.personalkb.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Category {

    private Long id;

    private Long userId;

    private String name;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}