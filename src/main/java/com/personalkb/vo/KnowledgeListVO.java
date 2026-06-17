package com.personalkb.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class KnowledgeListVO {

    private Long id;

    private Long categoryId;

    private String title;

    private LocalDateTime createTime;
}