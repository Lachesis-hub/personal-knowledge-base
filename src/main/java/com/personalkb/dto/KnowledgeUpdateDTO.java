package com.personalkb.dto;

import lombok.Data;

@Data
public class KnowledgeUpdateDTO {

    private Long id;

    private Long categoryId;

    private String title;

    private String content;

    private String summary;

    private String tags;
}