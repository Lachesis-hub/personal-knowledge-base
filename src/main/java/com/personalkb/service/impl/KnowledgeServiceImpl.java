package com.personalkb.service.impl;

import com.personalkb.dto.KnowledgeAddDTO;
import com.personalkb.dto.KnowledgeUpdateDTO;
import com.personalkb.entity.Knowledge;
import com.personalkb.mapper.KnowledgeMapper;
import com.personalkb.service.KnowledgeService;
import com.personalkb.utils.UserContext;
import com.personalkb.vo.KnowledgeListVO;
import com.personalkb.vo.PageResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KnowledgeServiceImpl implements KnowledgeService {

    private final KnowledgeMapper knowledgeMapper;


    public KnowledgeServiceImpl(
            KnowledgeMapper knowledgeMapper) {

        this.knowledgeMapper = knowledgeMapper;
    }


    @Override
    public void add(KnowledgeAddDTO dto) {

        Knowledge knowledge = new Knowledge();

        knowledge.setUserId(
                UserContext.get()
        );

        knowledge.setCategoryId(
                dto.getCategoryId()
        );

        knowledge.setTitle(
                dto.getTitle()
        );

        knowledge.setContent(
                dto.getContent()
        );

        knowledge.setSummary(
                dto.getSummary()
        );

        knowledge.setTags(
                dto.getTags()
        );


        knowledgeMapper.insert(
                knowledge
        );
    }



    @Override
    public List<KnowledgeListVO> list() {

        List<Knowledge> list =
                knowledgeMapper.selectByUserId(
                        UserContext.get()
                );


        return convertToVO(list);
    }



    @Override
    public List<KnowledgeListVO> listByCategory(
            Long categoryId) {


        List<Knowledge> list =
                knowledgeMapper.selectByCategoryId(
                        UserContext.get(),
                        categoryId
                );


        return convertToVO(list);
    }



    @Override
    public Knowledge detail(Long id) {

        return knowledgeMapper.selectByIdAndUserId(
                id,
                UserContext.get()
        );
    }



    @Override
    public void delete(Long id) {

        Knowledge knowledge =
                knowledgeMapper.selectByIdAndUserId(
                        id,
                        UserContext.get()
                );


        if (knowledge == null) {
            throw new RuntimeException("知识不存在");
        }


        knowledgeMapper.deleteById(id);
    }



    @Override
    public void update(
            KnowledgeUpdateDTO dto) {


        Knowledge exist =
                knowledgeMapper.selectByIdAndUserId(
                        dto.getId(),
                        UserContext.get()
                );


        if (exist == null) {
            throw new RuntimeException("知识不存在");
        }


        Knowledge knowledge =
                new Knowledge();


        knowledge.setId(
                dto.getId()
        );


        knowledge.setCategoryId(
                dto.getCategoryId()
        );


        knowledge.setTitle(
                dto.getTitle()
        );


        knowledge.setContent(
                dto.getContent()
        );


        knowledge.setSummary(
                dto.getSummary()
        );


        knowledge.setTags(
                dto.getTags()
        );


        knowledgeMapper.update(
                knowledge
        );
    }



    @Override
    public List<KnowledgeListVO> search(
            String keyword) {


        Long userId =
                UserContext.get();


        System.out.println(
                "搜索用户ID=" + userId
        );


        System.out.println(
                "搜索关键词=" + keyword
        );


        return knowledgeMapper.search(
                userId,
                keyword
        );
    }




    @Override
    public PageResult<KnowledgeListVO> page(
            Integer page,
            Integer pageSize) {


        Long userId =
                UserContext.get();


        //计算偏移量
        Integer offset =
                (page - 1) * pageSize;


        //查询总数
        Long total =
                knowledgeMapper.countByUserId(
                        userId
                );


        //查询分页数据
        List<Knowledge> list =
                knowledgeMapper.selectPage(
                        userId,
                        offset,
                        pageSize
                );


        List<KnowledgeListVO> records =
                convertToVO(list);



        PageResult<KnowledgeListVO> result =
                new PageResult<>();


        result.setTotal(
                total
        );


        result.setRecords(
                records
        );


        return result;
    }


    private List<KnowledgeListVO> convertToVO(
            List<Knowledge> knowledgeList) {


        List<KnowledgeListVO> result =
                new ArrayList<>();


        for (Knowledge knowledge : knowledgeList) {


            KnowledgeListVO vo =
                    new KnowledgeListVO();


            vo.setId(
                    knowledge.getId()
            );


            vo.setCategoryId(
                    knowledge.getCategoryId()
            );


            vo.setTitle(
                    knowledge.getTitle()
            );


            vo.setCreateTime(
                    knowledge.getCreateTime()
            );


            result.add(vo);
        }


        return result;
    }
}