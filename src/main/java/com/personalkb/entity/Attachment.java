package com.personalkb.entity;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class Attachment {

    private Long id;

    private Long userId;

    private Long knowledgeId;

    private String fileName;

    private String filePath;

    private Long fileSize;

    private LocalDateTime createTime;
}