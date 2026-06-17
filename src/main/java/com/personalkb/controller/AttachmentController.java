package com.personalkb.controller;


import com.personalkb.common.Result;
import com.personalkb.entity.Attachment;
import com.personalkb.service.AttachmentService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;


@RestController
@RequestMapping("/attachment")
public class AttachmentController {


    private final AttachmentService attachmentService;


    public AttachmentController(
            AttachmentService attachmentService){

        this.attachmentService =
                attachmentService;
    }



    @PostMapping(
            value = "/upload",
            consumes = "multipart/form-data"
    )
    public Result<Void> upload(

            @RequestParam("file")
            MultipartFile file,

            @RequestParam(required = false)
            Long knowledgeId
    ){

        attachmentService.upload(
                file,
                knowledgeId
        );


        return Result.success(null);
    }





    @GetMapping("/list")
    public Result<List<Attachment>> list(){


        return Result.success(
                attachmentService.list()
        );
    }


    @DeleteMapping("/{id}")
    public Result<Void> delete(
            @PathVariable Long id){


        attachmentService.delete(
                id
        );


        return Result.success(null);
    }

    @GetMapping("/download/{id}")
    public void download(
            @PathVariable Long id,
            HttpServletResponse response
    ) throws Exception {


        attachmentService.download(
                id,
                response
        );

    }

}