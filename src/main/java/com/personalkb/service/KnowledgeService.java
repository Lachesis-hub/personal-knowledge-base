package com.personalkb.service;

import com.personalkb.dto.KnowledgeAddDTO;
import com.personalkb.dto.KnowledgeUpdateDTO;
import com.personalkb.entity.Knowledge;
import com.personalkb.vo.KnowledgeListVO;
import com.personalkb.vo.PageResult;

import java.util.List;

public interface KnowledgeService {

    void add(KnowledgeAddDTO dto);

    List<KnowledgeListVO> list();

    Knowledge detail(Long id);

    void delete(Long id);

    List<KnowledgeListVO> listByCategory(
            Long categoryId
    );

    void update(
            KnowledgeUpdateDTO dto
    );

    List<KnowledgeListVO> search(
            String keyword
    );

    PageResult<KnowledgeListVO> page(
            Integer page,
            Integer pageSize
    );

}