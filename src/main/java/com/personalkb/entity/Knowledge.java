package com.personalkb.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Knowledge {

    private Long id;

    private Long userId;

    private Long categoryId;

    private String title;

    private String content;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}