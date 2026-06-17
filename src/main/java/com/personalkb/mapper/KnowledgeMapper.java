package com.personalkb.mapper;

import com.personalkb.entity.Knowledge;
import com.personalkb.vo.KnowledgeListVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface KnowledgeMapper {

    int insert(Knowledge knowledge);

    List<Knowledge> selectByUserId(
            @Param("userId") Long userId
    );

    Knowledge selectById(
            @Param("id") Long id
    );

    int deleteById(
            @Param("id") Long id
    );

    List<Knowledge> selectByCategoryId(
            @Param("userId") Long userId,
            @Param("categoryId") Long categoryId
    );

    int update(Knowledge knowledge);

    /**
     * 搜索（统一 userId 在前）
     */
    List<KnowledgeListVO> search(
            @Param("userId") Long userId,
            @Param("keyword") String keyword
    );

    Long countByUserId(
            @Param("userId") Long userId
    );

    List<Knowledge> selectPage(
            @Param("userId") Long userId,
            @Param("offset") Integer offset,
            @Param("pageSize") Integer pageSize
    );

    Knowledge selectByIdAndUserId(
            @Param("id") Long id,
            @Param("userId") Long userId
    );
}