package com.personalkb.mapper;

import com.personalkb.entity.Knowledge;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface KnowledgeMapper {

    int insert(Knowledge knowledge);

    List<Knowledge> selectByUserId(Long userId);

    Knowledge selectById(Long id);

    int deleteById(Long id);

    List<Knowledge> selectByCategoryId(
            @Param("userId") Long userId,
            @Param("categoryId") Long categoryId
    );

    int update(Knowledge knowledge);

    Knowledge selectByIdAndUserId(
            @Param("id") Long id,
            @Param("userId") Long userId
    );

    List<Knowledge> search(
            @Param("userId") Long userId,
            @Param("keyword") String keyword
    );

    Long countByUserId(Long userId);

    List<Knowledge> selectPage(
            @Param("userId") Long userId,
            @Param("offset") Integer offset,
            @Param("pageSize") Integer pageSize
    );
}