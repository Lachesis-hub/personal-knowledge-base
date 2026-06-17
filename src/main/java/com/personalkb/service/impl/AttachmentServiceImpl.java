package com.personalkb.service.impl;


import com.personalkb.entity.Attachment;
import com.personalkb.mapper.AttachmentMapper;
import com.personalkb.service.AttachmentService;
import com.personalkb.utils.UserContext;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.nio.file.Files;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;


@Service
public class AttachmentServiceImpl
        implements AttachmentService {


    private final AttachmentMapper attachmentMapper;


    public AttachmentServiceImpl(
            AttachmentMapper attachmentMapper) {

        this.attachmentMapper =
                attachmentMapper;
    }



    @Override
    public void upload(
            MultipartFile file,
            Long knowledgeId) {


        try {


            String originalName =
                    file.getOriginalFilename();


            String suffix = "";


            if(originalName != null
                    && originalName.contains(".")){

                suffix =
                        originalName.substring(
                                originalName.lastIndexOf(".")
                        );
            }



            String fileName =
                    UUID.randomUUID()
                            .toString()
                            + suffix;



            String uploadPath =
                    System.getProperty("user.dir")
                            + File.separator
                            + "uploads";



            File dir =
                    new File(uploadPath);



            if(!dir.exists()){

                dir.mkdirs();
            }



            File target =
                    new File(
                            dir,
                            fileName
                    );


            file.transferTo(target);



            Attachment attachment =
                    new Attachment();


            attachment.setUserId(
                    UserContext.get()
            );


            attachment.setKnowledgeId(
                    knowledgeId
            );


            attachment.setFileName(
                    originalName
            );


            attachment.setFilePath(
                    target.getAbsolutePath()
            );


            attachment.setFileSize(
                    file.getSize()
            );



            attachmentMapper.insert(
                    attachment
            );


        } catch (Exception e) {

            e.printStackTrace();

            throw new RuntimeException(
                    "文件上传失败:" + e.getMessage()
            );
        }

    }


    @Override
    public List<Attachment> list(){

        return attachmentMapper
                .selectByUserId(
                        UserContext.get()
                );
    }



    @Override
    public void delete(
            Long id) {


        Attachment attachment =
                attachmentMapper
                        .selectById(id);



        if(attachment == null){

            throw new RuntimeException(
                    "文件不存在"
            );
        }



        File file =
                new File(
                        attachment.getFilePath()
                );


        if(file.exists()){

            file.delete();
        }



        attachmentMapper.deleteById(
                id
        );
    }

    @Override
    public void download(
            Long id,
            HttpServletResponse response
    ) throws Exception {


        Attachment attachment =
                attachmentMapper.selectById(id);


        File file =
                new File(
                        attachment.getFilePath()
                );


        response.setContentType(
                "application/octet-stream"
        );


        response.setHeader(
                "Content-Disposition",
                "attachment;filename="
                        + attachment.getFileName()
        );


        Files.copy(
                file.toPath(),
                response.getOutputStream()
        );

    }
}