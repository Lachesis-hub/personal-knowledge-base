package com.personalkb.service;


import com.personalkb.entity.Attachment;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface AttachmentService {


    void upload(
            MultipartFile file,
            Long knowledgeId
    );


    List<Attachment> list();


    void delete(
            Long id
    );

    void download(
            Long id,
            HttpServletResponse response
    ) throws Exception;

}