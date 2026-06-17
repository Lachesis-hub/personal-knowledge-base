package com.personalkb.dto;

import lombok.Data;

@Data
public class KnowledgeAddDTO {

    private Long categoryId;

    private String title;

    private String content;
}