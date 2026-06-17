package com.personalkb.mapper;


import com.personalkb.entity.Attachment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface AttachmentMapper {


    int insert(
            Attachment attachment
    );


    List<Attachment> selectByUserId(
            Long userId
    );


    Attachment selectById(
            Long id
    );


    int deleteById(
            Long id
    );

}